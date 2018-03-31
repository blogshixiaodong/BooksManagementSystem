package com.bms.exception;

public interface ErrorList {
	
	//book  error
	static final String DATE_FORMAT_ERROR = "日期格式错误!请使用2015-01-01格式";
	static final String NOT_NULL = "信息不完整";
	static final String NO_RECORD = "找不到记录";
	static final String NAGETIVE_NUMBER = "不允许负值项";
	static final String NO_CONDITION = "请输入条件";
	static final String PATTERN_ERROR = "存在不合法格式";
	/*static final String CREATE_ERR_KEY = "Create Failed";
	static final String UPDATE_ERR_KEY = "Update Failed";
	static final String DELETE_ERR_KEY = "Delete Failed";*/
	
	static final String USER_FREEZE = "您存在非法操作，用户被占时冻结";
	static final String BORROW_TIME_OVER = "您有超期图书";
	static final String BORROW_NUM_OVER = "您借阅数量达到最大值";
	static final String STOCK_DEFICIENCY = "抱歉，库存不足";
	
	

}
