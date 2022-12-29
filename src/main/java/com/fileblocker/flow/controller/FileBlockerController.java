package com.fileblocker.flow.controller;

import com.fileblocker.flow.dto.ExtensionDto;
import com.fileblocker.flow.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class FileBlockerController {

    private final ExtensionService extensionService;

    @GetMapping("/")
    public String main(Model model){

        model.addAttribute("list", extensionService.getCustomExtension());
        model.addAttribute("count", extensionService.getCustomExtension().size());

        return "fileblocker";
    }

    @PostMapping("/add-extn")
    public ResponseEntity<String> insertExtension(@RequestBody ExtensionDto dto) {
//        System.out.println("add-extn :" + dto.getName());

        extensionService.insetExtension(dto);

        return ResponseEntity.ok().body("");
    }
}
