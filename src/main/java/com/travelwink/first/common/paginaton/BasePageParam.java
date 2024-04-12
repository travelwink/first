package com.travelwink.first.common.paginaton;

import com.travelwink.first.common.constant.CommonConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 查询参数
 *
 * @author geekidea
 */
@Data
public abstract class BasePageParam implements Serializable {

    @Schema(description = "查询页码")
    private Long pageIndex = CommonConstant.DEFAULT_PAGE_INDEX;

    @Schema(description = "单页数量")
    private Long pageSize = CommonConstant.DEFAULT_PAGE_SIZE;

    @Schema(description = "查询关键词")
    private String keyword;

    public void setPageIndex(Long pageIndex) {
        if (pageIndex == null || pageIndex <= 0) {
            this.pageIndex = CommonConstant.DEFAULT_PAGE_INDEX;
        } else {
            this.pageIndex = pageIndex;
        }
    }

    public void setPageSize(Long pageSize) {
        if (pageSize == null || pageSize <= 0) {
            this.pageSize = CommonConstant.DEFAULT_PAGE_SIZE;
        } else {
            this.pageSize = pageSize;
        }
    }

}
