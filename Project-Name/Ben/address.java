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

    //
    // NOTE: this will return false if they are the same with the exception of the
    // state 'Minnesota' and 'MN' which are the same logically will be seen as
    // different.
    //
    @Override
    public boolean equals(Object otherObj) {
        if (otherObj instanceof address) {
            // otherObj is an address object, so type cast it to one
            address addr = (address) otherObj;

            // since strings are objects they need to call the .equals methon to compare and
            // not the == operator
            // then prove they are not
            if (!(addressLine1.equals(addr.addressLine1))) {
                return false;
            }
            if (!(addressLine2.equals(addr.addressLine2))) {
                return false;
            }
            if (!(zipcode = addr.zipCode)) {
                return false;
            }
            if (!(state.equals(addr.state))) {
                return false;
            }
            if (!(city.equals(addr.city))) {
                return false;
            }

            // if none of the if statements are true the 2 are have the same content and are
            // equal by content.
            return true;
        } else {
            // they cannot be the same if not comparing the same type
            return false;
        }
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