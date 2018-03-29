package com.bms.server.impl;

import java.sql.SQLException;
import java.util.List;

import com.bms.bean.Record;
import com.bms.bean.User;
import com.bms.dao.impl.BookDaoImpl;
import com.bms.dao.impl.RecordDaoImpl;
import com.bms.dao.impl.UserDaoImpl;
import com.bms.server.IRecordServer;

public class RecordServerImpl implements IRecordServer {
	private RecordDaoImpl recordDaoImpl = new RecordDaoImpl();
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	private BookDaoImpl bookDaoImpl = new BookDaoImpl();
	
	//借阅图书
	@Override
	public boolean addRecord(Integer uid,Integer bid){
		
		try {
			//1. user 状态
			User user = userDaoImpl.getUserById(uid);
			if(user.getIs_freeze() == 1) {
				return false;
			}
			
			//2. user 已借的数量
			Integer count = recordDaoImpl.borrowBookCount(uid);
			if(count >= 5) {
				user.setIs_freeze(1);
				return false;
			}
			
			//3. user 是否有超期
			if(recordDaoImpl.hasOverTimeBook(uid)) {
				user.setIs_freeze(1);
				return false;
			}
			
			//4.是否有库存 --->可能不必要
			if(!bookDaoImpl.hasStock(bid)) {
				return false;
			}
			
			//5. 创建借书记录
			recordDaoImpl.addRecord(uid, bid);
			bookDaoImpl.updateStock(bid,"-");
			return true;
		}catch (SQLException e) {
			//应该使用事务！！！！！
		}
		
		return false;
	}

	
	
	@Override
	public boolean returnBook(Integer bid,Integer uid,Integer rid) {
		try {
			//该用户这本书时候有超期，若超期余额是否足够
			//获得借阅时间
			int count = recordDaoImpl.borrowTime(uid, bid);
			float money;
			
			//该书超期，计算金额
			if(count >= 60) {
				money = count * 0.1f;
				User user = userDaoImpl.getUserById(uid);
				if(user.getBalance() > money) {
					user.setBalance(user.getBalance() - money);
					
					recordDaoImpl.updateRecord(rid);
					bookDaoImpl.updateStock(bid,"+");
				}
				
			}else {
				//借阅时间未达到60天，直接归还
				recordDaoImpl.updateRecord(rid);
				bookDaoImpl.updateStock(bid,"+");
				return true;
			}
		} catch (Exception e) {
			
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
