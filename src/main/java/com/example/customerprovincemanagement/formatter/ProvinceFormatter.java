package com.example.customerprovincemanagement.formatter;

import com.example.customerprovincemanagement.model.Province;
import com.example.customerprovincemanagement.repository.IProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Optional;

@Component
public class ProvinceFormatter implements Formatter<Province> {

    private final IProvinceRepo provinceService;

    @Autowired
    public ProvinceFormatter(IProvinceRepo provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Province parse(String text, Locale locale) {
        Optional<Province> provinceOptional = provinceService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(Province object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
