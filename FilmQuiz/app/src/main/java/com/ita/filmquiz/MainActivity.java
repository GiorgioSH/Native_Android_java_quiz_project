    package com.ita.filmquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

    public class MainActivity extends AppCompatActivity {

    private static final String KEY_INDEX = "index";
    private static final String KEY_SCORE = "score";
    public static final String KEY_QUESTION = "question";
    private final String TAG = "QuizActivity";

    private Button trueButton = null;
    private Button falseButton = null;
    TextView tvQuestion = null;
    TextView tvScore = null;
    List<Question> questions = new ArrayList<>();
    private Integer result = 0;
    Question question;
    private int index = 0;

    Context context = null;

        @Override
        protected void onSaveInstanceState(@NonNull Bundle outState) {
            super.onSaveInstanceState(outState);
            Log.d(TAG, "onSaveInstanceState() called");
            outState.putInt(KEY_INDEX, index);
            outState.putInt(KEY_SCORE, result);
        }

        @Override
        protected void onStart() {
            super.onStart();
            Log.d(TAG, "onStart() called");
        }

        @Override
        protected void onResume() {
            super.onResume();
            Log.d(TAG, "onResume() called");
        }

        @Override
        protected void onPause() {
            super.onPause();
            Log.d(TAG, "onPause() called");
        }

        @Override
        protected void onStop() {
            super.onStop();
            Log.d(TAG, "onStop() called");
        }

        @Override
        protected void onRestart() {
            super.onRestart();
            Log.d(TAG, "onRestart() called");
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            Log.d(TAG, "onDestroy() called");
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.cheat :
                    Intent intent = new Intent(context, CheatActivity.class);

                    intent.putExtra(KEY_QUESTION, question);

                    startActivity(intent);

                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        Log.d(TAG, "onCreate() called");
        trueButton = findViewById(R.id.btnTrue);
        falseButton = findViewById(R.id.btnFalse);
        tvQuestion = findViewById(R.id.tvQuestion);
        tvScore = findViewById(R.id.tvScore);

        tvScore.setBackgroundColor(Color.rgb(110, 220, 230));

        Question question1 = new Question(getString(R.string.question_ai).toString(), true);
        Question question2 = new Question(getString(R.string.question_taxi_driver).toString(), true);
        Question question3 = new Question(getString(R.string.question_2001).toString(), false);
        Question question4 = new Question(getString(R.string.question_reservoir_dogs).toString(), true);
        Question question5 = new Question(getString(R.string.question_citizen_kane).toString(), false);

        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);

        if(savedInstanceState != null){
            index = savedInstanceState.getInt(KEY_INDEX);
            result = savedInstanceState.getInt(KEY_SCORE);
        }

        question = questions.get(index);
        tvScore.setText(result.toString());

        tvQuestion.setText(question.getText());
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int duration = Toast.LENGTH_SHORT;

                if(question.getAnswer()){
                    CharSequence text = "Bien Joué !";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    result ++;
                }else {
                    CharSequence text = "perdu !";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                tvScore.setText(result.toString());
                index += 1;
                if(index <= questions.size()-1){
                    question = questions.get(index);
                    tvQuestion.setText(question.getText());
                }else{
                    index = 0;
                    result = 0;
                    tvScore.setText(result.toString());
                    question = questions.get(index);
                    tvQuestion.setText(question.getText());
                }
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int duration = Toast.LENGTH_SHORT;
                //tvScore.setBackgroundColor(Color.rgb(111, 21, 130));
                if(!question.getAnswer()) {
                    result++;

                    CharSequence text = "Bien Joué !";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else {
                    CharSequence text = "Perdu !";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }
                tvScore.setText(result.toString());
                index += 1;
                if(index <= questions.size()-1){
                    question = questions.get(index);
                    tvQuestion.setText(question.getText());
                }else{
                    index = 0;
                    result = 0;
                    //tvScore.setText(String.format("score : %d",result.toString());
                    tvScore.setText(result.toString());
                    question = questions.get(index);
                    tvQuestion.setText(question.getText());
                }
            }

        });


        //tvScore.setText(tvScore.getText().toString()+1);
    }
}