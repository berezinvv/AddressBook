package com.addressbook.service;

import com.addressbook.entity.Employee;
import com.addressbook.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }
}
