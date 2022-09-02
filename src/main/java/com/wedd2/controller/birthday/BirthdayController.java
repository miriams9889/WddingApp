package com.wedd2.controller.birthday;


import com.wedd2.service.BirthdayService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BirthdayController {
    private final BirthdayService service;
    public BirthdayController(BirthdayService service) {this.service = service;}
    @GetMapping("/birthday")
    public String birthday(){
        return "birthday";
    }

}
