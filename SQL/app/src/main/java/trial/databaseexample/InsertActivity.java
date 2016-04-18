package trial.databaseexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Vyas on 4/17/2016.
 */
public class InsertActivity extends Activity {
    EditText mContactID, mContactName, mContactNumber;
    Button mInsert,mView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_layout);
        mContactID =(EditText)findViewById(R.id.contact_id);
        mContactName =(EditText)findViewById(R.id.contact_name);
        mContactNumber =(EditText)findViewById(R.id.contact_mobile);
        mInsert =(Button)findViewById(R.id.insert);
        mView = (Button)findViewById(R.id.view);

        final ContactDatabaseHelper contactDatabaseHelper= new ContactDatabaseHelper(this);



        mInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Contact contact = new Contact();
                contact.setId(mContactID.getText().toString());
                contact.setName(mContactName.getText().toString());
                contact.setMobile(mContactNumber.getText().toString());
                long returnCode = contactDatabaseHelper.insertIntoContact(contact);
                if(returnCode!=-1){
                    Toast.makeText(getApplicationContext(),"Sucessfully saved ",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Sorry Error in Saving Contact",Toast.LENGTH_LONG).show();
                }
            }
        });
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("contact Information","####");
                for (Contact contact1:contactDatabaseHelper.getAllContacts()){
                    Log.d("ID : ",contact1.getId());
                    Log.d("Name : ",contact1.getName());
                    Log.d("Mobile : ",contact1.getMobile());
                }
            }
        });

    }
}
