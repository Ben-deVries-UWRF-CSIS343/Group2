package org.springframework.projectname;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Data
//@NoArgsConstructor
public class Address {
    // id is a unique identifier for addresses
    @Id @GeneratedValue
    private int id;
    private @NonNull String name;

    public boolean isStartingPoint = false;
    public boolean isEndingPoint = false;

    // eg. 123 Main St
    public String addressLine1 = "";

    // eg. apt 2
    public String addressLine2 = "";

    // eg. 12345
    public int zipCode;

    // eg. Minnesota OR MN
    public String state = "";

    // eg. Minneapolis
    public String city = "";

    // used for determining if the 1 address is the same as another
    // cannot use the == operator because they may not exist at the same point in
    // the HEAP
    // note this will return false if they are the same with the exception of the
    // state 'Minnesota' and 'MN' which are the same logically will be seen as
    // different.
    @Override
    public boolean equals(Object otherObj) {
        if (otherObj instanceof Address) {
            // otherObj is an address object, so type cast it to one
            Address addr = (Address) otherObj;

            // do a data by data comparison
            // assume that these are equal to eachother
            Boolean flag = true;

            // then prove they are not
            if (!(addressLine1.equals(addr.addressLine1))) {
                flag = false;
            }
            if (!(addressLine2.equals(addr.addressLine2))) {
                flag = false;
            }
            if (!(zipCode == (addr.zipCode))) {
                flag = false;
            }
            if (!(state.equals(addr.state))) {
                flag = false;
            }
            if (!(city.equals(addr.city))) {
                flag = false;
            }

        } else {
            // they cannot be the same if not comparing the same type
            return false;
        }
    return true;
    }

    public Address() { }

    public Address(int id,
                   String name,
                   String addressLine1,
                   String addressLine2,
                   int zipCode,
                   String state,
                   String city) {
        this.setId(id);
        this.setName(name);
        this.setAddressLine1(addressLine1);
        this.setAddressLine2(addressLine2);
        this.setZipCode(zipCode);
        this.setState(state);
        this.setCity(city);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        // formatted in the googlemaps needed string
        String retVal = addressLine1.trim() + "," + "+" + city.trim() + "," + "+" + state.trim() + "+" + zipCode;
        retVal = retVal.replace(" ", "+");
        // 456+2nd+Ave+S,+Minneapolis,+MN+55401
        return retVal;
    }
}