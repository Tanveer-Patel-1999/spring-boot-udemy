package com.tanveer.mycoolapp.rest;

import com.tanveer.mycoolapp.coach.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("BeanScopeController")
public class BeanScopeController {

    private final Coach coach1;

    private final Coach coach2;

    /*      check to see if this is the same bean
            True or false depending on the bean scope

            singleton : true
            prototype : false
    */

    @Autowired
    public BeanScopeController( @Qualifier("cricketCoach") Coach coach1, @Qualifier("cricketCoach") Coach coach2) {
        this.coach1 = coach1;
        this.coach2 = coach2;
    }


    @GetMapping("check")
    public String checkScope(){
        return "comparing beans : coach1 == coach2 : "+ (coach1 == coach2);
    }
}
