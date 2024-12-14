package com.boothmanagement.pojo;

import lombok.Data;

@Data
public class User {

  private long userId;
  private String userUsername;
  private String userPassword;
  private String userPhone;
  private String userEmail;
  private String userAvatar;
  private long userRole;
  private  Integer  page=1;
  private  Integer limit=10;
}
