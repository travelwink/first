package com.travelwink.first.geely.sddb.service;

import com.travelwink.first.common.service.BaseService;
import com.travelwink.first.geely.sddb.entity.InitValue;

import java.util.List;

public interface InitValueService extends BaseService<InitValue> {

    List<InitValue> getValueByInitId(String initId);
}
