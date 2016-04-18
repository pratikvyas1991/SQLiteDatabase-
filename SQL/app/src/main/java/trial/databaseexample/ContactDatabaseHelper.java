package trial.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vyas on 4/14/2016.
 */
public class ContactDatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="contact_manager";
    public static final String TABLE_NAME="contacts";

    public static final String ID="mContactID";
    public static final String NAME="mContactName";
    public static final String PHONE="phone";

    public ContactDatabaseHelper(Context context) {
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACT_TABLE=" CREATE TABLE "+TABLE_NAME+" ( "+ID+" INTEGER PRIMARY KEY, "
                                      +NAME+" TEXT, "+PHONE+" TEXT )";
        db.execSQL(CREATE_CONTACT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);

    }
    public long insertIntoContact(Contact contact){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(ID,contact.getId());
        contentValues.put(NAME,contact.getName());
        contentValues.put(PHONE,contact.getMobile());

        long responseCode=db.insert(TABLE_NAME,null,contentValues);
        return responseCode;
    }

    public List<Contact> getAllContacts(){
        SQLiteDatabase db= this.getReadableDatabase();
        List<Contact> contactList= new ArrayList<>();

        String selctQuery="SELECT * FROM "+TABLE_NAME;

        Cursor cursor=db.rawQuery(selctQuery,null);

        if(cursor.moveToFirst()){
            do{
                Contact contact= new Contact();
                contact.setId((cursor.getString(cursor.getColumnIndex(ID))));
                contact.setName(cursor.getString(cursor.getColumnIndex(NAME)));
                contact.setMobile(cursor.getString(cursor.getColumnIndex(PHONE)));
                contactList.add(contact);
            }while(cursor.moveToNext());
        }
       return contactList;
    }
}
