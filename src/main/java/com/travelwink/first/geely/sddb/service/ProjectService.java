package com.travelwink.first.geely.sddb.service;

import com.travelwink.first.common.service.BaseService;
import com.travelwink.first.geely.sddb.xmlNode.Project;

public interface ProjectService extends BaseService<Project> {
    Project getXmlInfo(String id);
}
