package trial.databaseexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vyas on 4/14/2016.
 */
public class ContactDatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="contact_manager";
    public static final String TABLE_NAME="contacts";

    public static final String ID="id";
    public static final String NAME="name";
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
}
