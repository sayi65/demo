package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author 003418
 */
@Slf4j
@Data
public class Group implements Serializable {

    @Getter
    @Setter
    private Integer group;

    @Getter
    @Setter
    private Integer id;
}
