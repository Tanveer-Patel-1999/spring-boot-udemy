package com.relation.onetomany.controller;

import com.relation.onetomany.model.HostelRequest;
import com.relation.onetomany.model.HostelResponse;
import com.relation.onetomany.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HostelController {

    private final HostelService hostelService ;

    @Autowired
    public HostelController(HostelService hostelService) {
        this.hostelService = hostelService;
    }

    @GetMapping(path = "/hostels",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HostelRequest>> getAllHostel(){
        return new ResponseEntity<>( hostelService.getAllHostel(), HttpStatus.OK);
    }
    @GetMapping(path = "/hostels/{hostelId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HostelRequest>getHostel(@PathVariable Long hostelId){
        return new ResponseEntity<>( hostelService.getHostel(hostelId),HttpStatus.OK) ;
    }
    @PostMapping(path = "/hostels",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HostelResponse>createHostel(@RequestBody HostelRequest hostelRequest){
        return new ResponseEntity<>( hostelService.create(hostelRequest), HttpStatus.CREATED);
    }
    @PutMapping(path = "/hostels/{hostelId}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HostelRequest>createHostel(@RequestBody HostelRequest hostelRequest,@PathVariable Long hostelId ){
        return new ResponseEntity<>( hostelService.updateHostel(hostelId,hostelRequest), HttpStatus.CREATED);
    }
    @PutMapping("/hostels/{hostelId}/student/{studentId}")
    public ResponseEntity<Void> assign(@PathVariable Long hostelId,@PathVariable Long studentId){
        hostelService.assignment(hostelId,studentId);
        return  ResponseEntity.ok().build() ;
    }
    @DeleteMapping("/hostels/{hostelId}")
    public ResponseEntity<Void>deleteHostel(@PathVariable Long hostelId){
        hostelService.deleteHostel(hostelId);
        return  ResponseEntity.ok().build() ;
    }

}