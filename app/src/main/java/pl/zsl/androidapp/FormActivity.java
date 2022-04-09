package pl.zsl.androidapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import pl.zsl.androidapp.form.Person;

public class FormActivity extends AppCompatActivity {
    EditText mNameField;
    EditText mEmailField;
    EditText mBirthField;
    EditText mPhoneField;
    EditText mAddress;
    ImageButton mSaveBtn;
    List<Person> people = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        mNameField = findViewById(R.id.form_name);
        mEmailField = findViewById(R.id.form_email);
        mBirthField = findViewById(R.id.form_birth);
        mPhoneField = findViewById(R.id.form_phone);
        mAddress = findViewById(R.id.form_address);
        mSaveBtn = findViewById(R.id.formSave);
        mSaveBtn.setOnClickListener(e ->{
            Person person = readFromForm();
            if (person != null) {
                people.add(person);
                for (Person p : people) {
                    Log.i("PEOPLE", p.getName() + " " + p.getPhone());
                }
                mNameField.setText("");
                mAddress.setText("");
                Toast.makeText(getBaseContext(), "Osoba została zapisana", Toast.LENGTH_LONG)
                        .show();
            } else {
                Toast.makeText(getBaseContext(), "Niepoprawna data urodzin", Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

    private Person readFromForm(){
        String name = mNameField.getText().toString();
        String email = mEmailField.getText().toString();
        String birthStr = mBirthField.getText().toString();
        String address = mAddress.getText().toString();
        String phone = mPhoneField.getText().toString();
        try {
            LocalDate birth = LocalDate.parse(birthStr);
            return new Person(name, address, email, birth, phone);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}