package com.example.threadexamble;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private TextView tvMostrar;
    private Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //conectar los componentes
        tvMostrar = findViewById(R.id.tvMostrar);
        btnEnviar = findViewById(R.id.btnEnviar);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(6000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            runOnUiThread(new Runnable(){
                                @Override
                                public void run() {
                                    tvMostrar.setText(R.string.hilo_ejecutado);}
                            });
                        }
                    });
                thread.start();

            }
        });

    }
}