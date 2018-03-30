package com.bms.server.impl;

import java.sql.SQLException;
import java.util.List;
import com.bms.bean.User;
import com.bms.dao.impl.BookDaoImpl;
import com.bms.dao.impl.RecordDaoImpl;
import com.bms.dao.impl.UserDaoImpl;
import com.bms.server.IRecordServer;

/**
 *  date : 2018年3月29日	
 * author: jiangjiamin
 * 
 */
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
			//开启事务
			beginTranscation();
			//1. user 状态是否冻结
			User user = userDaoImpl.getUserById(uid);
			if(user.getIs_freeze() == 1) {
				return "The user is frozen";
			}
			
			//2. user 是否有超期
			if(recordDaoImpl.hasOverTimeBook(uid)) {
				user.setIs_freeze(1);
				return "Book borrow time over";
			}
			
			//3. user 已借的数量
			Integer count = recordDaoImpl.borrowBookCount(uid);
			if(count >= 5) {
				user.setIs_freeze(1);
				return "The number of borrowing is greater than 5";
			}
			
			//4.是否有库存 --->可能不必要
			if(!bookDaoImpl.hasStock(bid)) {
				return "Book stock deficiency";
			}
			
			//5. 创建借书记录
			recordDaoImpl.addRecord(uid, bid);
			bookDaoImpl.updateStock(bid,"-");
			commitTranscation();
			return "Success";
		}catch (SQLException e) {
			e.printStackTrace();
			//异常，回滚事物
			rollbackTranscation();
		}finally {
			//关闭资源
			closeQuery();
		}
		//未知错误
		return "抱歉，系统异常，请重新借阅！";
	}

	@Override
	public boolean returnBook(Integer bid,Integer uid,Integer rid) {
		
		int flag = 0;//标志归还是否成功
		try {
			beginTranscation();
			
			//获得要归还这本书的借阅时间
			int count = recordDaoImpl.borrowTime(uid, bid);
			User user = userDaoImpl.getUserById(uid);
			float money;
			
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
			commitTranscation();
			//判断用户是否还存在超期图书，如果存在冻结用户
			if(recordDaoImpl.hasOverTimeBook(uid)) {
				user.setIs_freeze(1);
			}else {
				user.setIs_freeze(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTranscation();
		}finally {
			closeQuery();
		}
		
		if(flag == 1) {
			return true;
		}
		
		return false;
	}

	//通过用户id获取book表和record表连接之后需要的字段链表
	@Override
	public List<Object[]> getRecordByUserId(Integer uid){
		try {
			return recordDaoImpl.getRecordByUserId(uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setUserFreezeStatus(Integer uid) {
		
		try {
			//是否是冻结状态
			if(!userDaoImpl.isFreeze(uid)) {
				if(recordDaoImpl.hasOverTimeBook(uid)) {
					//userDaoImpl.update  --> 修改状态
					return;
				}
				if(recordDaoImpl.borrowBookCount(uid) >= 5) {
					//userDaoImpl.update -->修改状态
					return;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void beginTranscation() throws SQLException {
		recordDaoImpl.getConnection().setAutoCommit(false);
		userDaoImpl.getConnection().setAutoCommit(false);
		bookDaoImpl.getConnection().setAutoCommit(false);
	}

	
	private void commitTranscation() {
		try {
			recordDaoImpl.getConnection().commit();
			userDaoImpl.getConnection().commit();
			bookDaoImpl.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void rollbackTranscation() {
		try {
			recordDaoImpl.getConnection().rollback();
			userDaoImpl.getConnection().rollback();
			bookDaoImpl.getConnection().rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void closeQuery() {
		bookDaoImpl.closeQuickly();
		recordDaoImpl.closeQuickly();
		bookDaoImpl.closeQuickly();
	}
	
}
