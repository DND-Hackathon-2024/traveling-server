package com.plass.traveling.domain.az;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chatgpt")
public class ChatGPTController {

    private final ChatGPTService chatGPTService;

    @PostMapping("/{chat}")
    public Object createData(@PathVariable String chat) throws JsonProcessingException {

        return chatGPTService.createData(chat);
    }
}
