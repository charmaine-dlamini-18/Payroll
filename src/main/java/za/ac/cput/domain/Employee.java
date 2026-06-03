package za.ac.cput.domain;

import java.lang.*;
import java.time.LocalDate;


public class Employee {
    private String employeeNumber;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private String identityNumber;

    private Employee(){

    }

    //Builder
    private Employee (Builder builder) {
        this.employeeNumber = builder.employeeNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.dateOfBirth = builder.dateOfBirth;
        this.identityNumber = builder.identityNumber;
    }

    //Constructor with parameters
    public Employee(String employeeNumber, String firstName, String lastName, String email, LocalDate dateOfBirth, String identityNumber){
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.identityNumber = identityNumber;

    }

    //Getters
    public String getEmployeeNumber(){
        return employeeNumber;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getEmail(){
        return email;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    public String getIdentityNumber(){
        return identityNumber;
    }

    //to string
    public String toString(){
        return "--------------Employee--------------" +
               "\nEmployee Number: " + employeeNumber +
               "\nFirst Name: " + firstName +
               "\nLast Name: " + lastName +
               "\nEmail : " + email +
               "\nDate of Birth: " + dateOfBirth +
               "\nIdentity Number : " + identityNumber;
    }

    //Builder class
    public static class Builder{

        private String employeeNumber;
        private String firstName;
        private String lastName;
        private String email;
        private LocalDate dateOfBirth;
        private String identityNumber;

        //Setters
        public Builder setEmployeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setIdentityNumber(String identityNumber) {
            this.identityNumber = identityNumber;
            return this;
        }

        public Builder copy(Employee employee){
            this.employeeNumber = employee.employeeNumber;
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            this.email = employee.email;
            this.dateOfBirth = employee.dateOfBirth;
            this.identityNumber = employee.identityNumber;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }

}
