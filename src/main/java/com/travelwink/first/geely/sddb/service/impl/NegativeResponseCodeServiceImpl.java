package com.travelwink.first.geely.sddb.service.impl;


import com.travelwink.first.common.service.impl.BaseServiceImpl;
import com.travelwink.first.geely.sddb.mapper.NegativeResponseCodeMapper;
import com.travelwink.first.geely.sddb.service.NegativeResponseCodeService;
import com.travelwink.first.geely.sddb.xmlNode.NegativeResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegativeResponseCodeServiceImpl extends BaseServiceImpl<NegativeResponseCodeMapper, NegativeResponseCode> implements NegativeResponseCodeService {

    @Autowired
    private NegativeResponseCodeMapper negativeResponseCodeMapper;

    @Override
    public List<NegativeResponseCode> getReleatedList(String serviceCode, String diagId) {
        return negativeResponseCodeMapper.getReleatedList(serviceCode, diagId);
    }
}
