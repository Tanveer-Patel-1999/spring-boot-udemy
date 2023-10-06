package com.tanveer.mycoolapp.coach;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class TennisCoach implements Coach{

    public TennisCoach(){
        log.info("inside a TennisCoach : {}",getClass().getSimpleName());

    }

    @Override
    public String getDailyWorkOut() {
        return "daily practice of Tennis 2 hours........................";
    }
}
