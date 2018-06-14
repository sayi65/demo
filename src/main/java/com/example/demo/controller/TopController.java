package com.example.demo.controller;

import com.example.demo.entity.Group;
import com.example.demo.service.GroupService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 003418
 */
@Controller
public class TopController {

    @Autowired
    private GroupService groupService;

    private HttpHeaders headers = new HttpHeaders();

    private HashMap<Integer, List<Integer>> resultData;

    @RequestMapping("/")
    public String top(Model model){

        return "top";
    }

    @RequestMapping(value = "/postData",
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> postData(@RequestBody Group groupData, BindingResult result){
        if(result.hasErrors()){

            return (ResponseEntity<?>) ResponseEntity.badRequest();
        } else {
            resultData = groupService.saveData(groupData);
            return ResponseEntity.ok(resultData);
        }

    }
}
