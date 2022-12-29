package com.fileblocker.flow.service;

import com.fileblocker.flow.dto.ExtensionDto;
import com.fileblocker.flow.repository.ExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExtensionServiceImpl implements ExtensionService {

    private final ExtensionRepository extensionRepository;

    @Override
    public List<ExtensionDto> getCustomExtension(){
        return extensionRepository.selectCustomExtension();
    }

    @Override
    public void insetExtension(ExtensionDto dto){
        extensionRepository.insertExtension(dto);
    }
}

