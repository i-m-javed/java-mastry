import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import entity.Employee;

import java.util.List;

// =======================
// CLIENT (MAIN)
// =======================
public class DAOPattern {

    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAOImpl();

        dao.save(new Employee(101, "Javed", 60000));

        Employee emp = dao.findById(101);
        System.out.println("Found: " + emp);

        List<Employee> employees = dao.findAll();
        employees.forEach(System.out::println);

        dao.delete(101);

        System.out.println("Employee deleted.");
    }
}