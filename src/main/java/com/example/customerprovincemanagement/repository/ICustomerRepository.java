package com.example.customerprovincemanagement.repository;

import com.example.customerprovincemanagement.model.Province;
import com.example.customerprovincemanagement.service.IGenerateService;

import java.util.Optional;

public interface IProvinceRepo extends IGenerateService<Province> {
    Iterable<Province> findAll();

    void save(Province province);

    Optional<Province> findById(Long id);

    void remove(Long id);
}
