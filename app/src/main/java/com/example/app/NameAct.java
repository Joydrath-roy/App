package com.example.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NameAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        final EditText name = (EditText) findViewById(R.id.name);
        Button nextButton = (Button) findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!name.getText().toString().equals("")) {
                    Intent intent = new Intent(NameAct.this, Training.class);
                    intent.putExtra("name", name.getText().toString().trim());
                    startActivity(intent);
                }
                else {
                    Toast.makeText(NameAct.this, "Please enter the student name", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
