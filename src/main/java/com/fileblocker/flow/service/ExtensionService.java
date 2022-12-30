package com.fileblocker.flow.service;

import com.fileblocker.flow.dto.ExtensionDto;

import java.util.List;

public interface ExtensionService {
    public List<ExtensionDto> getCustomExtension();
    public List<ExtensionDto> getFixedExtension();
    public void insetExtension(ExtensionDto dto);
    public void deleteCustomExtension(ExtensionDto dto);
    public void updateFixedExtension(ExtensionDto dto);
}
