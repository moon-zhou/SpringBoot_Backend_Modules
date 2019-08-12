package org.moonzhou.backend.base.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.moonzhou.backend.base.dao.dmo.User;
import org.moonzhou.backend.base.dao.mapper.UserMapper;
import org.moonzhou.backend.base.service.UserService;
import org.moonzhou.backend.base.service.dto.user.UserDto;
import org.moonzhou.backend.base.utils.impl.UserConvert;
import org.moonzhou.backend.base.utils.impl.UserDTOConvert;
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

        // 将参数从dto对象转换为dmo对象，进行查询
        UserDTOConvert userDTOConvert = new UserDTOConvert();
        User user = userDTOConvert.convert(userDto);

        List<User> userList = userMapper.selectByUser(user);

        List<UserDto> userDtoList = new ArrayList();

        // 将查询到的结果从dmo对象转换为dto对象
        UserConvert userConvert = new UserConvert();
        userList.forEach(userResult -> {
            UserDto userDtoResult = userConvert.convert(userResult);

            userDtoList.add(userDtoResult);
        });

        return userDtoList;
    }

    @Override
    public IPage<UserDto> selectUserPage(Page<UserDto> page) {


        return null;
    }
}
