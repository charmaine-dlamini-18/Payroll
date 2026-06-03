package za.ac.cput.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeRepositoryTest {
    private static IEmployeeRepository repository = EmployeeRepository.getRepository();

    Employee employee = EmployeeFactory.createEmployee("Emp100", "Sabelo", "Ceza",
            "sabeloceza@example.com", java.time.LocalDate.of(2000, 1, 1), "1234567890090");
    @Test
    void a_create() {
        Employee created = repository.create(employee);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        Employee read = repository.read(employee.getEmployeeNumber());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Employee newEmployee = new Employee.Builder()
                .copy(employee)
                .setLastName("Dlamini")
                .build();
        Employee updated = repository.update(newEmployee);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Disabled
    void d_delete() {
        assertTrue(repository.delete(employee.getEmployeeNumber()));
        System.out.println("Success: employee deleted");
    }

    @Test
    void e_getAll() {
        System.out.println(repository.getAll());
    }
}
