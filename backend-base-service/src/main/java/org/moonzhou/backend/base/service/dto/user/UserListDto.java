package org.moonzhou.backend.base.service.dto.user;

import org.moonzhou.backend.base.service.dto.BaseDto;

import java.util.List;

/**
 * @Description
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/12
 */
public class UserListDto extends BaseDto {
    private List<UserDto> userDtoList;

    public List<UserDto> getUserDtoList() {
        return userDtoList;
    }

    public void setUserDtoList(List<UserDto> userDtoList) {
        this.userDtoList = userDtoList;
    }
}
