package za.ac.cput.factory;

import za.ac.cput.domain.Employee;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class EmployeeFactory {
    public static Employee createEmployee(String employeeNumber, String firstName,
                                          String lastName, String email, LocalDate dateOfBirth,
                                          String identityNumber){

        if (Helper.isNullOrEmpty(employeeNumber)|| Helper.isNullOrEmpty(firstName)||
            Helper.isNullOrEmpty(lastName) ){
            return null;
        }
        if (Helper.isNull(dateOfBirth)){
            return null;
        }
        if (!Helper.isValid(email)){
            return null;
        }

        return new Employee.Builder()
                .setEmployeeNumber(employeeNumber)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setDateOfBirth(dateOfBirth)
                .setIdentityNumber(identityNumber)
                .build();
    }

}
