package com.travelwink.first.geely.sddb.service;

import com.travelwink.first.common.service.BaseService;
import com.travelwink.first.geely.sddb.xmlNode.NegativeResponseCode;

import java.util.List;

public interface NegativeResponseCodeService extends BaseService<NegativeResponseCode> {

    List<NegativeResponseCode> getReleatedList(String serviceCode, String diagId);
}
