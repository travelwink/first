package com.travelwink.first.geely.sddb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travelwink.first.geely.sddb.xmlNode.Sw;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SwMapper extends BaseMapper<Sw> {
    @Select("""
            SELECT
                t100.identifier AS diagnostic_part_number,
                CONCAT_WS('_',
                        t101.short_name,
                        IF(ISNULL(t101a.short_name),
                            'APP',
                            t101a.short_name),
                        t100.identifier) AS name,
                IF(ISNULL(t101a.short_name),
                    'APP',
                    t101a.short_name) AS type,
                IF(ISNULL(t123.name),'',t123.name) AS bus_name,
                t121.address_size as address_format,
                t121.fk_t130_init_timing_id as timing_init_id
            FROM
                t100_ecu_variant t100
                    LEFT JOIN
                t101_ecu t101a ON t101a.id = t100.fk_t101_ecu_swdl
                    LEFT JOIN
                t_project_ecu_rel tper ON t100.fk_project_ecu_rel_id = tper.id
                    LEFT JOIN
                t101_ecu t101 ON tper.fk_t101_ecu_id = t101.id
                    LEFT JOIN
                t121_config t121 ON t121.id = t100.fk_t121_config_id
                    LEFT JOIN
                t123_bus t123 ON t123.id = t121.fk_t123_bus_id
            WHERE
                t100.fk_project_ecu_rel_id = #{projectEcuRelId}""")
    List<Sw> getXmlInfo(String projectEcuRelId);
}
