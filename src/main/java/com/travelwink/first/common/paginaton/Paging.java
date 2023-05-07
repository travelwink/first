/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
 * @author geekidea
 * @date 2018-11-08
 */

@Slf4j
@Data
public class Paging<T> implements Serializable {
    private static final long serialVersionUID = 4784961132604516495L;

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
