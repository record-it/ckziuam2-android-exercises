package pl.zsl.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {
    Button runMainActivityBtn;
    Button runEmailActivityBtn;
    Button runLinearLayoutActivityBtn;
    Button runGridLayoutActivityBtn;
    Button runCalculatorActivity;
    Button runFormActivityBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        runMainActivityBtn = findViewById(R.id.start_main_btn);
        runEmailActivityBtn = findViewById(R.id.start_email_btn);
        runLinearLayoutActivityBtn = findViewById(R.id.start_linear_layout);
        runGridLayoutActivityBtn = findViewById(R.id.start_grid_layout);
        runCalculatorActivity = findViewById(R.id.start_calculator_activity);
        runFormActivityBtn = findViewById(R.id.start_form_activity);
        runFormActivityBtn.setOnClickListener(e ->{
            Intent intent = new Intent(getBaseContext(), FormActivity.class);
            startActivity(intent);
        });
        runMainActivityBtn.setOnClickListener(e -> {
            Intent mainActivityIntent = new Intent(getBaseContext(), MainActivity.class);
            mainActivityIntent.putExtra("message", "Hello from Start Activity");
            startActivity(mainActivityIntent);
        });
        runEmailActivityBtn.setOnClickListener(e -> {
            Intent intent = new Intent(getBaseContext(), EmailActivity.class);
            intent.putExtra("text","Hello from Start Activity");
            startActivity(intent);
        });

        runLinearLayoutActivityBtn.setOnClickListener(e -> {
            Intent intent = new Intent(getBaseContext(), LinearLayoutActivity.class);
            startActivity(intent);
        });
        runGridLayoutActivityBtn.setOnClickListener(e ->{
            Intent intent = new Intent(getBaseContext(), GridLayoutActivity.class);
            startActivity(intent);
        });
        runCalculatorActivity.setOnClickListener(e ->{
            Intent intent = new Intent(getBaseContext(), CalculatorActivity.class);
            startActivity(intent);
        });
    }
}
