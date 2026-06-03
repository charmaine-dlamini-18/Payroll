package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeServiceTest {

    private IEmployeeService service = EmployeeService.getService();
    Employee employee = EmployeeFactory.createEmployee("12345",
            "Chantelle",
            "Hendricks",
            "chantelle@gmail.com",java.time.LocalDate.of(1996, 12, 25), "964567890123");
    @Test
    void a_create() {
        Employee created = service.create(employee);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        Employee read = service.read(employee.getEmployeeNumber());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Employee newEmployee = new Employee.Builder()
                .copy(employee)
                .setLastName("Gibsons")
                .build();
        Employee updated = service.update(newEmployee);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void d_getAll() {
        System.out.println(service.getAll());
    }
}