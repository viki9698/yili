package com.yili.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yili.dao.Shop;
import com.yili.dao.ShopRepository;
import com.yili.dao.User;
import com.yili.dao.UserRepository;
@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private static AtomicLong counter = new AtomicLong();
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ShopRepository shopRepository;

	@RequestMapping("/greeting")
	public Set<Shop> greeting(@RequestParam(value="name",defaultValue="world") String name) {
		//return new Greeting(counter.incrementAndGet(), String.format(template, name));
		userRepository.deleteAll();
		shopRepository.deleteAll();
		
		Shop shop1 = new Shop("shop1", "shop1's desc");
		Shop shop2 = new Shop("shop5", "shop2's desc");
		
		Set<Shop> list = new HashSet<Shop>();
		list.add(shop1);
		list.add(shop2);
		
		User user = new User("chris", "chirs", "chriszhangrui@Outlook.com");
		user.setShops(list);
		
		shopRepository.save(list);
		userRepository.save(user);
		
		return userRepository.findAll().get(0).getShops();

		//return userRepository.findAll();
	}
}
