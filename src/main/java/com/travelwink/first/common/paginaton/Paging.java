package com.travelwink.first.common.paginaton;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.travelwink.first.common.constant.CommonConstant;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页结果对象
 *
 */
@Slf4j
@Data
public class Paging<T> implements Serializable {

    @JsonProperty(CommonConstant.PAGE_TOTAL_NAME)
    private long total = 0;

    @JsonProperty(CommonConstant.PAGE_RECORDS_NAME)
    private List<T> records = Collections.emptyList();

    @JsonProperty(CommonConstant.PAGE_INDEX_NAME)
    private Long pageIndex;

    @JsonProperty(CommonConstant.PAGE_SIZE_NAME)
    private Long pageSize;

    public Paging() {

    }

    public Paging(IPage<T> page) {
        this.total = page.getTotal();
        this.records = page.getRecords();
        this.pageIndex = page.getCurrent();
        this.pageSize = page.getSize();
    }

}
