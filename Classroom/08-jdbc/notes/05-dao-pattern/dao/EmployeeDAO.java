package dao;

import entity.Employee;

import java.util.List;
// =======================
// DAO INTERFACE
// =======================
public interface EmployeeDAO {

    void save(Employee employee);

    Employee findById(int id);

    List<Employee> findAll();

    void delete(int id);
}
