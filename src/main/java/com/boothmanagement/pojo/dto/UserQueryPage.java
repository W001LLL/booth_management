package com.boothmanagement.pojo.dto;

import lombok.Data;

/**
 * com.boothmanagement.pojo.dto
 * User: Wzq
 * Date: 2024/12/05 18:48
 * motto:   相与笑春风
 * Description:
 * Version: V1.0
 */
@Data
public class UserQueryPage extends Page{
    private  String   userUsername;
    private  String   userPhone;
}
