package com.travelwink.first.geely.sddb.service;

import com.travelwink.first.common.service.BaseService;
import com.travelwink.first.geely.sddb.xmlNode.DiagService;
import com.travelwink.first.geely.sddb.xmlNode.Session;
import com.travelwink.first.geely.sddb.xmlNode.SubFunction;

import java.util.List;

public interface DiagServiceService extends BaseService<DiagService> {
    List<DiagService> getServices(String diagId);

    List<SubFunction> getSubFunctions(String diagId, String serviceCode);

    List<Session> getSubFunctionSessions(String subFunctionId);
}
