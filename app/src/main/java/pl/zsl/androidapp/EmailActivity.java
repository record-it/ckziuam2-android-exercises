package pl.zsl.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EmailActivity extends AppCompatActivity {
    Button sendEmailBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        Intent intent = getIntent();
        String message = intent.getStringExtra("text");
        TextView text = findViewById(R.id.email_text);
        sendEmailBtn = findViewById(R.id.email_send);
        text.setText(message);
        sendEmailBtn.setOnClickListener(e -> {
            Intent intentEmail = new Intent(Intent.ACTION_SEND);
            intentEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"trener@sda.pl", "academy@sda.pl"});
            intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Hello");
            intentEmail.putExtra(Intent.EXTRA_TEXT, text.getText());
            Intent chooseEmailApp = Intent.createChooser(intentEmail, "Wybierz aplikację do wysłania email");
            startActivity(chooseEmailApp);
        });
    }
}
