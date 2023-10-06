package com.tanveer.mycoolapp.coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FootballCoach implements Coach{

    /*
             1 : Define your methods for init() and destroy().
             2 : Add annotaions : @PostConstruct and @PreDestroy.
     */

//  define init() method
    @PostConstruct
    public void doMyInit(){
        System.out.println("In doMyInit() :"+getClass().getSimpleName());
    }

//  define destroy() method
    @PreDestroy
    public void doMyDestroy(){
        System.out.println("In doMyDestroy() :"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "daily do football coaching for 4 hours................";
    }


}
