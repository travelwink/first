package com.travelwink.first.common.entity;

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

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
