package com.travelwink.first.geely.sddb.service.impl;

import com.travelwink.first.common.service.impl.BaseServiceImpl;
import com.travelwink.first.geely.sddb.mapper.SwMapper;
import com.travelwink.first.geely.sddb.entity.InitValue;
import com.travelwink.first.geely.sddb.service.SwService;
import com.travelwink.first.geely.sddb.xmlNode.Sw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwServiceImpl extends BaseServiceImpl<SwMapper, Sw> implements SwService {

    @Autowired
    private SwMapper swMapper;

    @Override
    public List<Sw> getXmlInfo(String projectEcuRelId) {
        return swMapper.getXmlInfo(projectEcuRelId);
    }

    @Override
    public List<InitValue> getInitValue(String initId) {
        return swMapper.getInitValue(initId);
    }
}
