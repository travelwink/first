package com.travelwink.first.geely.sddb.service.impl;

import com.travelwink.first.common.service.impl.BaseServiceImpl;
import com.travelwink.first.geely.sddb.mapper.ProjectMapper;
import com.travelwink.first.geely.sddb.service.ProjectService;
import com.travelwink.first.geely.sddb.xmlNode.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends BaseServiceImpl<ProjectMapper, Project> implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public Project getXmlInfo(String id) {
        return projectMapper.getProjectXmlInfo(id);
    }
}
