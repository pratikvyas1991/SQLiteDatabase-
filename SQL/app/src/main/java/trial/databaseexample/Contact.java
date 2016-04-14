package trial.databaseexample;

/**
 * Created by Vyas on 4/14/2016.
 */
public class Contact {
    //private variable
    private int id;
    private String name;
    private String mobile;

    public Contact() {
    }

    public Contact(int id, String name, String mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }

    public Contact(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
