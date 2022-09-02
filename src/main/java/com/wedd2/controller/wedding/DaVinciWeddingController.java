package com.wedd2.controller.wedding;

import com.wedd2.event.Wedding;
import com.wedd2.event.WeddingNotFoundException;
import com.wedd2.service.WeddingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DaVinciWeddingController {
    private final WeddingService service;

    public DaVinciWeddingController(WeddingService service) {
        this.service = service;
    }
    @GetMapping("/daVinciweddings")
    public String showWeddingList(Model model){
        List<Wedding> listWeddings = service.listAll();
        model.addAttribute("listWeddings", listWeddings);
        return "daVinciweddings";
    }

    @GetMapping("/daVinciweddings/new")
    public String showNewForm(Model model){
        model.addAttribute("wedding",new Wedding());
        model.addAttribute("pageTitle","Add New Wedding");
        return "daVinci_form";
    }
    @PostMapping("/daVinciweddings/save")
    public String saveWedding(Wedding wedding, RedirectAttributes ra){
        service.save(wedding);
        ra.addFlashAttribute("message","The wedding has been added succesfully");
        return "redirect:/daVinciweddings";
    }

    @GetMapping("/daVinciweddings/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Wedding wedding = service.get(id);
            model.addAttribute("wedding", wedding);
            model.addAttribute("pageTitle","Edit Wedding (ID: " + id + ")");
            return "daVinci_form";
        } catch (WeddingNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/daVinciweddings";

        }

    }
    @GetMapping("/daVinciweddings/delete/{id}")
    public String deleteWedding(@PathVariable("id") Integer id,RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", " The event ID  " + id + "  has been succesfully deleted");
        } catch (WeddingNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/daVinciweddings";

    }

    @GetMapping("/daVinci")
    public String daVinci() {
        return "daVinci";
    }
}
