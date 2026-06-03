package za.ac.cput.repository;

import za.ac.cput.domain.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository{

        private static IEmployeeRepository repository = null;
        private List<Employee> employeeList;

        private EmployeeRepository(){
            employeeList = new ArrayList<>();
        }


        public static IEmployeeRepository getRepository(){
            if (repository == null){
                repository = new za.ac.cput.repository.EmployeeRepository();
            }
            return repository;
        }

        @Override
        public Employee create(Employee employee) {
            boolean success = employeeList.add(employee);
            if (success){
                return employee;
            }
            return null;
        }

        @Override
        public Employee read(String employeeNumber) {
            for (Employee employee: employeeList){
                if (employee.getEmployeeNumber().equals(employeeNumber)) {
                    return employee;
                }
            }
            return null;
        }

        @Override
        public Employee update(Employee employee) {
            String employeeNumber = employee.getEmployeeNumber();
            Employee oldEmployee = read(employeeNumber);
            if (oldEmployee == null) {
                return null;
            }
            boolean success = employeeList.remove(oldEmployee);
            if (success){
                if (employeeList.add(employee)) {
                    return employee;
                }
            }
            return null;
        }

        @Override
        public boolean delete(String employeeNumber) {
            Employee employeeToDelete = read(employeeNumber);
            if (employeeToDelete == null) {
                return false;
            }
            return (employeeList.remove(employeeToDelete));
        }

        @Override
        public List<Employee> getAll() {
            return employeeList;
        }
    }


