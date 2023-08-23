package com.travelwink.first.geely.sddb.service;

import com.travelwink.first.common.service.BaseService;
import com.travelwink.first.geely.sddb.xmlNode.ResponseItem;

import java.util.List;


public interface ResponseItemService extends BaseService<ResponseItem> {

    List<ResponseItem> getStatusBits(String diagId);
}
