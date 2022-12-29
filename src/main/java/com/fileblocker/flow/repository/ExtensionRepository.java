package com.fileblocker.flow.repository;

import com.fileblocker.flow.dto.ExtensionDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExtensionRepository {

    public List<ExtensionDto> selectCustomExtension();
    public void insertExtension(ExtensionDto dto);
}
