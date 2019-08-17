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

    /**
     * 查询所有数据
     * @return
     */
    List<UserDto> queryAllUser();

    /**
     * 根据查询条件查询数据
     * @param userDto
     * @return
     */
    List<UserDto> queryUser(UserDto userDto);

    /**
     * 根据查询条件分页查询数据
     * @param page
     * @return
     */
    List<UserDto> selectUserPage(UserDto userDto);
}
