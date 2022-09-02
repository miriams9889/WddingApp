package com.wedd2.controller.birthday;

import com.wedd2.event.Birthday;
import com.wedd2.event.BirthdayNotFoundException;
import com.wedd2.service.BirthdayService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ViaBirthdayController {
    private final BirthdayService service;

    public ViaBirthdayController(BirthdayService service) {
        this.service = service;
    }

    @GetMapping("/viabirthdays")
    public String showEventList(Model model){
        List<Birthday> listBirthdays = service.listAll();
        model.addAttribute("listBirthdays", listBirthdays);
        return "viabirthdays";
    }

    @GetMapping("/viabirthdays/new")
    public String showNewForm(Model model){
        model.addAttribute("birthday",new Birthday());
        model.addAttribute("pageTitle","Add New Birthday");
        return "via2_form";
    }
    @PostMapping("/viabirthdays/save")
    public String saveEvent(Birthday birthday, RedirectAttributes ra){
        service.save(birthday);
        ra.addFlashAttribute("message","The birthday has been added succesfully");
        return "redirect:/viabirthdays";
    }

    @GetMapping("/viabirthdays/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id,Model model,RedirectAttributes ra) {
        try {
            Birthday birthday = service.get(id);
            model.addAttribute("birthday", birthday);
            model.addAttribute("pageTitle","Edit Birthday (ID: " + id + ")");
            return "via2_form";
        } catch (BirthdayNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/viabirthdays";

    }

    }
    @GetMapping("/viabirthdays/delete/{id}")
    public String deleteBirthday(@PathVariable("id") Integer id,RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", " The event ID  " + id + "  has been succesfully deleted");
        } catch (BirthdayNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
            return "redirect:/viabirthdays";

        }


    @GetMapping("/via2")
    public String via2() {
        return "via2";
    }


}
