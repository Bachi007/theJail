//service layer
package com.theJail.serviceImpl;

import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.theJail.App;
import com.theJail.dao.theJaildao;
import com.theJail.daoImpl.theJaildaoImpl;
import com.theJail.exception.GlobalException;
import com.theJail.model.user;
import com.theJail.service.admindashboard;
import com.theJail.service.loginregister;
import com.theJail.service.userdashboard;

public class loginregisterImpl implements loginregister {
	static Logger log=Logger.getLogger(App.class);
	static theJaildao dao=new theJaildaoImpl();
	static Scanner bs=new Scanner(System.in);
	@Override
	//registration process 
	public void registration()throws GlobalException {

		log.info("welcome to registration");
		user u1=new user();
		log.info("Enter username");
		String name=bs.next();
		log.info("Create password");
		String pwd=bs.next();
		log.info("Enter Phone");
		String phone=bs.next();
		log.info("Enter Address");
		String adr=bs.next();
		
		u1.setUserName(name);
		u1.setUserAddress(adr);
		u1.setUserPhone(phone);
		u1.setUserPassword(pwd);
		u1.setUserRole("student");
		u1.setUserFee(0);
		u1.setUserRoom(null);
		//validating user data
		if(Pattern.matches("[a-zA-Z]{4,}", name)&&Pattern.matches("[0-9]{10}", phone)&&Pattern.matches("[a-zA-Z0-9@#]{6,}", pwd))
		{
			//inserting user data
		int status=dao.registration(u1);	
		if(status==1) {
			log.info("registration success");
		}
	}
		else {
			throw new GlobalException("Invalid  data");
		}
	}
	@Override
	public void login() throws GlobalException {
		
		log.info("Enter username");
		String uname=bs.next();
		log.info("Enter Password");
		String upwd=bs.next();
		//calling dao login method
		user u1=dao.login(uname, upwd);
		userdashboard udl=new userdashboardImpl();
		admindashboard adl=new admindashboardimpl();
		
		if(u1!=null) {
			log.info("Hey "+u1.getUserName()+" login success");
			
			if(u1.getUserRole().equals("student")) {
				udl.dashboard();
			}
			else if (u1.getUserRole().equals("admin")) {
				adl.dashboard();
			}
			
			
		}
		
	}

}
