package com.wedd2.controller.wedding;

import com.wedd2.service.WeddingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeddingController {
    private final WeddingService service;

    public WeddingController(WeddingService service) {
        this.service = service;
    }

    @GetMapping("wedding")
    public String wedding() {

        return "wedding";
    }
}
