package com.capgi.Employee_Management_System.controller;

import com.capgi.Employee_Management_System.entity.Employee;
import com.capgi.Employee_Management_System.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;


    @PostMapping("/register")
    public Employee registerEmployee(@RequestBody Employee employee) {
        return service.registerEmployee(employee);
    }

    @PostMapping("/login")
    public Employee login(@RequestBody String email,
                          @RequestBody String password) {
        return service.login(email, password);
    }

    @PostMapping("/logout/{empId}")
    public String logout(@PathVariable Integer empId) {
        return service.logout(empId);
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    @PutMapping("/update/{empId}")
    public Employee updateEmployee(@PathVariable Integer empId,
                                   @RequestBody Employee employee) {
        return service.updateEmployee(empId, employee);
    }

    @DeleteMapping("/delete/{empId}")
    public void deleteEmployee(@PathVariable Integer empId) {
        service.deleteEmployee(empId);
    }

    @GetMapping("/{empId}")
    public Optional<Employee> getEmployeeById(@PathVariable Integer empId) {
        return service.getEmployeeById(empId);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }


    @PutMapping("/role/{empId}")
    public String changeEmployeeRole(@PathVariable Integer empId,
                                     @RequestParam String role) {
        return service.changeEmployeeRole(empId, role);
    }

    @GetMapping("/role")
    public List<Employee> getEmployeesByRole(@RequestParam String role) {
        return service.getEmployeesByRole(role);
    }


    @GetMapping("/sort/comparable/salary")
    public List<Employee> sortBySalaryComparable() {
        return service.sortEmployeesBySalaryComparable();
    }


    @GetMapping("/sort/name")
    public List<Employee> sortByName() {
        return service.sortEmployeesByName();
    }

    @GetMapping("/sort/salary")
    public List<Employee> sortBySalary() {
        return service.sortEmployeesBySalary();
    }

    @GetMapping("/sort/experience")
    public List<Employee> sortByExperience() {
        return service.sortEmployeesByExperience();
    }


    @GetMapping("/filter/high-salary")
    public List<Employee> getEmployeesWithHighSalary(@RequestParam Double salary) {
        return service.getEmployeesWithHighSalary(salary);
    }

    @GetMapping("/department")
    public List<Employee> getEmployeesByDepartment(@RequestParam String deptName) {
        return service.getEmployeesByDepartment(deptName);
    }

    @GetMapping("/joined-after")
    public List<Employee> getEmployeesJoinedAfterYear(@RequestParam int year) {
        return service.getEmployeesJoinedAfterYear(year);
    }

    @GetMapping("/salary/total")
    public Double getTotalSalaryExpense() {
        return service.getTotalSalaryExpense();
    }

    @GetMapping("/salary/average")
    public Double getAverageSalary() {
        return service.getAverageSalary();
    }

    @GetMapping("/top-paid")
    public List<Employee> getTopHighestPaidEmployees(@RequestParam int limit) {
        return service.getTopHighestPaidEmployees(limit);
    }

    @GetMapping("/experience")
    public List<Employee> getEmployeesWithExperienceGreaterThan(@RequestParam int years) {
        return service.getEmployeesWithExperienceGreaterThan(years);
    }

    @GetMapping("/names")
    public List<String> getAllEmployeeNames() {
        return service.getAllEmployeeNames();
    }

    @GetMapping("/count/department")
    public Long countEmployeesByDepartment(@RequestParam String deptName) {
        return service.countEmployeesByDepartment(deptName);
    }
}