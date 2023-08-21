package com.travelwink.first.geely.sddb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travelwink.first.geely.sddb.xmlNode.DiagService;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagServiceMapper extends BaseMapper<DiagService> {

    @Select("SELECT DISTINCT \n" +
            "    (t111.service) AS id, t111.service_name AS name \n" +
            "FROM \n" +
            "    t110_service_ecu_variant t110 \n" +
            "        LEFT JOIN \n" +
            "    t111_service t111 ON t111.id = t110.fk_t111_service_id \n" +
            "WHERE \n" +
            "    t110.fk_t100_ecu_variant_id = '830b28708df1ccdaaf9ef398f275db9a'; \n")
    List<DiagService> getServices(String diagId);
}
