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
    public List<ExtensionDto> getFixedExtension() {
        return extensionRepository.selectFixedExtension();
    }

    @Override
    public void insertCustomExtension(ExtensionDto extensionDto){

            extensionRepository.insertCustomExtension(extensionDto);
    }

    @Override
    public void deleteCustomExtension(String name) {
        extensionRepository.deleteCustomExtension(name);
    }

    /* 고정확장자 block/unblock 조건 비즈니스 로직 */
    @Override
    public void updateFixedExtension(String name, String status) {

        ExtensionDto transDto;

        if(status.equals("unblock")){
            transDto = ExtensionDto.builder()
                    .name(name)
                    .type("fixed")
                    .status(0)
                    .build();
        } else {
            transDto = ExtensionDto.builder()
                    .name(name)
                    .type("fixed")
                    .status(1)
                    .build();
        }

        extensionRepository.updateFixedExtension(transDto);
    }
}

