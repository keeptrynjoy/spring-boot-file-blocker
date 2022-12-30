package com.fileblocker.flow.service;

import com.fileblocker.flow.dto.ExtensionDto;
import com.fileblocker.flow.repository.ExtensionRepository;
import lombok.Builder;
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
    public List<ExtensionDto> getFixedExtension() {
        return extensionRepository.selectFixedExtension();
    }

    @Override
    public void insetExtension(ExtensionDto dto){
        extensionRepository.insertCustomExtension(dto);
    }

    @Override
    public void deleteCustomExtension(ExtensionDto dto) {


        extensionRepository.deleteCustomExtension(dto);
    }

    @Override
    public void updateFixedExtension(ExtensionDto dto) {

        ExtensionDto transDto;

        if(dto.getStatus()==1){
            transDto = ExtensionDto.builder()
                    .name(dto.getName())
                    .type(dto.getType())
                    .status(0)
                    .build();
        } else {
            transDto = ExtensionDto.builder()
                    .name(dto.getName())
                    .type(dto.getType())
                    .status(1)
                    .build();
        }

        extensionRepository.updateFixedExtension(transDto);
    }
}

