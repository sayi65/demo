package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author sai
 */
@Slf4j
@Data
public class Group implements Serializable {


    @NotNull
    @Getter
    @Setter
    @Max(999)
    private Integer group;

    @NotNull
    @Max(9)
    @Getter
    @Setter
    private Integer id;
}
