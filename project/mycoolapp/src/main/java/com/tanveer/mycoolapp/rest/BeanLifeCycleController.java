package com.tanveer.mycoolapp.rest;

import com.tanveer.mycoolapp.coach.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("BeanLifeCycleController")
public class BeanLifeCycleController {

    private final Coach coach;

    @Autowired
    public BeanLifeCycleController(@Qualifier("footballCoach") Coach coach) {
        this.coach = coach;
    }

}
