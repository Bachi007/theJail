package com.theJail.serviceImpl;

import org.apache.log4j.Logger;

import com.theJail.service.admindashboard;

public class admindashboardimpl implements admindashboard {
	static Logger log=Logger.getLogger(userdashboardImpl.class);

	@Override
	public void dashboard() {
		
		log.info("\t\t---------------------------welcome to Admin Dashboard--------------------");
	}

}
