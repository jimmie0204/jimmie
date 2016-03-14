package com.jimmie.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Bpplication {

  @RequestMapping("/testb")
  public String homeb() {
    return "Hellob";
  }
  
  @RequestMapping("/")
  public String home() {
    return "Hello";
  }

}