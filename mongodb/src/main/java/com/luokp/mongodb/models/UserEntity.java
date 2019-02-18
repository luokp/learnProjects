package com.luokp.mongodb.models;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: luokp
 * @date: 2019/2/18 19:17
 * @description:
 */
@Data
public class UserEntity implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;
    private Long id;
    private String userName;
    private String passWord;
}
