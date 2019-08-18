package org.moonzhou.backend.base.common.utils;

import com.alibaba.fastjson.serializer.ValueFilter;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description json日志脱敏类
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/18
 */
public class ValueMaskFilter implements ValueFilter {

    /**
     * 工具类使用单例
     */
    private static ValueMaskFilter instance = new ValueMaskFilter();

    public static ValueMaskFilter getInstance() {

        if (null == instance) {
            instance = new ValueMaskFilter();
        }

        return instance;
    }

    /**
     * 最后一位隐位词库
     */
    private final Set<String> lastFilterLexicon = new HashSet<String>() {
        {
            add("accountName");
            add("mobile");
        }
    };

    /**
     * 全词隐位词库
     */
    private final Set<String> allFilterLexion = new HashSet<String> () {
        {
            add("password");
        }
    };

    @Override
    public Object process(Object object, String name, Object value) {

        // 隐最后一个字符
        if (lastFilterLexicon.contains(name)) {
            return maskLastChar(String.valueOf(value));
        }

        // 全词隐位，只展示*
        if (allFilterLexion.contains(name)) {
            return maskAllChar(String.valueOf(value));
        }

        return value;
    }

    /**
     *
     * 功能描述: <br>
     * 〈入参长度>1,进行最后一位隐位，若长度=0，正常返回，长度=1，则返回*〉
     *
     * @param value
     *            需要隐位的值
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private String maskLastChar(String value) {
        if ("null".equals(value)) {
            return null;
        }
        if (StringUtils.hasLength(value)) {
            value = value.substring(0, value.length() - 1) + "*";
        }
        return value;
    }

    /**
     *
     * 功能描述: <br>
     * 〈密码等特殊属性不展示，隐位*代替〉
     *
     * @param value
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private String maskAllChar(String value) {
        if ("null".equals(value)) {
            return null;
        }
        if (StringUtils.hasLength(value)) {
            value = "*";
        }
        return value;
    }
}
