package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    private String streetNumber;
    private String streetName;
    private String city;
    private String postalCode;

    protected Address(){

    }
    private Address(Builder builder) {
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.city = builder.city;
        this.postalCode = builder.postalCode;

    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return
                "\nStreet Number: " + streetNumber +
                        "\nStreet Name: " + streetName +
                        "\nCity: " + city +
                        "\nPostal Code: " + postalCode;
    }

    //Builder class
    public static class Builder{
        private String streetNumber;
        private String streetName;
        private String city;
        private String postalCode;

        public Builder copy(Address address){
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.city = address.city;
            this.postalCode = address.postalCode;
            return this;
        }

        public Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Address build(){

            return new Address(this);
        }
    }

}

