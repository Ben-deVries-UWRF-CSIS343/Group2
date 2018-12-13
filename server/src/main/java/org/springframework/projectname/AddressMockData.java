package org.springframework.projectname;

import java.util.ArrayList;
import java.util.List;

public class AddressMockData {
    // list of addresses
    private List<Address> addressList;

    private static AddressMockData instance = null;

    public static AddressMockData getInstance(){
        if (instance == null) {
            instance = new AddressMockData();
        }
        return instance;
    }

    public AddressMockData() {
        addressList = new ArrayList<Address>();
//        addressList.add(new Address(10, "Peter", "Peter-addressLine1", "Peter-addressLine2", "Peter-zipCode", "Peter-state", "Peter-city"));
//        addressList.add(new Address(11, "Ben", "Ben-addressLine1", "Ben-addressLine2", "Ben-zipCode", "Ben-state", "Ben-city"));
//        addressList.add(new Address(12, "Michael", "Michael-addressLine1", "Michael-addressLine2", "Michael-zipCode", "Michael-state", "Michael-city"));
    }

    public List<Address> fetchAddressList() {
        return addressList;
    }

    public Address getAddressById(int id) {
        for (Address a: addressList) {
            if(a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public Address createAddress(int id, String name, String addressLine1, String addressLine2, int zipcode, String state, String city) {
        Address newAddress = new Address(id, name, addressLine1, addressLine2, zipcode, state, city);
        addressList.add(newAddress);
        return newAddress;
    }

    public boolean deleteAddressById(int id) {
        int addressIndex = -1;
        for (Address a: addressList) {
            if(a.getId() == id){
                addressIndex = addressList.indexOf(a);
                continue;
            }
        }
        if (addressIndex > -1) {
            addressList.remove(addressIndex);
        }
        return true;
    }
}