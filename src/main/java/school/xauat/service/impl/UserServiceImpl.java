package school.xauat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.xauat.util.MD5Utils;
import school.xauat.dao.UserRepository;
import school.xauat.po.User;
import school.xauat.service.UserService;

/**
 * @author ：zsy
 * @date ：Created 2021/4/6 16:41
 * @description：
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
