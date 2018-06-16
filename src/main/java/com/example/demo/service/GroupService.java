package com.example.demo.service;

import com.example.demo.entity.Group;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author sai
 */
@Service
@Slf4j
public class GroupService {

    private HashMap<Integer, List<Integer>> dataMap = new HashMap<>();

    /**
     * 入力データをメモリに保存
     * @param groupData
     * @return
     */
    public HashMap<Integer, List<Integer>> saveData(Group groupData) {

        List<Integer> valList = new ArrayList<>();
        //キー存在チェック
        if (dataMap.containsKey(groupData.getGroup())) {
            //同じに値がvalueに存在チェック
            if (dataMap.get(groupData.getGroup()).contains(groupData.getId())){
                log.warn("exist the data");
            } else {
                dataMap.get(groupData.getGroup()).add(groupData.getId());
                Collections.sort(dataMap.get(groupData.getGroup()));
            }

        } else {
            valList.add(groupData.getId());
            dataMap.put(groupData.getGroup(), valList);
        }

        return dataMap;
    }

}
