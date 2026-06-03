package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test
    void createEmployee() {
        Employee emp = EmployeeFactory.createEmployee("Emp100", "Charmaine", "Dlamini",
                "charmainedlamini@example.com", java.time.LocalDate.of(2001, 1, 18));
        assertNotNull(emp);
        System.out.println(emp);
    }
}