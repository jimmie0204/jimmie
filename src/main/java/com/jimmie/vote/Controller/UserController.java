package com.jimmie.vote.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jimmie.pojo.Grade;
import com.jimmie.pojo.User;


@RestController  
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
    
    @RequestMapping("/getAll")  
    public List<String> getAll() {  
    	List<String> pList = new ArrayList<String>();
    	
    	return pList;
    }  
  
}  