package org.moonzhou.backend.base.service.dto.book;

import lombok.Data;
import org.moonzhou.backend.base.service.dto.BaseDto;

import java.util.Date;

/**
 * @Description
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/10/19
 */
@Data
public class BookDto extends BaseDto {

    private Integer id;

    private String name;

    private Date createTime;

    private Date lastModifyTime;
}
