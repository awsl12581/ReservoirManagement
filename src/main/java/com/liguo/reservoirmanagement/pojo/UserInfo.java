package com.liguo.reservoirmanagement.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * user_info
 * @author 
 */
@Data
public class UserInfo implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String authority;

    private static final long serialVersionUID = 1L;
}