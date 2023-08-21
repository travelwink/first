package com.travelwink.first.geely.sddb.service;

import com.travelwink.first.common.service.BaseService;
import com.travelwink.first.geely.sddb.xmlNode.DiagService;

import java.util.List;

public interface DiagServiceService extends BaseService<DiagService> {
    List<DiagService> getServices(String diagId);
}
