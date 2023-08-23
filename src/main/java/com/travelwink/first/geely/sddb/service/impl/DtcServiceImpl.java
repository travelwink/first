package com.travelwink.first.geely.sddb.service.impl;

import com.travelwink.first.common.service.impl.BaseServiceImpl;
import com.travelwink.first.geely.sddb.mapper.DtcMapper;
import com.travelwink.first.geely.sddb.service.DtcService;
import com.travelwink.first.geely.sddb.xmlNode.DTC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtcServiceImpl extends BaseServiceImpl<DtcMapper, DTC> implements DtcService {

    @Autowired
    private DtcMapper dtcMapper;

    @Override
    public List<DTC> getListByDiagId(String diagId) {
        return dtcMapper.getListByDiagId(diagId);
    }
}
