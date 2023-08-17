package com.travelwink.first.geely.sddb.service.impl;

import com.travelwink.first.common.service.impl.BaseServiceImpl;
import com.travelwink.first.geely.sddb.mapper.EcuMapper;
import com.travelwink.first.geely.sddb.service.EcuService;
import com.travelwink.first.geely.sddb.xmlNode.Ecu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EcuServiceImpl extends BaseServiceImpl<EcuMapper, Ecu> implements EcuService {

    @Autowired
    private EcuMapper ecuMapper;

    @Override
    public List<Ecu> getRelatedList(String projectId) {
        return ecuMapper.getRelatedList(projectId);
    }
}
