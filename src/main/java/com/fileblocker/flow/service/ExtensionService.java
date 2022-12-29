package com.fileblocker.flow.service;

import com.fileblocker.flow.dto.ExtensionDto;

import java.util.List;

public interface ExtensionService {
    public List<ExtensionDto> getCustomExtension();
    public void insetExtension(ExtensionDto dto);
}
