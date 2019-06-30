package org.moonzhou.backend.base.common.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @Date: 2019/6/28 19:43
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
@ConfigurationProperties(prefix = "custom")
public class CustomConfig {
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
