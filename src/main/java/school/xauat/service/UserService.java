package school.xauat.service;

import school.xauat.po.User;

/**
 * @author ：zsy
 * @date ：Created 2021/4/6 16:39
 * @description：
 */
public interface UserService {

    User checkUser(String username, String password);
}
