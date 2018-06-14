package com.example.demo.service;

import com.example.demo.entity.Group;
import com.example.demo.util.ConstUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.bcel.Const;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author sai
 */
@Service
@Slf4j
public class GroupService {

    private HashMap<Integer, List<Integer>> dataMap = new HashMap<>();

    public HashMap<Integer, List<Integer>> saveData(Group groupData) {

        List<Integer> valList = new ArrayList<>();
        if (dataMap.containsKey(groupData.getGroup())) {
            if (dataMap.get(groupData.getGroup()).contains(groupData.getId())){
                log.warn("exist the data");
            } else {
                dataMap.get(groupData.getGroup()).add(groupData.getId());
            }

        } else {
            valList.add(groupData.getId());
            dataMap.put(groupData.getGroup(), valList);
        }

        return dataMap;
    }

}
