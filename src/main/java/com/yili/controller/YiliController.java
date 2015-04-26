package com.yili.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yili.dao.ShopRepository;
import com.yili.dao.UserRepository;
@Controller
public class YiliController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ShopRepository shopRepository;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        return "index";
    }

}
