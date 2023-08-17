package com.travelwink.first.example.service.impl;

import com.travelwink.first.example.entity.FormattedDateInfo;
import com.travelwink.first.example.service.FormatService;
import org.springframework.stereotype.Service;

@Service
public class FormatServiceImpl implements FormatService {

    @Override
    public FormattedDateInfo getFormattedDate() {
        return new FormattedDateInfo();
    }
}
