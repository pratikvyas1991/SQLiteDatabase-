package trial.databaseexample;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vyas on 4/17/2016.
 */
public class ViewAllActivity extends Activity {
    ListView mContactListView;
    ContactDatabaseHelper contactDatabaseHelper;
    TextView mTextList;
    ListAdapter listAdapter;
    List<String> idList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_all_layout);
        mContactListView=(ListView)findViewById(R.id.contact_list_view);
        contactDatabaseHelper = new ContactDatabaseHelper(this);




        Log.d("contact Information","####");
        for (Contact contact1:contactDatabaseHelper.getAllContacts()){
            Log.d("ID : ",contact1.getId());
            Log.d("Name : ",contact1.getName());
            Log.d("Mobile : ",contact1.getMobile());
        }
        mContactListView.setAdapter(new ContactBaseAdapter(this,contactDatabaseHelper.getAllContacts()));
    }
}
