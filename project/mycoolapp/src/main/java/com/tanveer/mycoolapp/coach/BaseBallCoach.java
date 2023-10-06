package com.tanveer.mycoolapp.coach;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Log4j2
//@Lazy
public class BaseBallCoach implements Coach{

    public BaseBallCoach(){
        log.info("inside a BaseBallCoach : {}",getClass().getSimpleName());

    }
    @Override
    public String getDailyWorkOut() {
        return "daily do baseBall practice for 4 hours";
    }
}
