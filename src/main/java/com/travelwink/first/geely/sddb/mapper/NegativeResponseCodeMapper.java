package com.travelwink.first.geely.sddb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travelwink.first.geely.sddb.xmlNode.NegativeResponseCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NegativeResponseCodeMapper extends BaseMapper<NegativeResponseCode> {

    @Select("SELECT \n" +
            "    DISTINCT(t115.nrc) AS code, t115.description AS name\n" +
            "FROM\n" +
            "    t114_nrc_service_ecuvariant t114\n" +
            "        LEFT JOIN\n" +
            "    t115_nrc t115 ON t114.fk_t115_nrc_id = t115.id\n" +
            "WHERE\n" +
            "    t114.fk_t110_service_ecu_variant_id IN (SELECT \n" +
            "            t110.id\n" +
            "        FROM\n" +
            "            t110_service_ecu_variant t110\n" +
            "                LEFT JOIN\n" +
            "            t111_service t111 ON t111.id = t110.fk_t111_service_id\n" +
            "        WHERE\n" +
            "            t110.fk_t100_ecu_variant_id = #{diagId}\n" +
            "                AND t111.service = #{serviceCode})\n" +
            "ORDER BY t115.nrc")
    List<NegativeResponseCode> getReleatedList(@Param("serviceCode")String serviceCode, @Param("diagId")String diagId);
}
