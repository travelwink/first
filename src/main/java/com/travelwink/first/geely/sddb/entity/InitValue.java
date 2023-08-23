package com.travelwink.first.geely.sddb.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("t131_init_value")
public class InitValue {

    @TableId
    private String id;

    private String fkT130InitId;

    private String fkT132InitValueTypeId;

    private String name;

    private String initValue;

    private String sortOrder;

}
