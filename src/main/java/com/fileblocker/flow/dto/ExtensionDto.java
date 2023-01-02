package com.fileblocker.flow.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExtensionDto {

    @NotBlank(message = "확장자를 입력해주세요.")
    @Pattern(regexp = "^([a-zA-Z][0-9]*){1,20}$", message = "영어 또는 영어와 숫자를 포함해서 1~20자리 이내로 입력해주세요.")
    private String name;
    private String type;
    private int status;
}
