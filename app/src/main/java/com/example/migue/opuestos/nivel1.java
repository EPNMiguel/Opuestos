package com.example.migue.opuestos;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Locale;

import movil.tesis.miguel.opuestos.Principal;
import movil.tesis.miguel.opuestos.R;


public class nivel1 extends AppCompatActivity {

    public Button bt1;
    public ImageView image1, image2;
    public TextView txtimg1, txtimg2;
    public String[] vectorimg = {"uno", "dos", "tres", "cuatro"};
    public int nombreimg, i, id;
    private TextToSpeech mTTS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(new Locale("spa", "ESP"));
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(nivel1.this, "Idioma no Válido", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

    public void cambio(final View view) {
        bt1 = (Button) findViewById(R.id.btncambio);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i < vectorimg.length) {
                    image1 = (ImageView) findViewById(R.id.imgcambio);
                    id = getResources().getIdentifier(vectorimg[i], "drawable", getPackageName());
                    image1.setImageResource(id);
                    i++;
                } else {

                    LayoutInflater myInflator = getLayoutInflater();
                    View myLayout = myInflator.inflate(R.layout.felicitaciones, (ViewGroup) findViewById(R.id.lay_felicitaciones));
                    Toast myToast = new Toast(getApplicationContext());
                    myToast.setDuration(Toast.LENGTH_LONG);
                    myToast.setView(myLayout);
                    myToast.show();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent regresarhome = new Intent(nivel1.this, Principal.class);
                            startActivity(regresarhome);
                        }
                    }, 3500);


                }

            }
        });

    }

    public void sonar(View view) {
        image1 = (ImageView) findViewById(R.id.imgcambio);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
            super.onDestroy();
        }
    }

        private void speak () {
        int valorid = image1.getId();
        String texto = String.valueOf(valorid);
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
            mTTS.speak(texto, TextToSpeech.QUEUE_FLUSH, null);
        }
    }


