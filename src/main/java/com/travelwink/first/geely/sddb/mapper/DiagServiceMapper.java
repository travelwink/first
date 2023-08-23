package com.travelwink.first.geely.sddb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travelwink.first.geely.sddb.xmlNode.DiagService;
import com.travelwink.first.geely.sddb.xmlNode.Session;
import com.travelwink.first.geely.sddb.xmlNode.SubFunction;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagServiceMapper extends BaseMapper<DiagService> {

    @Select("SELECT DISTINCT \n" +
            "    (t111.service), t111.service_name \n" +
            "FROM \n" +
            "    t110_service_ecu_variant t110 \n" +
            "        LEFT JOIN \n" +
            "    t111_service t111 ON t111.id = t110.fk_t111_service_id \n" +
            "WHERE \n" +
            "    t110.fk_t100_ecu_variant_id = #{diagId}\n" +
            "ORDER BY t111.service")
    List<DiagService> getServices(String diagId);

    @Select("SELECT \n" +
            "    t110.id,\n" +
            "    t111.mode, \n" +
            "    t111.mode_name, \n" +
            "    t111.fk_t_Init130_Timing_Service_Default, \n" +
            "    t110.fk_t130_init_timing_service \n" +
            "FROM\n" +
            "    t110_service_ecu_variant t110\n" +
            "        LEFT JOIN\n" +
            "    t111_service t111 ON t111.id = t110.fk_t111_service_id\n" +
            "WHERE\n" +
            "    t110.fk_t100_ecu_variant_id = #{diagId}\n" +
            "        AND t111.service = #{ServiceCode} \n" +
            "ORDER BY t111.mode ")
    List<SubFunction> getSubFunctions(@Param("diagId") String diagId, @Param("ServiceCode") String ServiceCode);

    @Select("SELECT \n" +
            "    t111.mode, t111.mode_name\n" +
            "FROM\n" +
            "    t113_accpar_service_ecuvariant t113\n" +
            "        LEFT JOIN\n" +
            "    t111_service t111 ON t113.fk_t111_service_accpar = t111.id\n" +
            "WHERE\n" +
            "    t113.fk_t110_service_ecu_variant_id = #{subFunctionId}\n" +
            "ORDER BY t111.mode ")
    List<Session> getSubFunctionSessions(String subFunctionId);
}
