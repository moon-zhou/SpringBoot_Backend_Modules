package org.moonzhou.backend.base.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.moonzhou.backend.base.dao.dmo.User;

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

    /**
     * <p>
     * 查询 : 根据state状态查询用户列表，分页显示
     * 注意!!: 如果入参是有多个,需要加注解指定参数名才能在xml中取值
     * </p>
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param user 用户查询条件
     * @return 分页对象
     */
    IPage<User> selectUserByPageVo(Page page, User user);
}
