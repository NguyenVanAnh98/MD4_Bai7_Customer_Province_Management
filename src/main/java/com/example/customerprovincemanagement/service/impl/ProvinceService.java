package com.example.customerprovincemanagement.service.impl;

import com.example.customerprovincemanagement.model.Province;
import com.example.customerprovincemanagement.repository.ICustomerRepo;
import com.example.customerprovincemanagement.repository.IProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProvinceService implements IProvinceRepo {
    @Autowired
    private ICustomerRepo iProvinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return iProvinceRepository.findAll();
    }

    @Override
    public void save(Province province) {
        iProvinceRepository.save(province);
    }

    @Override
    public Optional<Province> findById(Long id) {
        return iProvinceRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iProvinceRepository.deleteById(id);
    }
}
