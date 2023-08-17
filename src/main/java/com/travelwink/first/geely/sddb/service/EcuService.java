package com.travelwink.first.geely.sddb.service;

import com.travelwink.first.common.service.BaseService;
import com.travelwink.first.geely.sddb.xmlNode.Ecu;

import java.util.List;

public interface EcuService extends BaseService<Ecu> {
    List<Ecu> getRelatedList(String projectId);
}
