package org.moonzhou.backend.base.service.impl;

import org.moonzhou.backend.base.common.configs.CustomConfig;
import org.moonzhou.backend.base.dao.UserMapper;
import org.moonzhou.backend.base.dmo.User;
import org.moonzhou.backend.base.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @Date: 2019/6/27 19:22
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {

    private static Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Autowired
    private CustomConfig customconfig;

    @Resource
    private UserMapper userMapper;

    @Override
    public Map<String, Object> testQuery() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("test", "hello handsome boy. The king of the world");

        // 自定义配置数据
        result.put("name", customconfig.getName());
        result.put("age", customconfig.getAge());

        // 数据库数据
        List<User> user = userMapper.selectAll();
        result.put("childrenNum", user.size());

        return result;
    }
}
