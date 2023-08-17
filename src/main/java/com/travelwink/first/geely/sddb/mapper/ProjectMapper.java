package com.travelwink.first.geely.sddb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travelwink.first.geely.sddb.xmlNode.Project;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectMapper extends BaseMapper<Project> {
    @Select("""
            SELECT
                t104.id,
                CONCAT_WS(':',
                        t104.name,
                        t104.start_of_prod,
                        t104.series) AS name,
                CONCAT_WS(':',
                        t104.name,
                        t104.start_of_prod,
                        t104.series) AS projectVersion
            FROM
                t104_project t104 WHERE t104.id = #{id}""")
    Project getProjectXmlInfo(String id);
}
