package com.fileblocker.flow.controller;

import com.fileblocker.flow.dto.ExtensionDto;
import com.fileblocker.flow.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class FileBlockerController {

    private final ExtensionService extensionService;

    /* view */
    @GetMapping("/practice")
    public String main(Model model){

        model.addAttribute("fixed_list", extensionService.getFixedExtension());
        model.addAttribute("custom_list", extensionService.getCustomExtension());
        model.addAttribute("count", extensionService.getCustomExtension().size());

        return "fileblocker";
    }

    /* 커스텀 확장자 차단 추가 */
    @PostMapping("/block/custom")
    public ResponseEntity insertCustomExtension(@RequestBody @Valid ExtensionDto extensionDto) {
        int totalBlockExtn =extensionService.selectExtensionCount();

        if(totalBlockExtn == 200){
            return ResponseEntity.badRequest().body("확장자는 최대 200개까지만 차단이 가능합니다.");
        }
        extensionService.insertCustomExtension(extensionDto);

        return ResponseEntity.ok().body("\'"+extensionDto.getName()+"\'"+" 커스텀 확장자 추가 및 차단이 완료되있습니다.");
    }

    /* 고정 확장자 차단/차단해제 */
    @PutMapping("/{status}/fixed/{name}")
    public ResponseEntity updateFixedExtension(@PathVariable(name = "name") String name,
                                               @PathVariable(name = "status") String status){

        extensionService.updateFixedExtension(name,status);

        return ResponseEntity.ok().body("고정 확장자 요청 처리 완료");
    }


    /* 커스텀 확장자 차단 해제 */
    @DeleteMapping("/unblock/custom/{name}")
    public ResponseEntity deleteCustomExtension(@PathVariable String name){

        extensionService.deleteCustomExtension(name);

        return ResponseEntity.ok().body("커스텀 확장자 삭제 완료");
    }
}
