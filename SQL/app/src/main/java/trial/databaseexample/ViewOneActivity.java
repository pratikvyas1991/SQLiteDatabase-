package trial.databaseexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vyas on 4/17/2016.
 */
public class ViewOneActivity extends Activity {
    Button mBtnViewContact;
    Spinner mContactSpinner;
    TextView mContactId,mContactName,mContactMobile;
    ContactDatabaseHelper contactDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_one_layout);

        mBtnViewContact=(Button)findViewById(R.id.view_contact);
        mContactSpinner=(Spinner)findViewById(R.id.id_list);
        mContactId=(TextView)findViewById(R.id.contact_id_view_one);
        mContactName=(TextView)findViewById(R.id.contact_name_view_one);
        mContactMobile=(TextView)findViewById(R.id.contact_mobile_view_one);
        contactDatabaseHelper=new ContactDatabaseHelper(this);

        mBtnViewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public List<String> getContactID(){
        List<String> mIDList= new ArrayList<>();

        for (Contact contact:contactDatabaseHelper.getAllContacts()){
           mIDList.add(contact.getId());
        }
        return mIDList;
    }
}
