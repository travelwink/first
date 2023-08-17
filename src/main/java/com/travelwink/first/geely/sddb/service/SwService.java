package com.travelwink.first.geely.sddb.service;

import com.travelwink.first.common.service.BaseService;
import com.travelwink.first.geely.sddb.xmlNode.Sw;

import java.util.List;

public interface SwService extends BaseService<Sw> {
    List<Sw> getXmlInfo(String projectEcuRelId);
}
