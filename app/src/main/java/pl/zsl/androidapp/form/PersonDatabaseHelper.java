package pl.zsl.androidapp.form;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PersonDatabaseHelper extends SQLiteOpenHelper {
    private static final String NAME = "people";
    private static final int VERSION = 1;
    private static final String COL_NAME = "name";
    public static final String COL_EMAIL = "email";
    public static final String COL_PHONE = "phone";
    public static final String COL_ADDRESS = "address";
    public static final String COL_BIRTH = "birth";
    public static final String TAB_PEOPLE = "people";

    public PersonDatabaseHelper(@Nullable Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE people(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " TEXT, " +
                COL_EMAIL + " TEXT, " +
                COL_PHONE + " TEXT, " +
                COL_ADDRESS + " TEXT, " +
                COL_BIRTH + " NUMERIC " +
                ")");
    }

    public void addPerson(SQLiteDatabase db, Person person) {
        ContentValues record = new ContentValues();
        record.put(COL_NAME, person.getName());
        record.put(COL_EMAIL, person.getEmail());
        record.put(COL_PHONE, person.getPhone());
        record.put(COL_ADDRESS, person.getAddress());
        record.put(COL_BIRTH, person.getBirth().toEpochDay());
        db.insert(TAB_PEOPLE, null, record);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
