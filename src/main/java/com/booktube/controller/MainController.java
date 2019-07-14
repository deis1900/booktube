package com.booktube.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String getPage(){
        return "index";
    }

    @GetMapping("/ hello")
    @ResponseBody
    public String sayHello(){
        return "HEllo";
    }

}
