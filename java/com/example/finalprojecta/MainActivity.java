package com.example.finalprojecta;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView;
    Button ansA, ansB, ansC, ansD;
    Button submit;
    ImageView Image;

    int score=0;
    int totalQuestion = Answers.correctAnswers.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestionsTextView = findViewById(R.id.counter);
        Image = findViewById(R.id.myimage);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submit = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submit.setOnClickListener(this);

        totalQuestionsTextView.setText("Current question : "+(currentQuestionIndex+1)+"/"+totalQuestion);

        nextQuestion();

    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(Answers.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            nextQuestion();


        }else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.CYAN);

        }

    }

    void nextQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }
        switch (currentQuestionIndex) {
            case 0:
                Image.setImageResource(R.drawable.bulgaria);
                break;
            case 1:
                Image.setImageResource(R.drawable.hungary);
                break;
            case 2:
                Image.setImageResource(R.drawable.madagascar);
                break;
            case 3:
                Image.setImageResource(R.drawable.palau);
                break;
            case 4:
                Image.setImageResource(R.drawable.tonga);
                break;
            case 5:
                Image.setImageResource(R.drawable.malta);
                break;
            case 6:
                Image.setImageResource(R.drawable.dominicanrepublic);
                break;
            case 7:
                Image.setImageResource(R.drawable.burkinafaso);
                break;
            case 8:
                Image.setImageResource(R.drawable.myanmar);
                break;
            case 9:
                Image.setImageResource(R.drawable.niger);
                break;
            case 10:
                Image.setImageResource(R.drawable.papuanewguinea);
                break;
            case 11:
                Image.setImageResource(R.drawable.sanmarino);
                break;
            case 12:
                Image.setImageResource(R.drawable.mauritania);
                break;
            case 13:
                Image.setImageResource(R.drawable.comoros);
                break;
            case 14:
                Image.setImageResource(R.drawable.libya);
                break;
            case 15:
                Image.setImageResource(R.drawable.turkmenistan);
                break;
            case 16:
                Image.setImageResource(R.drawable.maldives);
                break;
            case 17:
                Image.setImageResource(R.drawable.oman);
                break;
            case 18:
                Image.setImageResource(R.drawable.southsudan);
                break;
            case 19:
                Image.setImageResource(R.drawable.eswatini);
                break;
        }
        totalQuestionsTextView.setText("Current question : "+(currentQuestionIndex+1)+"/"+totalQuestion);
        ansA.setText(Answers.choices[currentQuestionIndex][0]);
        ansB.setText(Answers.choices[currentQuestionIndex][1]);
        ansC.setText(Answers.choices[currentQuestionIndex][2]);
        ansD.setText(Answers.choices[currentQuestionIndex][3]);

    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score: "+ score+" out of "+ totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();


    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        nextQuestion();
    }

}