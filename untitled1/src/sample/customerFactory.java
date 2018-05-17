package sample;

import com.sun.jdi.InvalidTypeException;

public class customerFactory {
    public Customer createCustomer(String item) {
        if (item.equals("regular")) {
            return new RegularCustomer();
        }
        else if (item.equals("friend")) {
            return new FriendOfLibrary(new RegularCustomer());
        }
        else if (item.equals("donor")) {
            return new Donor(new RegularCustomer());
        }
        else return null;
    }

}
