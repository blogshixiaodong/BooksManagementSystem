package com.bms.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import com.bms.server.IRecordServer;
import com.bms.server.impl.RecordServerImpl;

/**
 *  date : 2018年3月30日	
 * author: jiangjiamin
 * 
 */
@WebListener
public class UserFreezeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		 String name = event.getName();
         if("uid".equals(name)) {
        	 Integer uid = (Integer)event.getValue();
        	 IRecordServer recordServer = new RecordServerImpl();
        	//检查是否应为超期状态
        	 recordServer.checkUserFreezeStatus(uid);
         }
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

    
   
	
}
