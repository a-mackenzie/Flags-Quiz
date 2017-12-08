package com.example.android.flagsquiz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score;

    RadioButton q1Slovenia;
    CheckBox q2Blue;
    CheckBox q2Green;
    CheckBox q2Red;
    CheckBox q2Yellow;
    CheckBox q2White;
    RadioButton q3IvoryCoast;
    EditText q4AnswerField;
    RadioButton q5AnswerD;
    CheckBox q6Chad;
    CheckBox q6Colombia;
    CheckBox q6Moldova;
    CheckBox q6Romania;
    EditText q7AnswerField;
    RadioButton q8netherlands;
    RadioButton q9AnswerB;
    EditText q10AnswerFieldA;
    EditText q10AnswerFieldB;
    View q1Layout;
    View q2Layout;
    View q3Layout;
    View q4Layout;
    View q5Layout;
    View q6Layout;
    View q7Layout;
    View q8Layout;
    View q9Layout;
    View q10Layout;
    ImageView q2Image;
    ImageView q4Image;
    ImageView q6Image;
    ImageView q7Image;
    ImageView q10Image;
    TextView resultScore;
    TextView resultsMessage;
    View dialogView;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1Slovenia = findViewById(R.id.q1slovenia);
        q2Blue = findViewById(R.id.q2blue);
        q2Green = findViewById(R.id.q2green);
        q2Red = findViewById(R.id.q2red);
        q2Yellow = findViewById(R.id.q2yellow);
        q2White = findViewById(R.id.q2white);
        q3IvoryCoast = findViewById(R.id.q3ivorycoast);
        q4AnswerField = findViewById(R.id.q4answer);
        q5AnswerD = findViewById(R.id.q5answerD);
        q6Chad = findViewById(R.id.q6chad);
        q6Colombia = findViewById(R.id.q6colombia);
        q6Moldova = findViewById(R.id.q6moldova);
        q6Romania = findViewById(R.id.q6romania);
        q7AnswerField = findViewById(R.id.q7answer);
        q8netherlands = findViewById(R.id.q8netherlands);
        q9AnswerB = findViewById(R.id.q9answerB);
        q10AnswerFieldA = findViewById(R.id.q10answerA);
        q10AnswerFieldB = findViewById(R.id.q10answerB);
        q1Layout = findViewById(R.id.q1Layout);
        q2Layout = findViewById(R.id.q2Layout);
        q3Layout = findViewById(R.id.q3Layout);
        q4Layout = findViewById(R.id.q4Layout);
        q5Layout = findViewById(R.id.q5Layout);
        q6Layout = findViewById(R.id.q6Layout);
        q7Layout = findViewById(R.id.q7Layout);
        q8Layout = findViewById(R.id.q8Layout);
        q9Layout = findViewById(R.id.q9Layout);
        q10Layout = findViewById(R.id.q10Layout);
        q2Image = findViewById(R.id.q2Image);
        q4Image = findViewById(R.id.q4Image);
        q6Image = findViewById(R.id.q6Image);
        q7Image = findViewById(R.id.q7Image);
        q10Image = findViewById(R.id.q10Image);

        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        dialogView = inflater.inflate(R.layout.results_dialog, null);
        resultScore = dialogView.findViewById(R.id.resultScore);
        resultsMessage = dialogView.findViewById(R.id.resultsMessage);

        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(dialogView)
                .setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
    }

    /**
     * Saves the state of the question layouts when changing rotation
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        q1Layout.getBackground();
        savedInstanceState.putInt("q1Layout", q1Layout.getBackground());

    }

    /**
     * Checks all answers and displays a dialog with the results of the quiz
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

        if (score == 0) {
            resultsMessage.setText(getResources().getString(R.string.score0));
        } else if (score > 0 && score < 4) {
            resultsMessage.setText(getResources().getString(R.string.score1to3));
        } else if (score > 3 && score < 7) {
            resultsMessage.setText(getResources().getString(R.string.score4to6));
        } else if (score > 6 && score < 11) {
            resultsMessage.setText(getResources().getString(R.string.score7to10));
        } else {
            resultsMessage.setText(getResources().getString(R.string.score11));
        }

        String scoreString = String.valueOf(score);
        String scoreString2 = getString(R.string.resultScore, scoreString);
        resultScore.setText(scoreString2);

        builder.show();
    }

    /**
     * Check the results for Question 1
     */
    public int checkQuestion1(int score) {
        if (q1Slovenia.isChecked()) {
            score += 1;
            q1Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
        } else {
            q1Layout.setBackground(getResources().getDrawable(R.drawable.question_border_incorrect));
        }
        return score;
    }

    /**
     * Check the results for Question 2
     */
    public int checkQuestion2(int score) {
        if (q2Blue.isChecked() && q2Red.isChecked() && q2White.isChecked() && !q2Green.isChecked() && !q2Yellow.isChecked()) {
            score += 1;
            q2Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
            q2Image.setImageDrawable(getResources().getDrawable(R.drawable.norway));
        } else {
            q2Layout.setBackground(getResources().getDrawable(R.drawable.question_border_incorrect));
        }
        return score;
    }

    /**
     * Check the results for Question 3
     */
    public int checkQuestion3(int score) {
        if (q3IvoryCoast.isChecked()) {
            score += 1;
            q3Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
        } else {
            q3Layout.setBackground(getResources().getDrawable(R.drawable.question_border_incorrect));
        }
        return score;
    }

    /**
     * Check the results for Question 4
     */
    public int checkQuestion4(int score) {
        String q4Answer = q4AnswerField.getText().toString().trim();
        if (q4Answer.equals(getResources().getString(R.string.q4correctanswer))) {
            score += 1;
            q4Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
            q4Image.setImageDrawable(getResources().getDrawable(R.drawable.australia));
        } else {
            q4Layout.setBackground(getResources().getDrawable(R.drawable.question_border_incorrect));
        }
        return score;
    }

    /**
     * Check the results for Question 5
     */
    public int checkQuestion5(int score) {
        if (q5AnswerD.isChecked()) {
            score += 1;
            q5Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
        } else {
            q5Layout.setBackground(getResources().getDrawable(R.drawable.question_border_incorrect));
        }
        return score;
    }

    /**
     * Check the results for Question 6
     */
    public int checkQuestion6(int score) {
        if (q6Chad.isChecked() && q6Romania.isChecked() && !q6Colombia.isChecked() && !q6Moldova.isChecked()) {
            score += 1;
            q6Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
            q6Image.setImageDrawable(getResources().getDrawable(R.drawable.romania_chad));
        } else {
            q6Layout.setBackground(getResources().getDrawable(R.drawable.question_border_incorrect));
        }
        return score;
    }

    /**
     * Check the results for Question 7
     */
    public int checkQuestion7(int score) {
        String q7Answer = q7AnswerField.getText().toString().trim();
        if (q7Answer.equalsIgnoreCase(getResources().getString(R.string.q7correctanswer))) {
            score += 1;
            q7Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
            q7Image.setImageDrawable(getResources().getDrawable(R.drawable.nepal));
        } else {
            q7Layout.setBackground(getResources().getDrawable(R.drawable.question_border_incorrect));
        }
        return score;
    }

    /**
     * Check the results for Question 8
     */
    public int checkQuestion8(int score) {
        if (q8netherlands.isChecked()) {
            score += 1;
            q8Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
        } else {
            q8Layout.setBackground(getResources().getDrawable(R.drawable.question_border_incorrect));
        }
        return score;
    }

    /**
     * Check the results for Question 9
     */
    public int checkQuestion9(int score) {
        if (q9AnswerB.isChecked()) {
            score += 1;
            q9Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
        } else {
            q9Layout.setBackground(getResources().getDrawable(R.drawable.question_border_incorrect));
        }
        return score;
    }

    /**
     * Check the results for Question 10
     */
    public int checkQuestion10(int score) {
        String q10AnswerA = q10AnswerFieldA.getText().toString().trim();
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
        if ((q10AnswerA.equalsIgnoreCase(getResources().getString(R.string.q10answer1)) && q10AnswerB.equalsIgnoreCase(getResources().getString(R.string.q10answer2))) || (q10AnswerA.equalsIgnoreCase(getResources().getString(R.string.q10answer2)) && q10AnswerB.equalsIgnoreCase(getResources().getString(R.string.q10answer1)))) {
            q10Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
            q10Image.setImageDrawable(getResources().getDrawable(R.drawable.vatican_swiss));
        } else {
            q10Layout.setBackground(getResources().getDrawable(R.drawable.question_border_incorrect));
        }
        return score;
    }

    /**
     * This methods sets all the answers to the correct ones
     */
    public void showCorrectAnswers (View view) {
        q1Slovenia.setChecked(true);
        q2Blue.setChecked(true);
        q2Red.setChecked(true);
        q2White.setChecked(true);
        q2Green.setChecked(false);
        q2Yellow.setChecked(false);
        q3IvoryCoast.setChecked(true);
        q4AnswerField.setText(getResources().getString(R.string.q4correctanswer));
        q5AnswerD.setChecked(true);
        q6Chad.setChecked(true);
        q6Romania.setChecked(true);
        q6Colombia.setChecked(false);
        q6Moldova.setChecked(false);
        q7AnswerField.setText(getResources().getString(R.string.q7correctanswer));
        q8netherlands.setChecked(true);
        q9AnswerB.setChecked(true);
        q10AnswerFieldA.setText(getResources().getString(R.string.q10answer1));
        q10AnswerFieldB.setText(getResources().getString(R.string.q10answer2));
        q1Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
        q2Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
        q3Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
        q4Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
        q5Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
        q6Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
        q7Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
        q8Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
        q9Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
        q10Layout.setBackground(getResources().getDrawable(R.drawable.question_border_correct));
        q2Image.setImageDrawable(getResources().getDrawable(R.drawable.norway));
        q4Image.setImageDrawable(getResources().getDrawable(R.drawable.australia));
        q6Image.setImageDrawable(getResources().getDrawable(R.drawable.romania_chad));
        q7Image.setImageDrawable(getResources().getDrawable(R.drawable.nepal));
        q10Image.setImageDrawable(getResources().getDrawable(R.drawable.vatican_swiss));
    }

    /**
     * This methods resets the app
     */
    public void resetAll (View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
    }

}
