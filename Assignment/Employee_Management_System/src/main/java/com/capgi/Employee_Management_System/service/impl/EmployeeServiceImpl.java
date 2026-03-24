package com.capgi.Employee_Management_System.service.impl;

import com.capgi.Employee_Management_System.entity.Employee;
import com.capgi.Employee_Management_System.repository.EmployeeRepository;
import com.capgi.Employee_Management_System.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository repo;


    @Override
    public Employee registerEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Employee login(String email, String password) {
        Employee emp = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!emp.getPassword().equals(password))
            throw new RuntimeException("Invalid password");

        return emp;
    }

    @Override
    public String logout(Integer empId) {
        return "Employee " + empId + " logged out successfully";
    }


    @Override
    public Employee addEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Employee updateEmployee(Integer empId, Employee employee) {
        Employee existing = repo.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setEmpId(empId);
        return repo.save(employee);
    }

    @Override
    public void deleteEmployee(Integer empId) {
        repo.deleteById(empId);
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer empId) {
        return repo.findById(empId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }


    @Override
    public String changeEmployeeRole(Integer empId, String role) {
        Employee emp = repo.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        emp.setRole(role);
        repo.save(emp);

        return "Role updated successfully";
    }

    @Override
    public List<Employee> getEmployeesByRole(String role) {
        System.out.println(role);
        return repo.findByRole(role);
    }


    @Override
    public List<Employee> sortEmployeesBySalaryComparable() {
        List<Employee> list = repo.findAll();
        Collections.sort(list); // Uses Comparable
        return list;
    }


    @Override
    public List<Employee> sortEmployeesByName() {
        return repo.findAll().stream()
                .sorted(Comparator.comparing(Employee::getName))
                .toList();
    }

    @Override
    public List<Employee> sortEmployeesBySalary() {
        return repo.findAll().stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList();
    }

    @Override
    public List<Employee> sortEmployeesByExperience() {
        return repo.findAll().stream()
                .sorted(Comparator.comparing(Employee::getExperienceYears))
                .toList();
    }


    @Override
    public List<Employee> getEmployeesWithHighSalary(Double salary) {
        return repo.findAll().stream()
                .filter(e -> e.getSalary() > salary)
                .toList();
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String deptName) {
        return repo.findByDeptName(deptName);
    }

    @Override
    public List<Employee> getEmployeesJoinedAfterYear(int year) {
        return repo.findAll().stream()
                .filter(e -> e.getJoinDate().getYear() > year)
                .toList();
    }

    @Override
    public Double getTotalSalaryExpense() {
        return repo.findAll().stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @Override
    public Double getAverageSalary() {
        return repo.findAll().stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

    @Override
    public List<Employee> getTopHighestPaidEmployees(int limit) {
        return repo.findAll().stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(limit)
                .toList();
    }

    @Override
    public List<Employee> getEmployeesWithExperienceGreaterThan(int years) {
        return repo.findAll().stream()
                .filter(e -> e.getExperienceYears() > years)
                .toList();
    }

    @Override
    public List<String> getAllEmployeeNames() {
        return repo.findAll().stream()
                .map(Employee::getName)
                .toList();
    }

    @Override
    public Long countEmployeesByDepartment(String deptName) {
        return repo.findAll().stream()
                .filter(e -> e.getDeptName().equals(deptName))
                .count();
    }
}