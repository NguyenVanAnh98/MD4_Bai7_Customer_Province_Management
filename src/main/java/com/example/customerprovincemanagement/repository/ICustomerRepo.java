package com.example.customerprovincemanagement.repository;

import com.example.customerprovincemanagement.model.Province;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepo extends CrudRepository<Province, Long> {
}
