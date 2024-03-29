package org.moonzhou.backend.base.web.controller;

import org.moonzhou.backend.base.common.constants.SystemConstants;
import org.moonzhou.backend.base.service.UserService;
import org.moonzhou.backend.base.service.dto.user.UserDto;
import org.moonzhou.backend.base.service.dto.user.UserListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 用户表数据常规操作
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/3
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * http://localhost:8881/backend-base/user/queryAllUser.do
     * 查询所有用户信息
     * @return
     */
    @RequestMapping("/queryAllUser" + SystemConstants.REQUEST_SUFFIX)
    @ResponseBody
    public UserListDto queryAllUser() {

        UserListDto userListDto = new UserListDto();
        userListDto.setUserDtoList(userService.queryAllUser());

        return userListDto;
    }

    /**
     * http://localhost:8881/backend-base/user/queryUsers.do?sex=1
     * 查询所有用户信息
     * @return
     */
    @RequestMapping("/queryUsers" + SystemConstants.REQUEST_SUFFIX)
    @ResponseBody
    public UserListDto queryUsers(UserDto userDto) {

        UserListDto userListDto = new UserListDto();
        userListDto.setUserDtoList(userService.queryUser(userDto));

        return userListDto;
    }

    /**
     * http://localhost:8881/backend-base/user/queryPageUsers.do?sex=1&current=1&size=1
     * http://localhost:8881/backend-base/user/queryPageUsers.do?current=3&size=1
     * 分页按条件查询
     * @param userDto
     * @return
     */
    @RequestMapping("/queryPageUsers" + SystemConstants.REQUEST_SUFFIX)
    @ResponseBody
    public UserListDto queryPageUsers(UserDto userDto) {

        UserListDto userListDto = new UserListDto();
        userListDto.setUserDtoList(userService.selectUserPage(userDto));

        return userListDto;
    }

    @RequestMapping("/addUser" + SystemConstants.REQUEST_SUFFIX)
    @ResponseBody
    public UserDto addUser() {
        UserDto user = new UserDto();

        return user;
    }
}
