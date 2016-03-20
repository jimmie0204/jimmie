package com.jimmie.vote.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jimmie.vote.util.ExcelUtil;


@RestController  
public class AccountController {  
    
    @RequestMapping("/getAll")  
    public List<String> getAll() {  
    	List<String> pList = new ArrayList<String>();
    	pList = (List<String>) ExcelUtil.getList();
    	return pList;
    }  
  
}  