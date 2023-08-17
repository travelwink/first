package com.travelwink.first.common.entity;

import com.baomidou.mybatisplus.annotation.OrderBy;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Null;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author chris
 */
@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable {

    @Null(message = "创建时间不用传")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @OrderBy
    @Null(message = "修改时间不用传")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}
