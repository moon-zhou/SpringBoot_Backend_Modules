package org.moonzhou.backend.base.dao;

import org.apache.ibatis.annotations.Mapper;
import org.moonzhou.backend.base.dmo.User;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @Date: 2019/6/29 11:15
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface UserMapper {
    List<User> selectAll();
}
