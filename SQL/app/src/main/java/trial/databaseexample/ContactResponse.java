package trial.databaseexample;

import java.util.List;

/**
 * Created by Vyas on 4/17/2016.
 */
public class ContactResponse{
    public List<Contact> contactList;

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
}
