package com.travelwink.first.geely.sddb.service.impl;

import com.travelwink.first.common.service.impl.BaseServiceImpl;
import com.travelwink.first.geely.sddb.mapper.DiagServiceMapper;
import com.travelwink.first.geely.sddb.service.DiagServiceService;
import com.travelwink.first.geely.sddb.xmlNode.DiagService;
import com.travelwink.first.geely.sddb.xmlNode.Session;
import com.travelwink.first.geely.sddb.xmlNode.SubFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagServiceServiceImpl extends BaseServiceImpl<DiagServiceMapper, DiagService> implements DiagServiceService {

    @Autowired
    private DiagServiceMapper diagServiceMapper;

    @Override
    public List<DiagService> getServices(String diagId) {
        return diagServiceMapper.getServices(diagId);
    }

    @Override
    public List<SubFunction> getSubFunctions(String diagId, String serviceCode) {
        return diagServiceMapper.getSubFunctions(diagId, serviceCode);
    }

    @Override
    public List<Session> getSubFunctionSessions(String subFunctionId) {
        return diagServiceMapper.getSubFunctionSessions(subFunctionId);
    }
}
