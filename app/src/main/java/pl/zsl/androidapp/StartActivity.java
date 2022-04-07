package pl.zsl.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {
    Button runMainActivityBtn;
    Button runEmailActivityBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        runMainActivityBtn = findViewById(R.id.start_main_btn);
        runEmailActivityBtn = findViewById(R.id.start_email_btn);
        runMainActivityBtn.setOnClickListener(e -> {
            Intent mainActivityIntent = new Intent(getBaseContext(), MainActivity.class);
            mainActivityIntent.putExtra("message", "Hello from Start Activity");
            startActivity(mainActivityIntent);
        });
        runEmailActivityBtn.setOnClickListener(e -> {
            Intent intent = new Intent(getBaseContext(), EmailActivity.class);
            intent.putExtra()
            startActivity(intent);
        });
    }
}
