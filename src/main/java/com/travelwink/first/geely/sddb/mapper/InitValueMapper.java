package com.travelwink.first.geely.sddb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travelwink.first.geely.sddb.entity.InitValue;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InitValueMapper extends BaseMapper<InitValue> {

    @Select("SELECT * FROM t131_init_value t131 where t131.fk_t130_init_id = #{initId}")
    List<InitValue> getValueByInitId(String initId);
}
