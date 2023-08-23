package com.travelwink.first.geely.sddb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travelwink.first.geely.sddb.xmlNode.ResponseItem;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseItemMapper extends BaseMapper<ResponseItem> {

    @Select("")
    List<ResponseItem> getStatusBits(String diagId);
}
