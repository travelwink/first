package com.travelwink.first.geely.sddb.service;

import com.travelwink.first.common.service.BaseService;
import com.travelwink.first.geely.sddb.xmlNode.DTC;

import java.util.List;

public interface DtcService extends BaseService<DTC> {

    List<DTC> getListByDiagId(String diagId);
}
