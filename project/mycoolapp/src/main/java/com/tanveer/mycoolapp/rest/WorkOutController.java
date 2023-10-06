package com.tanveer.mycoolapp.rest;

import com.tanveer.mycoolapp.coach.Coach;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("DailyWorkOut")
@Log4j2
public class WorkOutController {

    private  Coach coach;

    /*          used with @Qualifier with constructor injection     */

//    @Autowired
//    public WorkOutController(@Qualifier("trackCoach") Coach coach) {
//        this.coach = coach;
//    }

    /*          used with @Qualifier  with setter injection   */

//    @Autowired
//    public void setCoach(@Qualifier("tennisCoach") Coach mycoach){
//        this.coach=mycoach;
//    }

    /*          used with @Primary  annotation at class level    */

    /* @Qualifier is higher priority then @Primary */
    @Autowired
    public WorkOutController(@Qualifier("trackCoach")Coach coach) {
        log.info("inside a WorkOutController : {}",getClass().getSimpleName());
        this.coach = coach;
    }
    @GetMapping("daily")
    public String getDailyWorkOut(){
        return coach.getDailyWorkOut();
    }


}
