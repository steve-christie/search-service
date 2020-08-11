package com.christie.searchservice.controller;

import com.christie.searchservice.config.DataLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AController {

    private final DataLoader dataLoader;

    @PostMapping(value = "/createData")
    public void createData() {
        dataLoader.loadSampleData();
    }
}
