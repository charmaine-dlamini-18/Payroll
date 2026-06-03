package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;

public class AddressFactory {
    public static Address createAddress(String streetNumber,
                                        String streetName,
                                        String city,
                                        String postalCode) {

        if(Helper.isNull(streetNumber)
                || Helper.isNull(streetName)
                || Helper.isNull(city)
                || Helper.isNull(postalCode)
        ){
            return null;
        }
        return new Address.Builder()
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setCity(city)
                .setPostalCode(postalCode)
                .build();
    }
}
