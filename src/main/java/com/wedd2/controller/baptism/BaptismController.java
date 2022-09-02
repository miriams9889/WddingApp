package com.wedd2.controller.baptism;

import com.wedd2.service.BaptismService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaptismController {
    private final BaptismService service;

    public BaptismController(BaptismService service) {
        this.service = service;
    }

    @GetMapping("baptism")
    public String baptism() {

        return "baptism";
    }
}
