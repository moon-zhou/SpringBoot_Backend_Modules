package org.moonzhou.backend.base.service;

import org.moonzhou.backend.base.service.dto.user.UserDto;

import java.util.List;

/**
 * @Description 用户逻辑接口类
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/3
 */
public interface UserService {

    List<UserDto> queryAllUser();

    List<UserDto> queryUser(UserDto userDto);
}
