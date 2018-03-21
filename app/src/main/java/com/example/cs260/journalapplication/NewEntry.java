package com.example.cs260.journalapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewEntry extends AppCompatActivity {

    Button save;
    Journal journal = new Journal();
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__new_entry);

        text = (EditText)findViewById(R.id.user_text);
        save = (Button)findViewById(R.id.Save_btn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = text.getText().toString();
            }
        });
    }
}
