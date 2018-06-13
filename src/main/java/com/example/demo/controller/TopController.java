package com.example.demo.controller;

import com.example.demo.entity.Group;
import com.example.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 003418
 */
@Controller
public class TopController {

    @Autowired
    private GroupService groupService;

    @RequestMapping("/")
    public String top(Model model){

        return "top";
    }

    @RequestMapping(value = "/postData", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity.BodyBuilder postData(@RequestBody Group groupData){
        groupService.saveData(groupData);
        return ResponseEntity.ok();
    }
}
