package com.mypackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mypackage.dao.Impl.UserDao;
import com.mypackage.model.T_User;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("usernameLogin") String username,
								@RequestParam("passwordLogin") String password) {
		
		System.out.println(">>>username: " + username);
		System.out.println(">>>pw: " + password);
		
		UserDao userDao = new UserDao();
		T_User foundUser = userDao.userByUsernameAndPassword(username, password);
		
		System.out.println(">>>userByUsernameAndPW: " + foundUser);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userInfo.jsp");
		mv.addObject("user", foundUser);
		
		return mv;
		
	}
}
