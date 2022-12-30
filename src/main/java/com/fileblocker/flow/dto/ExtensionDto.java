package com.fileblocker.flow.dto;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExtensionDto {

    private String name;
    private String type;
    private int status;

}
