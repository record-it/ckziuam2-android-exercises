package pl.zsl.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.zsl.androidapp.calculator.Acumulator;
import pl.zsl.androidapp.calculator.Register;

public class CalculatorActivity extends AppCompatActivity {
    Button[] digitsBtn = new Button[10];
    Button plusBtn;
    Button backspaceBtn;
    Button clearBtn;
    Button dotBtn;
    TextView display;
    Acumulator accu = new Acumulator();
    Register register = new Register();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        digitsBtn[0] = findViewById(R.id.calcBtn0);
        digitsBtn[1] = findViewById(R.id.calcBtn1);
        digitsBtn[2] = findViewById(R.id.calcBtn2);
        digitsBtn[3] = findViewById(R.id.calcBtn3);
        digitsBtn[4] = findViewById(R.id.calcBtn4);
        digitsBtn[5] = findViewById(R.id.calcBtn5);
        digitsBtn[6] = findViewById(R.id.calcBtn6);
        digitsBtn[7] = findViewById(R.id.calcBtn7);
        digitsBtn[8] = findViewById(R.id.calcBtn8);
        digitsBtn[9] = findViewById(R.id.calcBtn9);
        plusBtn = findViewById(R.id.calcBtnPLus);
        backspaceBtn = findViewById(R.id.calcBtnBackspace);
        dotBtn = findViewById(R.id.calcBtnDot);
        clearBtn = findViewById(R.id.calcBtnC);
        display = findViewById(R.id.calcDisplay);
        View.OnClickListener digitListener = e -> {
            Button clicked = (Button) e;
            char digit = clicked.getText().charAt(0);
            register.add(digit);
            display.setText(register.getStrValue());
        };
        for (Button btn: digitsBtn) {
            btn.setOnClickListener(digitListener);
        }

    }


}