package com.example.customerprovincemanagement.controller;

import com.example.customerprovincemanagement.model.Province;
import com.example.customerprovincemanagement.service.ICustomerService;
import com.example.customerprovincemanagement.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;
    @Autowired
    private ICustomerService customerService;
    @GetMapping
    public ModelAndView listProvince(){
        ModelAndView modelAndView = new ModelAndView("/province/list");
        Iterable<Province> provinces = provinceService.findAll();
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }
    @GetMapping("create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }
    @PostMapping("create")
    public String create(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes){
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "Them moi thanh cong");
        return "redirect:/provinces";
    }
}
