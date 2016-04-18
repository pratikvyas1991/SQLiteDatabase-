package trial.databaseexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
    Button mBtnInsert,mBtnViewAll,mBtnUpdate,mBtnDelete,mBtnViewOne,mBtnDeleteAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);

        // initializing All the Buttons
        mBtnInsert =(Button)findViewById(R.id.btn_insert);
        mBtnViewAll =(Button)findViewById(R.id.btn_view_all);
        mBtnUpdate =(Button)findViewById(R.id.btn_update);
        mBtnDelete =(Button)findViewById(R.id.btn_delete);
        mBtnViewOne =(Button)findViewById(R.id.btn_view_one);
        mBtnDeleteAll=(Button)findViewById(R.id.btn_delete_all);

        //Passing Context to each button
        mBtnInsert.setOnClickListener(this);
        mBtnViewAll.setOnClickListener(this);
        mBtnUpdate.setOnClickListener(this);
        mBtnViewOne.setOnClickListener(this);
        mBtnDeleteAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_insert:
                Toast.makeText(getApplicationContext(),"Insert",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Dashboard.this,InsertActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_view_all:
                Toast.makeText(getApplicationContext(),"View All",Toast.LENGTH_LONG).show();
                Intent intent1= new Intent(Dashboard.this,ViewAllActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_update:
                Toast.makeText(getApplicationContext(),"Update",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_delete:
                Toast.makeText(getApplicationContext(),"Delete",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_view_one:
                Toast.makeText(getApplicationContext(),"View One",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_delete_all:
                Toast.makeText(getApplicationContext(),"Delete All",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
