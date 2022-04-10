package pl.zsl.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import pl.zsl.androidapp.form.PersonCursorAdapter;
import pl.zsl.androidapp.form.PersonDatabaseHelper;

public class PeopleActivity extends AppCompatActivity {
    ListView peopleListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        peopleListView = findViewById(R.id.peopleList);

        PersonDatabaseHelper helper = new PersonDatabaseHelper(getBaseContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        PersonCursorAdapter adapter = new PersonCursorAdapter(getBaseContext(), helper.findAll(db), true);
        peopleListView.setAdapter(adapter);
    }
}