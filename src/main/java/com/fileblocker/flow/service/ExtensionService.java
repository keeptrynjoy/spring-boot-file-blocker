package com.fileblocker.flow.service;

import com.fileblocker.flow.dto.ExtensionDto;

import java.util.List;

public interface ExtensionService {
    public List<ExtensionDto> getCustomExtension();
    public List<ExtensionDto> getFixedExtension();
    public void insertCustomExtension(ExtensionDto extensionDto);
    public void deleteCustomExtension(String name);
    public void updateFixedExtension(String name, String status);
}
