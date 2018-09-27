package com.addressbook.controller;

        import com.addressbook.entity.Company;
        import com.addressbook.entity.Employee;
        import com.addressbook.entity.WorkPlace;
        import com.addressbook.service.CompanyService;
        import com.addressbook.service.EmployeeService;
        import com.addressbook.service.WorkPlaceService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

        import javax.servlet.http.HttpServletRequest;
        import java.util.List;

@Controller
public class WebController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CompanyService companyService;

    @Autowired
    WorkPlaceService workPlaceService;

    @RequestMapping(value = {"/addressBook/", "/addressBook/index"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {

        List<Employee> employeeList = employeeService.findAll();
        List<Company> companyList = companyService.findAll();

        model.addAttribute("employeeList", employeeList);
        model.addAttribute("companyList", companyList);

        return "index";
    }


    @RequestMapping(value = "/addressBook/editEmployee/{id}", method = RequestMethod.GET)
    public String updateEmployee(Model model, @PathVariable("id") Integer id) {

        if (id == 0) {
            model.addAttribute("employee", new Employee());
            return "editEmployee";
        }
        Employee employee = employeeService.findEmployeeById(id);
        if (employee == null) {
            model.addAttribute("employee", new Employee());
        } else {
            model.addAttribute("employee", employee);
        }
        return "editEmployee";
    }

    @RequestMapping(value = "/addressBook/editEmployee/{id}", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.create(employee);

        return "redirect:/addressBook/index";
    }

    @RequestMapping(value = "/addressBook/deleteEmployee/{id}", method = RequestMethod.GET)
    public String deleteEmployee(Model model, @PathVariable("id") Integer id) {

        Employee employee = employeeService.findEmployeeById(id);
        employeeService.delete(employee);

        return "redirect:/addressBook/index";
    }

    @RequestMapping(value = "/addressBook/editCompany/{id}", method = RequestMethod.GET)
    public String updateCompany(Model model, @PathVariable("id") Integer id) {

        if (id == 0) {
            model.addAttribute("company", new Company());
            return "editCompany";
        }
        Company company = companyService.findCompanyById(id);
        if (company == null) {
            model.addAttribute("company", new Company());
        } else {
            model.addAttribute("company", company);
        }
        return "editCompany";
    }

    @RequestMapping(value = "/addressBook/editCompany/{id}", method = RequestMethod.POST)
    public String saveCompany(@ModelAttribute("company") Company company) {

        companyService.create(company);

        return "redirect:/addressBook/index";
    }

    @RequestMapping(value = "/addressBook/deleteCompany/{id}", method = RequestMethod.GET)
    public String deleteCompany(Model model, @PathVariable("id") Integer id) {

        Company company = companyService.findCompanyById(id);
        companyService.delete(company);

        return "redirect:/addressBook/index";
    }

    @RequestMapping(value = "/addressBook/deleteEmployeeWorkPlace/{id}", method = RequestMethod.GET)
    public String deleteEmployeeWorkPlace(Model model, @PathVariable("id") Integer id) {

        WorkPlace workPlace = workPlaceService.findWorkPlaceById(id);
        int employeeId = workPlace.getEmployee().getId();
        workPlaceService.delete(workPlace);

        return "redirect:/addressBook/editEmployee/" + employeeId;
    }

    @RequestMapping(value = "/addressBook/deleteCompanyWorkPlace/{id}", method = RequestMethod.GET)
    public String deleteCompanyWorkPlace(Model model, @PathVariable("id") Integer id) {

        WorkPlace workPlace = workPlaceService.findWorkPlaceById(id);
        int companyId = workPlace.getCompany().getId();
        workPlaceService.delete(workPlace);

        return "redirect:/addressBook/editCompany/" + companyId;
    }
}
