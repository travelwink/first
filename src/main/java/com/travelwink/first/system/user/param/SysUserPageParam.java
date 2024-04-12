package com.travelwink.first.system.user.param;

import com.travelwink.first.common.paginaton.BasePageOrderParam;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "用户分页查询条件参数")
public class SysUserPageParam extends BasePageOrderParam {

    @Serial
    private static final long serialVersionUID = 7437881671144580610L;

    @Schema(description = "类型")
    private Integer type;

    @Schema(description = "状态（0：禁用，1：启用，2：锁定）")
    private Integer state;

    @Schema(description = "角色ID")
    private String roleId;

    @Schema(description = "组织ID")
    private String organizeId;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "手机号")
    private String mobile;
}
