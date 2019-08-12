package org.moonzhou.backend.base.utils.impl;

import org.moonzhou.backend.base.dao.dmo.User;
import org.moonzhou.backend.base.service.dto.user.UserDto;
import org.moonzhou.backend.base.utils.DTOConvert;
import org.springframework.beans.BeanUtils;

public class UserConvert implements DTOConvert<User, UserDto> {

    @Override
    public UserDto convert(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
}