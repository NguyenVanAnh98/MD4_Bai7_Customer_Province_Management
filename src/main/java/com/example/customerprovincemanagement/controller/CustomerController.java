package com.example.customerprovincemanagement.controller;

import com.example.customerprovincemanagement.model.Customer;
import com.example.customerprovincemanagement.model.Province;
import com.example.customerprovincemanagement.repository.IProvinceRepo;
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
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private IProvinceRepo provinceService;
    @Autowired
    private ICustomerService customerService;
    @ModelAttribute("provinces")
    public Iterable<Province> listProvinces() {
        return provinceService.findAll();
    }
    @GetMapping
    public ModelAndView listCustomer(){
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        Iterable<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Them moi thanh cong");
        return "redirect:/customers";
    }
}
