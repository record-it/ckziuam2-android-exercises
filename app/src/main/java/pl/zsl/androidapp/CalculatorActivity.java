package pl.zsl.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import pl.zsl.androidapp.calculator.Acumulator;
import pl.zsl.androidapp.calculator.Register;

public class CalculatorActivity extends AppCompatActivity {
    SoundPool soundPool;
    int errorSound = -1;
    int powerUpSound = -1;
    int pickSound = -1;

    Button[] digitsBtn = new Button[10];
    Button plusBtn;
    Button mulBtn;
    Button backspaceBtn;
    Button clearBtn;
    Button dotBtn;
    Button calcBtn;
    TextView display;
    char lastOperator = '+';
    Acumulator accu = new Acumulator();
    Register register = new Register();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        prepareSounds();
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
        calcBtn = findViewById(R.id.calcBtnEquals);
        plusBtn = findViewById(R.id.calcBtnPLus);
        mulBtn = findViewById(R.id.calcBtnMul);
        backspaceBtn = findViewById(R.id.calcBtnBackspace);
        dotBtn = findViewById(R.id.calcBtnDot);
        clearBtn = findViewById(R.id.calcBtnC);
        display = findViewById(R.id.calcDisplay);
        plusBtn = findViewById(R.id.calcBtnPLus);
        View.OnClickListener digitListener = e -> {
            Button clicked = (Button) e;
            char digit = clicked.getText().charAt(0);
            register.add(digit);
            display.setText(register.getStrValue());
            soundPool.play(pickSound, 1, 1, 0, 0, 1);
        };
        for (Button btn: digitsBtn) {
            btn.setOnClickListener(digitListener);
        }
        backspaceBtn.setOnClickListener(e -> {
            register.backspace();
            display.setText(register.getStrValue());
            soundPool.play(errorSound, 1, 1, 0, 0, 1);
        });

        plusBtn.setOnClickListener(e -> {
            if (accu.isEmpty()){
                accu.setValue(register.getValue());
                lastOperator = '+';
                register.clear();
            } else {
                double result = calcBinaryOperation(lastOperator, accu.getValue(), register.getValue());
                lastOperator = '+';
                accu.setValue(result);
                register.clear();
            }
            display.setText(accu.getValue() +"");
        });
        mulBtn.setOnClickListener(e -> {
            if (accu.isEmpty()){
                accu.setValue(register.getValue());
                lastOperator = '*';
                register.clear();
            } else {
                double result = calcBinaryOperation(lastOperator, accu.getValue(), register.getValue());
                lastOperator = '*';
                accu.setValue(result);
                register.clear();
            }
            display.setText(accu.getValue() +"");
        });
        calcBtn.setOnClickListener(e ->{
            double result = calcBinaryOperation(lastOperator, accu.getValue(), register.getValue());
            lastOperator = ' ';
            accu.setValue(result);
            display.setText(accu.getValue() +"");
            register.setStrValue(display.getText().toString());
        });

        dotBtn.setOnClickListener(e ->{
            register.add('.');
            display.setText(register.getStrValue());
        });
    }

    double calcBinaryOperation(char operator, double v1, double v2){
        switch (operator){
            case '+':
                return v1 + v2;
            case '*':
                return v1 * v2;
            case '-':
                return v1 - v2;
            case '/':
                return v1 / v2;
            default:
                return 0;
        }
    }

    void prepareSounds(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(3)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        }
        try{
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor;

            descriptor = assetManager.openFd("error.wav");
            errorSound = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("pick.wav");
            pickSound = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("Powerup.wav");
            powerUpSound = soundPool.load(descriptor, 0);
        } catch (IOException e) {
            Log.e("FILE", "Cant open asset file ");
        }
    }
}