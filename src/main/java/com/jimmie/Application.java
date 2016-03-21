package com.jimmie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jimmie.vote.util.ExcelUtil;


@Configuration  
@ComponentScan  
@EnableAutoConfiguration  
public class Application {  
    public static void main(String[] args) {
    	for(int i =0;i<args.length;i++){
    		System.out.println("======"+args[i]);
    	}
    	System.out.println("==========小李子==================");
        SpringApplication.run(Application.class);  
    }  
}