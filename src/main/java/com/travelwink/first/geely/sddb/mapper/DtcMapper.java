package com.travelwink.first.geely.sddb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travelwink.first.geely.sddb.xmlNode.DTC;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DtcMapper extends BaseMapper<DTC> {

    @Select(
            "SELECT \n" +
                    "    CONCAT('0x',\n" +
                    "            t141.identifier,\n" +
                    "            tftp.code,\n" +
                    "            tft.code) AS id,\n" +
                    "    CONCAT_WS(' - ', t141.name, tftp.name, tft.name) AS name,\n" +
                    "    t147.software_label AS s_w_label,\n" +
                    "    t147.confirmed_dtc_limit,\n" +
                    "    t147.unconfirmed_dtc_limit_int AS unconfirmed_dtc_Limit,\n" +
                    "    t147.aging_counter,\n" +
                    "    t147.dtc_warning_indicator AS warning_indicator,\n" +
                    "    t147.dtc_event_priority,\n" +
                    "    t147.aged_dtc_limit,\n" +
                    "    t147.pfc_int AS failed_threshold,\n" +
                    "    t147.test_passed_limit as passed_threshold,\n" +
                    "    t147.increase_at_trouble as increment_step_size,\n" +
                    "    t147.decrease_at_no_trouble as decrement_step_size,\n" +
                    "    t147.jump_down\n" +
                    "FROM\n" +
                    "    t147_block_dtc t147\n" +
                    "        LEFT JOIN\n" +
                    "    t141_block t141 ON t141.id = t147.fk_t141_block_id\n" +
                    "        LEFT JOIN\n" +
                    "    t_failure_type tft ON tft.id = t141.fk_t_failure_type_id\n" +
                    "        LEFT JOIN\n" +
                    "    t_failure_type tftp ON tft.parent_id = tftp.id\n" +
                    "WHERE\n" +
                    "    t147.fk_t100_ecu_variant_id = #{diagId}"
    )
    List<DTC> getListByDiagId(String diagId);
}
