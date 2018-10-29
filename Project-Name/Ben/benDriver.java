import java.util.ArrayList;

import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

// this is for testing on the files under the 'ben' sub directory
// DO NOT CHANGE

public class benDriver {

    public boolean runTests() {

        ArrayList<Exception> al = new ArrayList();

        al.addRange(testAddresses());

        return al.size() == 0;
    }

    public ArrayList<Exception> testAddresses() {
        ArrayList<Exception> al = new ArrayList();

        address addr = new address();
        address addr2 = new address();

        // create identical addresses
        addr.addressLine1 = "123 Main St.";
        addr.addressLine2 = "";
        addr.city = "River Falls";
        addr.state = "WI";
        addr.zipCode = 54987;

        addr2.addressLine1 = "123 Main St.";
        addr2.addressLine2 = "";
        addr2.city = "River Falls";
        addr2.state = "WI";
        addr2.zipCode = 54987;

        if (!(addr.equals(addr))) {
            al.add(new Exception("The address class is not properly running comparisons: addr = addr"));
        }
        if (!(addr.equals(addr2))) {
            al.add(new Exception("The address class is not properly running comparisons: addr = addr2"));
        }

        addr2.addressLine1 = "124 Main St.";
        addr2.addressLine2 = "";
        addr2.city = "River Falls";
        addr2.state = "WI";
        addr2.zipCode = 54987;

        if (addr.equals(addr2)) {
            al.add(new Exception(
                    "The address class is not properly running comparisons: addr = modified address line 1"));
        }

        addr2.addressLine1 = "123 Main St.";
        addr2.addressLine2 = "1";

        if (addr.equals(addr2)) {
            al.add(new Exception(
                    "The address class is not properly running comparisons: addr = modified address line 2"));
        }

        addr.addressLine2 = "";
        addr.city = "Hudson";

        if (addr.equals(addr2)) {
            al.add(new Exception("The address class is not properly running comparisons: addr = modified city"));
        }

        addr.city = "River Falls";
        addr.state = "CA";

        if (addr.equals(addr2)) {
            al.add(new Exception("The address class is not properly running comparisons: addr = modified state"));
        }

        addr.state = "WI";
        addr.zipCode = 99999;

        if (addr.equals(addr2)) {
            al.add(new Exception("The address class is not properly running comparisons: addr = modified zip code"));
        }

        // return the list of exceptions
        return al;
    }
}