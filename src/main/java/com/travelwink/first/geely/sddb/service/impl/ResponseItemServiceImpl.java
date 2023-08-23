package com.travelwink.first.geely.sddb.service.impl;

import com.travelwink.first.common.service.impl.BaseServiceImpl;
import com.travelwink.first.geely.sddb.mapper.ResponseItemMapper;
import com.travelwink.first.geely.sddb.service.ResponseItemService;
import com.travelwink.first.geely.sddb.xmlNode.ResponseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseItemServiceImpl extends BaseServiceImpl<ResponseItemMapper, ResponseItem> implements ResponseItemService {

    @Autowired
    private ResponseItemMapper responseItemMapper;

    @Override
    public List<ResponseItem> getStatusBits(String diagId) {
        return responseItemMapper.getStatusBits(diagId);
    }
}
