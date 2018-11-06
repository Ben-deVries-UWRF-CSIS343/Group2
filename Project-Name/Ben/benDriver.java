import java.util.ArrayList;

public class benDriver {
    public boolean runTests() {

        ArrayList<Exception> al = new ArrayList();

        al.addRange(testAddresses());

        return al.size() == 0;
    }

    public static void testing() {
        address a1 = new address();
        address a2 = new address();

        a1.addressLine1 = "123 Main St";
        a1.city = "Hudson";
        a1.state = "WI";
        a1.zipCode = 54016;

        a2.addressLine1 = "456 2nd St";
        a2.city = "river falls";
        a2.state = "WI";
        a2.zipCode = 54022;

        for (int i = 0; i <= 20; i++) {

            googleMapsInteracter.getDistanceFromAddress(a1, a2);

            System.out.println(i);
        }

    }
}