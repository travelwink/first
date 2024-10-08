package com.travelwink.first.system.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.travelwink.first.common.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;

/**
 * @author chris
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity {

    @TableId(type = IdType.ASSIGN_UUID)
    @SchemaProperty
    private String id;

    private String username;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    private Integer gender;

    private String avatar;

    private String nickName;

    private Integer state;

    private String fkRoleId;

    private String fkDeptId;

    private String remark;

    private String createdBy;

    private String updatedBy;

}
