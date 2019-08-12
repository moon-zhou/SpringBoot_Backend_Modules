package org.moonzhou.backend.base.utils;

/**
 * @Description 各层dto转换工具类
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/3
 */
public interface DTOConvert<S, T> {
    T convert(S s);
}
