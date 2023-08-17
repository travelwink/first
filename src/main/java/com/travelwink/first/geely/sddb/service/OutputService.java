package com.travelwink.first.geely.sddb.service;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface OutputService {
    void output(HttpServletResponse response) throws IOException;
}
