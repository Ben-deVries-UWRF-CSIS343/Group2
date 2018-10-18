public class address {
    public boolean isStartingPoint = false;
    public boolean isEndingPoint = false;

    // eg. 123 Main St
    public String addressLine1 = "";

    // eg. apt 2
    public String addressLine2 = "";

    // eg. 12345
    public integer zipCode = 0;

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
        if (otherObj instanceof address) {
            // otherObj is an address object, so type cast it to one
            address addr = (address) otherObj;

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
            if (!(zipcode = addr.zipCode)) {
                flag = false;
            }
            if (!(state.equals(addr.state))) {
                flag = false;
            }
            if (!(city.equals(addr.city))) {
                flag = false;
            }

            return flag;
        } else {
            // they cannot be the same if not comparing the same type
            return false;
        }
    }

}