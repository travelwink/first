package com.travelwink.first.common.paginaton;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 可排序查询参数对象
 *
 * @author geekidea
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BasePageOrderParam extends BasePageParam {

    private List<OrderItem> pageSorts;

    public void defaultPageSort(OrderItem orderItem) {
        this.defaultPageSorts(Arrays.asList(orderItem));
    }

    public void defaultPageSorts(List<OrderItem> pageSorts) {
        if (CollectionUtils.isEmpty(pageSorts)) {
            return;
        }
        this.pageSorts = pageSorts;
    }

}
