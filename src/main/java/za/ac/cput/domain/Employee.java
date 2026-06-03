package za.ac.cput.domain;

import jakarta.persistence.*;


import java.lang.*;
import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    private String employeeNumber;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;

    @OneToOne
    @JoinColumn(name="address_id")
    private Address address;
    protected Employee(){

    }

    //Builder
    private Employee (Builder builder) {
        this.employeeNumber = builder.employeeNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.dateOfBirth = builder.dateOfBirth;
        this.address = builder.address;

    }

    //Constructor with parameters
    public Employee(String employeeNumber, String firstName, String lastName, String email, LocalDate dateOfBirth, Address address){
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;

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

    public Address getAddress() {
        return address;
    }

    //to string
    public String toString(){
        return "--------------Employee--------------" +
               "\nEmployee Number: " + employeeNumber +
               "\nFirst Name: " + firstName +
               "\nLast Name: " + lastName +
               "\nEmail : " + email +
               "\nDate of Birth: " + dateOfBirth +
               "\nAddress: " + address;

    }

    //Builder class
    public static class Builder{

        private String employeeNumber;
        private String firstName;
        private String lastName;
        private String email;
        private LocalDate dateOfBirth;
        private Address address;

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

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }


        public Builder copy(Employee employee){
            this.employeeNumber = employee.employeeNumber;
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            this.email = employee.email;
            this.dateOfBirth = employee.dateOfBirth;
            this.address = employee.address;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }

}
