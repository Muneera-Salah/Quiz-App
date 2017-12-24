package com.example.anrdoid.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int Score ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hide the reset button at the first run app
        InvisibleResetButton();
    }

    public void submitAnswer(View view) {
        //hide the Submit Answer Button after press it to show the result
        InvisibleSubmitAnswerButton();

        //show the Reset Button to reset a Score to 0
        VisibleResetButton();

        EditText nameEditText = (EditText) findViewById(R.id.name);
        String name = nameEditText.getText().toString();

        /*
        * Question 1
         */
        RadioButton Answer_Q1_10_RadioButton = (RadioButton) findViewById(R.id.answer_Q1_10);
        boolean isAnswer_Q1_10 = Answer_Q1_10_RadioButton.isChecked();

        RadioButton Answer_Q1_20_RadioButton = (RadioButton) findViewById(R.id.answer_Q1_20);
        boolean isAnswer_Q1_20 = Answer_Q1_20_RadioButton.isChecked();

        RadioButton Answer_Q1_25_RadioButton = (RadioButton) findViewById(R.id.answer_Q1_25);
        boolean isAnswer_Q1_25 = Answer_Q1_25_RadioButton.isChecked();

        if (isAnswer_Q1_25) {
            Score += 1;
        } else {
            Score += 0;
        }

        /*
        * Question 2
         */
        EditText Answer_Q2_EditText = (EditText) findViewById(R.id.answer_Q2);
        if ("".equals(Answer_Q2_EditText.getText().toString().trim())) {
            Toast.makeText(this, "Answer Question 2 is empty", Toast.LENGTH_SHORT).show();
        } else {
            int Answer_Q2 = Integer.parseInt(Answer_Q2_EditText.getText().toString());
            if (Answer_Q2 == 60) {
                Score += 1;
            } else {
                Score += 0;
            }
        }

        /*
        * Question 3
         */
        CheckBox Answer_Q3_1_CheckBox = (CheckBox) findViewById(R.id.answer_Q3_1);
        boolean isAnswerQ3_1 = Answer_Q3_1_CheckBox.isChecked();

        CheckBox Answer_Q3_2_CheckBox = (CheckBox) findViewById(R.id.answer_Q3_2);
        boolean isAnswerQ3_2 = Answer_Q3_2_CheckBox.isChecked();

        CheckBox Answer_Q3_3_CheckBox = (CheckBox) findViewById(R.id.answer_Q3_3);
        boolean isAnswerQ3_3 = Answer_Q3_3_CheckBox.isChecked();

        if (isAnswerQ3_1 && !isAnswerQ3_2 && !isAnswerQ3_3) {
            Score += 1;
        } else {
            Score += 0;
        }

        /*
        * Question 4
         */
        EditText Answer_Q4_EditText = (EditText) findViewById(R.id.answer_Q4);
        if ("".equals(Answer_Q4_EditText.getText().toString().trim())) {
            Toast.makeText(this, "Answer Question 4 is empty", Toast.LENGTH_SHORT).show();
        } else {
            int Answer_Q4 = Integer.parseInt(Answer_Q4_EditText.getText().toString());

            if (Answer_Q4 == 36) {
                Score += 1;
            } else {
                Score += 0;
            }
        }
        //call all functions to show the Score
        displayScore(Score);
        displayScoreMessage(name, Score);

    }

    private void displayScore(int TotalScore) {
        TextView quantityTextView = (TextView) findViewById(R.id.score);
        quantityTextView.setText("" + TotalScore);
    }


    private void displayScoreMessage(String name, int TotalScore) {
        if (TotalScore == 4) {
            Toast.makeText(this, "Congratulations ! :) " + name + " ,  Your Score: " + TotalScore + " /4", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You're Lost :( " + name + " , Your Score: " + TotalScore + " /4", Toast.LENGTH_SHORT).show();
        }
    }

    /*
    Reset Score
    */
    public void ResetScore(View v) {
        Score = 0;
        VisibleSubmitAnswerButton();
        InvisibleResetButton();
        EmptyFiled();
        displayScore(Score);
    }

    private void VisibleSubmitAnswerButton() {
        Button submitAnswerButton = (Button) findViewById(R.id.submit_answer_button);
        submitAnswerButton.setVisibility(View.VISIBLE); // show it
        submitAnswerButton.setClickable(true); /// Enable the ability to click it
    }

    private void InvisibleSubmitAnswerButton() {
        Button SubmitAnswerButton = (Button) findViewById(R.id.submit_answer_button);
        SubmitAnswerButton.setVisibility(View.GONE); // hide it
        SubmitAnswerButton.setClickable(false); // disable the ability to click it
    }

    private void VisibleResetButton() {
        Button resetButton = (Button) findViewById(R.id.reset_button);
        resetButton.setVisibility(View.VISIBLE); // show it
        resetButton.setClickable(true); // Enable the ability to click it
    }

    private void InvisibleResetButton() {
        Button resetButton = (Button) findViewById(R.id.reset_button);
        resetButton.setVisibility(View.GONE); // hide it
        resetButton.setClickable(false); // disable the ability to click it
    }

    private void EmptyFiled() {
        EditText Name_EditText = (EditText) findViewById(R.id.name);
        Name_EditText.setText("");

        RadioButton Answer_Q1_10_RadioButton = (RadioButton) findViewById(R.id.answer_Q1_10);
        Answer_Q1_10_RadioButton.setChecked(false);
        RadioButton Answer_Q1_20_RadioButton = (RadioButton) findViewById(R.id.answer_Q1_20);
        Answer_Q1_20_RadioButton.setChecked(false);
        RadioButton Answer_Q1_25_RadioButton = (RadioButton) findViewById(R.id.answer_Q1_25);
        Answer_Q1_25_RadioButton.setChecked(false);

        EditText Answer_Q2_EditText = (EditText) findViewById(R.id.answer_Q2);
        Answer_Q2_EditText.setText("");


        CheckBox Answer_Q3_1_CheckBox = (CheckBox) findViewById(R.id.answer_Q3_1);
        Answer_Q3_1_CheckBox.setChecked(false);
        CheckBox Answer_Q3_2_CheckBox = (CheckBox) findViewById(R.id.answer_Q3_2);
        Answer_Q3_2_CheckBox.setChecked(false);
        CheckBox Answer_Q3_3_CheckBox = (CheckBox) findViewById(R.id.answer_Q3_3);
        Answer_Q3_3_CheckBox.setChecked(false);

        EditText Answer_Q4_EditText = (EditText) findViewById(R.id.answer_Q4);
        Answer_Q4_EditText.setText("");
    }

}
