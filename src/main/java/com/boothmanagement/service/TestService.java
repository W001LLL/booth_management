package com.boothmanagement.service;

import com.boothmanagement.model.R;
import com.boothmanagement.pojo.User;
import com.boothmanagement.pojo.dto.UserQueryPage;

/**
 * com.boothmanagement.service
 * User: Wzq
 * Date: 2024/12/03 9:08
 * motto:   相与笑春风
 * Description:
 * Version: V1.0
 */
public interface TestService {
    R test(UserQueryPage userQueryPage);
    int testDelete(int id);
    int testUpdate(User user);
}
