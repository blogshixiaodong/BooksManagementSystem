package com.bms.server.impl;

import java.sql.SQLException;
import java.util.List;
import com.bms.bean.User;
import com.bms.dao.impl.BookDaoImpl;
import com.bms.dao.impl.RecordDaoImpl;
import com.bms.dao.impl.UserDaoImpl;
import com.bms.exception.ErrorList;
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
	@Override
	public String addRecord(Integer uid,Integer bid){
		try {
			//开启事务
			beginTranscation();
			//1. user 状态是否冻结
			User user = userDaoImpl.getUserById(uid);
			if(user.getIs_freeze() == 1) {
				return ErrorList.USER_FREEZE;
			}
			
			//2. user 是否有超期
			if(recordDaoImpl.hasOverTimeBook(uid)) {
				user.setIs_freeze(1);
				return ErrorList.BORROW_TIME_OVER;
			}
			
			//3. user 已借的数量
			Integer count = recordDaoImpl.borrowBookCount(uid);
			if(count >= 5) {
				user.setIs_freeze(1);
				return ErrorList.BORROW_NUM_OVER;
			}
			
			//4.是否有库存 --->可能不必要
			if(!bookDaoImpl.hasStock(bid)) {
				return ErrorList.STOCK_DEFICIENCY;
			}
			
			//5. 创建借书记录
			recordDaoImpl.addRecord(uid, bid);
			bookDaoImpl.updateStock(bid,"-");
			
			//6.借阅成功之后，如果借阅数量达到5本，冻结账户
			if(recordDaoImpl.borrowBookCount(uid) >= 5) {
				userDaoImpl.updateStatus(uid, 1);
			}
			
			commitTranscation();
			return "Success";
		}catch (SQLException e) {
			e.printStackTrace();
			//异常，回滚事务
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
		boolean result = false;
		try {
			beginTranscation();
			//获得要归还这本书的借阅时间
			int day = recordDaoImpl.borrowTime(rid);
			User user = userDaoImpl.getUserById(uid);
			float money;
			//该书超期，计算金额
			if(day >= 60) {
				money = (day - 60) * 0.1f;
				if(user.getBalance() > money) {
					userDaoImpl.updateBalance(uid, -money);
					recordDaoImpl.updateRecord(rid);
					bookDaoImpl.updateStock(bid,"+");
					result = true;
				}
			}else {
				//借阅时间未达到60天，直接归还
				recordDaoImpl.updateRecord(rid);
				bookDaoImpl.updateStock(bid,"+");
				result = true;
			}
			//判断用户是否还存在超期图书及借阅数量，如果存在冻结用户
			if(!recordDaoImpl.hasOverTimeBook(uid) && recordDaoImpl.borrowBookCount(uid) <5) {
				userDaoImpl.updateStatus(uid, 0);
			}else {
				userDaoImpl.updateStatus(uid,1);
			}
			//提交事务
			commitTranscation();
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTranscation();
		}finally {
			closeQuery();
		}
		return result;
	}
	
	
	//借阅记录
	public List<Object[]> getHistoryRecordByUserId(Integer uid){
		List<Object[]> list = null;
		try {
			list = recordDaoImpl.getRecordByUserId(uid,"NOT");
			if(list.size() == 0) {
				list = null;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//通过用户id获取book表和record表连接之后需要的字段链表
	@Override
	public List<Object[]> getRecordByUserId(Integer uid){
		List<Object[]> list = null;
		try {
			list =  recordDaoImpl.getRecordByUserId(uid,"");
			if(list.size() == 0) {
				list = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void checkUserFreezeStatus(Integer uid) {
		try {
			//是否是冻结状态
			if(!userDaoImpl.isFreeze(uid)) {
				//是否存在超期图书
				if(recordDaoImpl.hasOverTimeBook(uid)) {
					userDaoImpl.updateStatus(uid, 1);
					return;
				}
				//借阅数量是否达到最大值
				if(recordDaoImpl.borrowBookCount(uid) >= 5) {
					userDaoImpl.updateStatus(uid,1);
					return;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//开启事务
	private void beginTranscation() throws SQLException {
		recordDaoImpl.getConnection().setAutoCommit(false);
		userDaoImpl.getConnection().setAutoCommit(false);
		bookDaoImpl.getConnection().setAutoCommit(false);
	}

	//提交事务
	private void commitTranscation() {
		try {
			recordDaoImpl.getConnection().commit();
			userDaoImpl.getConnection().commit();
			bookDaoImpl.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//回滚事务
	private void rollbackTranscation() {
		try {
			recordDaoImpl.getConnection().rollback();
			userDaoImpl.getConnection().rollback();
			bookDaoImpl.getConnection().rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//关闭资源
	private void closeQuery() {
		bookDaoImpl.closeQuickly();
		recordDaoImpl.closeQuickly();
		bookDaoImpl.closeQuickly();
	}
	
}
