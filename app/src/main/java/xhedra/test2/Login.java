package xhedra.test2;

import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class Login extends AppCompatActivity implements TextToSpeech.OnInitListener {
    Button lgnIn;
    private TextToSpeech engine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        engine = new TextToSpeech(this,this);

        lgnIn = findViewById(R.id.btnLogin);
        lgnIn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                String login = lgnIn.getText().toString();
                speak(login);
                getApplicationContext().startActivity(new Intent(getApplicationContext(),Second.class));
            }
        });
    }

    @Override
    public void onInit(int i) {

        if(i == TextToSpeech.SUCCESS){
            engine.setLanguage(Locale.getDefault());
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void speak(String s){
        engine.speak(s,TextToSpeech.QUEUE_FLUSH,null,null);
    }
}
