package com.fileblocker.flow.repository;

import com.fileblocker.flow.dto.ExtensionDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExtensionRepository {

    public List<ExtensionDto> selectCustomExtension();
    public List<ExtensionDto> selectFixedExtension();
    public void insertCustomExtension(ExtensionDto dto);
    public void deleteCustomExtension(ExtensionDto dto);
    public void updateFixedExtension(ExtensionDto dto);
}
