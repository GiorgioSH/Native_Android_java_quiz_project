package com.ita.filmquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    TextView tvReponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        tvReponse = findViewById(R.id.tvReponse);

        Intent intent = getIntent();

        Question question = (Question)intent.getSerializableExtra(MainActivity.KEY_QUESTION);

        tvReponse.setText(String.format("%s : %s", question.getText(), question.getAnswer()));
    }
}