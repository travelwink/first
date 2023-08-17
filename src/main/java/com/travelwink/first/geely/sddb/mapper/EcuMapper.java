package com.travelwink.first.geely.sddb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travelwink.first.geely.sddb.xmlNode.Ecu;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface EcuMapper extends BaseMapper<Ecu> {
    @Select("""
            SELECT
                t101.id,
                tper.id AS project_ecu_rel_id,
                t101.short_name AS name,
                t101.ecu_address AS address
            FROM
                t_project_ecu_rel tper
                    LEFT JOIN
                t101_ecu t101 ON t101.id = tper.fk_t101_ecu_id
            WHERE
                tper.fk_t104_project_id = #{projectId}
            ORDER BY t101.short_name""")
    List<Ecu> getRelatedList(String projectId);
}
