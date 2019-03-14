package com.mypackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mypackage.dao.Impl.UserDao;
import com.mypackage.model.T_User;


@Controller
public class RegistrationController {

	@RequestMapping("/register")
	public ModelAndView register(@RequestParam("username") String username,
						 @RequestParam("firstname") String firstname,
						 @RequestParam("lastname") String lastname,
						 @RequestParam("password") String password,
						 @RequestParam("email") String email
						 ){
		
		T_User newUser = new T_User();
		newUser.setUsername(username);
		newUser.setFirstname(firstname);
		newUser.setLastname(lastname);
		newUser.setPassword(password);
		newUser.setEmail(email);
		
		UserDao userDao = new UserDao();
		userDao.create(newUser);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userInfo.jsp");
		mv.addObject("user", newUser);
		
		return mv;
		
		
	}
}
