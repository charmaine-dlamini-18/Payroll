package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeControllerTest {

    private static Employee employee;

    @Autowired
    private TestRestTemplate restTemplate;
    private static final String BASE_URL = "http://localhost:8080/Payroll/employee";

    @BeforeAll
    public static void setUp(){
        employee = EmployeeFactory.createEmployee("Emp2001",
                "Richard",
                "Hendricks",
                "charmainedlamini@gmail.com",java.time.LocalDate.of(1997, 12, 25), "974567890100");
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        Employee createdEmployee = this.restTemplate.postForObject(url, employee, Employee.class);
        assertNotNull(createdEmployee);
        assertEquals(employee.getEmployeeNumber(), createdEmployee.getEmployeeNumber());
        System.out.println("Created Employee: " + createdEmployee);

        /*Another Option
        ResponseEntity<Employee> postResponse = this.restTemplate.postForEntity(url,employee, Employee.class);
        assertNotNull(postResponse);
        Employee employeeSaved = postResponse.getBody();
        assertEquals(employee.getEmployeeNumber(), employeeSaved.getEmployeeNumber());
        System.out.println("Created: " + employeeSaved);
         */
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + employee.getEmployeeNumber();
        ResponseEntity<Employee> response = this.restTemplate.getForEntity(url, Employee.class);
        assertNotNull(response.getBody());
        assertEquals(employee.getEmployeeNumber(), response.getBody().getEmployeeNumber());
        System.out.println("Read Employee: " + response.getBody());

    }

    @Test
    void c_update() {
        Employee updatedEmployee = new Employee.Builder()
                .copy(employee)
                .setLastName("Chadson")
                .build();

        String url = BASE_URL + "/update";
        this.restTemplate.put(url, updatedEmployee);

        //Verify that update by reading update employee
        ResponseEntity<Employee> response = restTemplate.getForEntity(BASE_URL + "/read/" + updatedEmployee.getEmployeeNumber(), Employee.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        System.out.println("Updated Employee" + response.getBody());

        //Another option
        // String url = BASE_URL + "/update";
        /*ResponseEntity<Employee> response = this.restTemplate.postForEntity(url, updatedEmployee, Employee.class);
        assertNotNull(response.getBody());
        assertEquals(updatedEmployee.getLastName(), response.getBody().getLastName());
        System.out.println("Updated Employee" + response.getBody());
        */

    }


    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + employee.getEmployeeNumber();
        this.restTemplate.delete(url);

        //Verify that employee was deleted
        ResponseEntity<Employee> response = restTemplate.getForEntity(BASE_URL + "/read/" + employee.getEmployeeNumber(), Employee.class);
        assertNull(response.getBody());
        System.out.println("Deleted Employee: " + "true");

    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/getAll";
        ResponseEntity<Employee[]> response = this.restTemplate.getForEntity(url, Employee[].class);
        assertNotNull(response.getBody());
        System.out.println("Get All Employee: ");
        for (Employee employee : response.getBody()){
            System.out.println(employee);
        }
    }
}