package com.tanveer.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${developer.name}")
    private String name;
    @Value("${team.name}")
    private String team;

    @GetMapping("/hii")
    public String sayHello(){
        return "HELLO SPRING BOOT....";
    }

    @GetMapping("/bye")
    public String sayBye(){
        return "BYE SPRING BOOT....123";
    }

    @GetMapping("/team")
    public String teamInfo(){
            return "NAME :"+ name + ",TEAM : "+ team;
    }

}
