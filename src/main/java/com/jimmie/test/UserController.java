package com.jimmie.test;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jimmie.pojo.Grade;
import com.jimmie.pojo.User;


@RestController  
@RequestMapping("/user")  
public class UserController {  
  
    @RequestMapping("/{id}")  
    public User view(@PathVariable("id") Long id) {  
        User user = new User();  
        user.setId(id);  
        user.setName("zhang");  
        return user;  
    }  
    
    @RequestMapping("/grade/{id}")  
    public Grade view2(Grade grade,@PathVariable("id") Long id) {  
    	
        User user = new User();  
        user.setId(id);  
        user.setName("zhang");  
        
        grade.getUser().add(user);
        return grade;  
    }  
  
}  