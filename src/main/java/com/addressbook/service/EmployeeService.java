package com.addressbook.service;

import com.addressbook.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee create(Employee employee);

    List<Employee> findAll();

    Employee findEmployeeById(Integer id);

    void delete(Employee employee);

}
