package com.bms.server.impl;

import java.sql.SQLException;
import java.util.List;

import com.bms.bean.Record;
import com.bms.bean.User;
import com.bms.dao.impl.BookDaoImpl;
import com.bms.dao.impl.RecordDaoImpl;
import com.bms.dao.impl.UserDaoImpl;
import com.bms.server.IRecordServer;

import jdk.nashorn.internal.ir.Flags;

public class RecordServerImpl implements IRecordServer {
	private RecordDaoImpl recordDaoImpl = new RecordDaoImpl();
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	private BookDaoImpl bookDaoImpl = new BookDaoImpl();
	
	//借阅图书
	//1 用户被冻结   2借阅数量达到最大值  3.图书超期  4.库存不足  
	//0 借阅成功
	@Override
	public String addRecord(Integer uid,Integer bid){
		
		try {
			//1. user 状态
			User user = userDaoImpl.getUserById(uid);
			if(user.getIs_freeze() == 1) {
				return "The user is frozen";
			}
			
			//2. user 已借的数量
			Integer count = recordDaoImpl.borrowBookCount(uid);
			if(count >= 5) {
				user.setIs_freeze(1);
				return "The number of borrowing is greater than 5";
			}
			
			//3. user 是否有超期
			if(recordDaoImpl.hasOverTimeBook(uid)) {
				user.setIs_freeze(1);
				return "Book borrow time over";
			}
			
			//4.是否有库存 --->可能不必要
			if(!bookDaoImpl.hasStock(bid)) {
				return "Book stock deficiency";
			}
			
			//5. 创建借书记录
			recordDaoImpl.addRecord(uid, bid);
			bookDaoImpl.updateStock(bid,"-");
			return "Success";
		}catch (SQLException e) {
			//应该使用事务！！！！！
			e.printStackTrace();
		}
		//未知错误
		return "error";
	}

	
	
	@Override
	public boolean returnBook(Integer bid,Integer uid,Integer rid) {
		
		int flag = 0;//标志归还是否成功
		try {

			//该用户这本书时候有超期，若超期余额是否足够
			
			//获得要归还这本书的借阅时间
			int count = recordDaoImpl.borrowTime(uid, bid);
			float money;
			User user = userDaoImpl.getUserById(uid);
			
			//该书超期，计算金额
			if(count >= 60) {
				money = (count - 60) * 0.1f;
				if(user.getBalance() > money) {
					
					userDaoImpl.updateBalance(uid, -money);
					recordDaoImpl.updateRecord(rid);
					bookDaoImpl.updateStock(bid,"+");
					flag = 1;
				}
				
			}else {
				//借阅时间未达到60天，直接归还
				recordDaoImpl.updateRecord(rid);
				bookDaoImpl.updateStock(bid,"+");
				flag = 1;
			}
			
			//判断用户是否还存在超期图书，如果存在冻结用户
			if(recordDaoImpl.hasOverTimeBook(uid)) {
				user.setIs_freeze(1);
			}else {
				user.setIs_freeze(0);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag == 1) {
			return true;
		}
		
		return false;
	}


	@Override
	public List<Object[]> getRecordByUserId(Integer uid){
		
		try {
			return recordDaoImpl.getRecordByUserId(uid);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return null;
	}

}
