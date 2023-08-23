package com.travelwink.first.geely.sddb.service.impl;

import com.travelwink.first.common.service.impl.BaseServiceImpl;
import com.travelwink.first.geely.sddb.entity.InitValue;
import com.travelwink.first.geely.sddb.mapper.InitValueMapper;
import com.travelwink.first.geely.sddb.service.InitValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitValueServiceImpl extends BaseServiceImpl<InitValueMapper, InitValue> implements InitValueService {

    @Autowired
    private InitValueMapper initValueMapper;

    @Override
    public List<InitValue> getValueByInitId(String initId) {
        return initValueMapper.getValueByInitId(initId);
    }
}
