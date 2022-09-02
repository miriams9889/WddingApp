package com.wedd2.controller.baptism;

import com.wedd2.event.Baptism;
import com.wedd2.event.BaptismNotFoundException;
import com.wedd2.service.BaptismService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FeniceBaptismController {
    private final BaptismService service;

    public FeniceBaptismController(BaptismService service) {
        this.service = service;
    }

    @GetMapping("/fenicebaptisms")
    public String showBaptismList(Model model){
        List<Baptism> listBaptisms = service.listAll();
        model.addAttribute("listBaptisms", listBaptisms);
        return "fenicebaptisms";
    }

    @GetMapping("/fenicebaptisms/new")
    public String showNewForm(Model model){
        model.addAttribute("baptism",new Baptism());
        model.addAttribute("pageTitle","Add New Baptism");
        return "fenice3_form";
    }
    @PostMapping("/fenicebaptisms/save")
    public String saveBaptism(Baptism baptism, RedirectAttributes ra){
        service.save(baptism);
        ra.addFlashAttribute("message","The Baptism has been added succesfully");
        return "redirect:/fenicebaptisms";
    }

    @GetMapping("/fenicebaptisms/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id,Model model,RedirectAttributes ra) {
        try {
            Baptism baptism = service.get(id);
            model.addAttribute("baptism", baptism);
            model.addAttribute("pageTitle","Edit Baptism (ID: " + id + ")");
            return "fenice3_form";
        } catch (BaptismNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/fenicebaptisms";

    }

    }
    @GetMapping("/fenicebaptisms/delete/{id}")
    public String deleteBaptism(@PathVariable("id") Integer id,RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", " The event ID  " + id + "  has been succesfully deleted");
        } catch (BaptismNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
            return "redirect:/fenicebaptisms";

        }

    @GetMapping("/fenice3")
    public String fenice3() {
        return "fenice3";
    }


}
