package com.example.android.flagsquiz;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Checks all answers and displays a toast with the results of the quiz
     */
    public void checkResults(View view) {
        score = 0;
        score = checkQuestion1(score);
        score = checkQuestion2(score);
        score = checkQuestion3(score);
        score = checkQuestion4(score);
        score = checkQuestion5(score);
        score = checkQuestion6(score);
        score = checkQuestion7(score);
        score = checkQuestion8(score);
        score = checkQuestion9(score);
        score = checkQuestion10(score);
        String scoreString = String.valueOf(score);
        String toastString = getString(R.string.toastMessage, scoreString);
        Toast resultsMessage = Toast.makeText(getBaseContext(), toastString, Toast.LENGTH_LONG);
        resultsMessage.show();
    }

    /**
     * Check the results for Question 1
     */
    public int checkQuestion1(int score) {
        RadioButton q1Slovenia = (RadioButton) findViewById(R.id.q1slovenia);
        if (q1Slovenia.isChecked()) {
            score += 1;
        }
        return score;
    }

    /**
     * Check the results for Question 2
     */
    public int checkQuestion2(int score) {
        CheckBox q2Blue = (CheckBox) findViewById(R.id.q2blue);
        CheckBox q2Green = (CheckBox) findViewById(R.id.q2green);
        CheckBox q2Red = (CheckBox) findViewById(R.id.q2red);
        CheckBox q2Yellow = (CheckBox) findViewById(R.id.q2yellow);
        CheckBox q2White = (CheckBox) findViewById(R.id.q2white);
        if (q2Blue.isChecked() && q2Red.isChecked() && q2White.isChecked() && !q2Green.isChecked() && !q2Yellow.isChecked()) {
            score += 1;
        }
        return score;
    }

    /**
     * Check the results for Question 3
     */
    public int checkQuestion3(int score) {
        RadioButton q3IvoryCoast = (RadioButton) findViewById(R.id.q3ivorycoast);
        if (q3IvoryCoast.isChecked()) {
            score += 1;
        }
        return score;
    }

    /**
     * Check the results for Question 4
     */
    public int checkQuestion4(int score) {
        EditText q4AnswerField = (EditText) findViewById(R.id.q4answer);
        String q4Answer = q4AnswerField.getText().toString().trim();
        if (q4Answer.equals(getResources().getString(R.string.q4correctanswer))) {
            score += 1;
        }
        return score;
    }

    /**
     * Check the results for Question 5
     */
    public int checkQuestion5(int score) {
        RadioButton q5AnswerD = (RadioButton) findViewById(R.id.q5answerD);
        if (q5AnswerD.isChecked()) {
            score += 1;
        }
        return score;
    }

    /**
     * Check the results for Question 6
     */
    public int checkQuestion6(int score) {
        CheckBox q6Chad = (CheckBox) findViewById(R.id.q6chad);
        CheckBox q6Colombia = (CheckBox) findViewById(R.id.q6colombia);
        CheckBox q6Moldova = (CheckBox) findViewById(R.id.q6moldova);
        CheckBox q6Romania = (CheckBox) findViewById(R.id.q6romania);
        if (q6Chad.isChecked() && q6Romania.isChecked() && !q6Colombia.isChecked() && !q6Moldova.isChecked()) {
            score += 1;
        }
        return score;
    }

    /**
     * Check the results for Question 7
     */
    public int checkQuestion7(int score) {
        EditText q7AnswerField = (EditText) findViewById(R.id.q7answer);
        String q7Answer = q7AnswerField.getText().toString().trim();
        if (q7Answer.equalsIgnoreCase(getResources().getString(R.string.q7correctanswer))) {
            score += 1;
        }
        return score;
    }

    /**
     * Check the results for Question 8
     */
    public int checkQuestion8(int score) {
        RadioButton q8netherlands = (RadioButton) findViewById(R.id.q8netherlands);
        if (q8netherlands.isChecked()) {
            score += 1;
        }
        return score;
    }

    /**
     * Check the results for Question 9
     */
    public int checkQuestion9(int score) {
        RadioButton q9AnswerB = (RadioButton) findViewById(R.id.q9answerB);
        if (q9AnswerB.isChecked()) {
            score += 1;
        }
        return score;
    }

    /**
     * Check the results for Question 10
     */
    public int checkQuestion10(int score) {
        EditText q10AnswerFieldA = (EditText) findViewById(R.id.q10answerA);
        String q10AnswerA = q10AnswerFieldA.getText().toString().trim();
        EditText q10AnswerFieldB = (EditText) findViewById(R.id.q10answerB);
        String q10AnswerB = q10AnswerFieldB.getText().toString().trim();
        if ((q10AnswerA.equalsIgnoreCase(getResources().getString(R.string.q10answer1)))) {
            score += 1;
        }
        if ((q10AnswerA.equalsIgnoreCase(getResources().getString(R.string.q10answer2)))) {
            score += 1;
        }
        if ((q10AnswerB.equalsIgnoreCase(getResources().getString(R.string.q10answer1))) && (!q10AnswerA.equalsIgnoreCase(getResources().getString(R.string.q10answer1)))) {
            score += 1;
        }
        if ((q10AnswerB.equalsIgnoreCase(getResources().getString(R.string.q10answer2))) && (!q10AnswerA.equalsIgnoreCase(getResources().getString(R.string.q10answer2)))) {
            score += 1;
        }
        return score;
    }

}
