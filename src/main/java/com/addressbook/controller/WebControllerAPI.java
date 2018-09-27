package com.addressbook.controller;

import com.addressbook.entity.Company;
import com.addressbook.entity.Employee;
import com.addressbook.entity.Position;
import com.addressbook.entity.WorkPlace;
import com.addressbook.json.AddressBookJSON;
import com.addressbook.service.CompanyService;
import com.addressbook.service.EmployeeService;
import com.addressbook.service.WorkPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/addressBook/api")
public class WebControllerAPI {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CompanyService companyService;

    @Autowired
    WorkPlaceService workPlaceService;

    @RequestMapping("/init")
    public ResponseEntity<String> save() {

        Employee jack = new Employee("Jack", "Pett");
        jack.setId(1);
        employeeService.create(jack);

        Company companyFirst = new Company("First");
        companyFirst.setId(1);
        companyService.create(companyFirst);

        WorkPlace workPlaceJack = new WorkPlace();
        workPlaceJack.setId(1);
        workPlaceJack.setCompany(companyFirst);
        workPlaceJack.setEmployee(jack);
        workPlaceJack.setPosition(Position.ACCOUNTANT);
        workPlaceService.create(workPlaceJack);


        return new ResponseEntity<String>("Done", HttpStatus.CREATED);
    }

    @RequestMapping("/all")
    public ResponseEntity<AddressBookJSON> findAllAddressBook() {

        AddressBookJSON contactJSON = new AddressBookJSON();

        List<Employee> employeeList = employeeService.findAll();
        List<Company> companyList = companyService.findAll();

        contactJSON.putContacts(employeeList);
        contactJSON.addContacts(companyList);

        return new ResponseEntity<AddressBookJSON>(contactJSON, HttpStatus.OK);
    }

    @RequestMapping("/all2")
    public String findAllAddressBook2() {

        AddressBookJSON contactJSON = new AddressBookJSON();

        List<Employee> employeeList = employeeService.findAll();
        List<Company> companyList = companyService.findAll();

        contactJSON.putContacts(employeeList);
        contactJSON.addContacts(companyList);

        return String.valueOf(contactJSON);
    }

}
