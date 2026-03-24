package com.capgi.Employee_Management_System.service;

import com.capgi.Employee_Management_System.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    // ================================
    // AUTHENTICATION METHODS
    // ================================

    /**
     * Register a new employee in the system.
     * This method allows a new user to create an account.
     * Accessible by: ADMIN or REGULAR (self registration)
     */
    Employee registerEmployee(Employee employee);


    /**
     * Login using email and password.
     * Returns employee object if credentials match.
     * Accessible by: ADMIN and REGULAR
     */
    Employee login(String email, String password);


    /**
     * Logout method for employee.
     * Accessible by: ADMIN and REGULAR
     */
    String logout(Integer empId);


    // ================================
    // CRUD OPERATIONS
    // ================================

    /**
     * Add a new employee to the system.
     * Accessible by: ADMIN only
     */
    Employee addEmployee(Employee employee);


    /**
     * Update employee details.
     * Accessible by: ADMIN
     * REGULAR user can update only their own profile.
     */
    Employee updateEmployee(Integer empId, Employee employee);


    /**
     * Delete an employee from the system.
     * Accessible by: ADMIN only
     */
    void deleteEmployee(Integer empId);


    /**
     * Retrieve employee by ID.
     * ADMIN can view any employee.
     * REGULAR can view only their own profile.
     */
    Optional<Employee> getEmployeeById(Integer empId);


    /**
     * Retrieve all employees in the organization.
     * Accessible by: ADMIN only
     */
    List<Employee> getAllEmployees();


    // ================================
    // ROLE MANAGEMENT
    // ================================

    /**
     * Change role of an employee.
     * Example: REGULAR -> ADMIN
     * Accessible by: ADMIN only
     */
    String changeEmployeeRole(Integer empId, String role);


    /**
     * Get employees by role.
     * Accessible by: ADMIN
     */
    List<Employee> getEmployeesByRole(String role);


    // ================================
    // COMPARABLE BASED SORTING
    // ================================

    /**
     * Sort employees by salary using Comparable implementation.
     * Accessible by: ADMIN
     */
    List<Employee> sortEmployeesBySalaryComparable();


    // ================================
    // COMPARATOR BASED SORTING
    // ================================

    /**
     * Sort employees by name using Comparator.
     * Accessible by: ADMIN
     */
    List<Employee> sortEmployeesByName();


    /**
     * Sort employees by salary using Comparator.
     * Accessible by: ADMIN
     */
    List<Employee> sortEmployeesBySalary();


    /**
     * Sort employees by experience using Comparator.
     * Accessible by: ADMIN
     */
    List<Employee> sortEmployeesByExperience();


    // ================================
    // STREAM API OPERATIONS
    // ================================

    /**
     * Get employees whose salary is greater than given value.
     * Uses Stream filter().
     * Accessible by: ADMIN
     */
    List<Employee> getEmployeesWithHighSalary(Double salary);


    /**
     * Get employees by department.
     * Uses Stream filter().
     * Accessible by: ADMIN and REGULAR (same department)
     */
    List<Employee> getEmployeesByDepartment(String deptName);


    /**
     * Get employees who joined after a particular year.
     * Uses Stream filter().
     * Accessible by: ADMIN
     */
    List<Employee> getEmployeesJoinedAfterYear(int year);


    /**
     * Calculate total salary expenditure of company.
     * Uses Stream reduce().
     * Accessible by: ADMIN
     */
    Double getTotalSalaryExpense();


    /**
     * Calculate average salary of employees.
     * Uses Stream average().
     * Accessible by: ADMIN
     */
    Double getAverageSalary();


    /**
     * Retrieve top highest paid employees.
     * Uses Stream sorted() and limit().
     * Accessible by: ADMIN
     */
    List<Employee> getTopHighestPaidEmployees(int limit);


    /**
     * Retrieve employees having experience greater than given years.
     * Uses Stream filter().
     * Accessible by: ADMIN
     */
    List<Employee> getEmployeesWithExperienceGreaterThan(int years);


    /**
     * Get list of all employee names.
     * Uses Stream map().
     * Accessible by: ADMIN
     */
    List<String> getAllEmployeeNames();


    /**
     * Count employees in a department.
     * Uses Stream count().
     * Accessible by: ADMIN
     */
    Long countEmployeesByDepartment(String deptName);

}