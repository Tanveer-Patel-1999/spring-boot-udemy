package com.tanveer.mycoolapp.coach;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class TrackCoach implements Coach{

    public TrackCoach(){
        log.info("inside a TrackCoach : {}",getClass().getSimpleName());

    }
    @Override
    public String getDailyWorkOut() {
        return "daily do running for 2 hours.....................";
    }
}
