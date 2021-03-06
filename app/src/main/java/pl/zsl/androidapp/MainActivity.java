package pl.zsl.androidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String  defualtText = "Czekam na klik!";
    TextView text;
    TextView number;
    RadioGroup colorsRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        colorsRadio = findViewById(R.id.mainColorGroup);
        text = findViewById(R.id.textView);
        number = findViewById(R.id.number);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        text.setText(message);
        colorsRadio.setOnCheckedChangeListener((e, v) -> {
            int chekedColor = colorsRadio.getCheckedRadioButtonId();
            if (chekedColor == -1){

            } else {
                RadioButton radio = findViewById(chekedColor);
                switch (radio.getText().toString().toLowerCase()){
                    case "niebieski":
                        btn.setBackgroundColor(Color.BLUE);
                        break;
                    case "zielony":
                        btn.setBackgroundColor(Color.GREEN);
                        break;
                    case "pomarańczowy":
                        btn.setBackgroundColor(Color.argb(255, 0xFF, 0xFF, 0));
                        break;
                }
            }
        });
        btn.setOnClickListener(e -> {
            text.setText("Kliknąłeś przycisk!");
        });
        Log.i("ACTIVITY","OnCreate");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String message = savedInstanceState.getString("message", defualtText);
        //odczytaj liczbę z savedInstanceState;
        int liczba = savedInstanceState.getInt("liczba", 0);
        number.setText(String.valueOf(liczba));
        text.setText(message);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.i("ACTIVITY", "SAVE");

        int liczba = Integer.parseInt(number.getText().toString());
        //zapisz zmienną liczba do outState
        outState.putInt("liczba", liczba);
        outState.putString("message", text.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ACTIVITY","OnDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ACTIVITY","OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ACTIVITY","OnPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ACTIVITY","Widoczna");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ACTIVITY","Niewidoczna");
    }
}