package com.example.demo.service;

import com.example.demo.entity.Group;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sai
 */
@Service
public class GroupService {

    private HashMap<Integer, List<Integer>> dataMap = new HashMap<>();
    private List<Integer> valList = new ArrayList<>();

    public void saveData(Group groupData){

        if (dataMap.isEmpty()){
            valList.add(groupData.getId());
            dataMap.put(groupData.getGroup(), valList);
        } else {
            for (Map.Entry<Integer, List<Integer>> entry :dataMap.entrySet()){
                if (entry.getKey() == groupData.getGroup()){
                    entry.getValue().add(groupData.getId());
                    return;
                } else {
                    continue;
                }
            }
        }

    }

}
