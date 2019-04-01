package com.example.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import org.opencv.android.OpenCVLoader;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
   // static {
    //    System.loadLibrary("native-lib");
   // }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
       // TextView tv = findViewById(R.id.sample_text);
       // tv.setText(stringFromJNI());

       /* if(OpenCVLoader.initDebug())
            Toast.makeText(getApplicationContext(),"opencv successfully loaded",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),"could not loadded",Toast.LENGTH_SHORT).show();
            */


        Toolbar toolbar = findViewById(R.id.app_bar);
        //setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Smart Attendance");
        }

        Button recognizeButton = (Button) findViewById(R.id.recognizerbutt);
        Button trainingButton = (Button) findViewById(R.id.student_entry);

        recognizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Recognize.class));
            }
        });

        trainingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"press ok",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, NameAct.class));
            }
        });



    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    //public native String stringFromJNI();
}
