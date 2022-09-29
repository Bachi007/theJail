package com.theJail.serviceImpl;

import org.apache.log4j.Logger;

import com.theJail.service.userdashboard;


public class userdashboardImpl implements userdashboard{

	static Logger log=Logger.getLogger(userdashboardImpl.class);

	@Override
	public void dashboard() {
		
		log.info("\t\t-----------------------welcome to user dashboard--------------------");
	}




}
