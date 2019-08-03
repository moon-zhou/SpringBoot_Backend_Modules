package org.moonzhou.backend.base.service.impl;

import org.moonzhou.backend.base.dao.dmo.User;
import org.moonzhou.backend.base.dao.mapper.UserMapper;
import org.moonzhou.backend.base.service.UserService;
import org.moonzhou.backend.base.service.dto.user.UserDto;
import org.moonzhou.backend.base.utils.impl.UserConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 用户业务逻辑实现类
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/3
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserDto> queryAllUser() {
        List<User> userList = userMapper.selectAll();

        List<UserDto> userDtoList = new ArrayList();

        UserConvert userConvert = new UserConvert();
        userList.forEach(user -> {
            UserDto userDto = userConvert.convert(user);

            userDtoList.add(userDto);
        });

        return userDtoList;
    }

    @Override
    public List<UserDto> queryUser(UserDto userDto) {
        return null;
    }
}
