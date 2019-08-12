package org.moonzhou.backend.base.utils.impl;

import org.moonzhou.backend.base.dao.dmo.User;
import org.moonzhou.backend.base.service.dto.user.UserDto;
import org.moonzhou.backend.base.utils.DTOConvert;
import org.springframework.beans.BeanUtils;

public class UserDTOConvert implements DTOConvert<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }
}