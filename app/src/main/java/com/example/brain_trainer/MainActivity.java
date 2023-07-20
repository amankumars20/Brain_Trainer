package com.example.brain_trainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button gobutton;
    int correctanswerlocation;
    TextView resulttextview;
    TextView scoretextview;
    TextView sumtextview;
    TextView timertextview;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int scores=0;
    int numberofques=0;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playagain;
   ConstraintLayout gamepage;
    ConstraintLayout options;



    public void Chooseanswer(View view)
    {

        if(Integer.toString(correctanswerlocation).equals(view.getTag().toString()))
        {

          //  Toast.makeText(this, "Correct",Toast.LENGTH_SHORT).show();
            resulttextview.setText("Correct!");
            resulttextview.setVisibility(View.VISIBLE);
            scores++;
            newques();
        }
        else
        {
           // Toast.makeText(this, "Wrong ",Toast.LENGTH_SHORT).show();
             resulttextview.setText("Wrong");
            resulttextview.setVisibility(View.VISIBLE);
             newques();

        }
        numberofques++;
        scoretextview.setText(Integer.toString(scores)+"/"+Integer.toString(numberofques));


    }

    public void start(View view)
    {
        gamepage.setVisibility(View.VISIBLE);
        gobutton.setVisibility(View.INVISIBLE);
        resulttextview.setVisibility(View.INVISIBLE);
        play_again(findViewById(R.id.playagain));
    }

    public void play_again(View view)
    {
        scores=0;
        numberofques=0;
        timertextview.setText("30s");
        options.setVisibility(View.VISIBLE);
        scoretextview.setText(Integer.toString(scores)+"/"+Integer.toString(numberofques));
        newques();
        playagain.setVisibility(view.INVISIBLE);
        resulttextview.setVisibility(View.INVISIBLE);
        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long l) {
                timertextview.setText(String.valueOf(l/1000));
            }
            @Override
            public void onFinish() {
                resulttextview.setText("Done!");
                resulttextview.setVisibility(View.VISIBLE);
                options.setVisibility(View.INVISIBLE);
                playagain.setVisibility(view.VISIBLE);
            }
        }.start();

    }


    public void newques()
    {

        Random rand=new Random();
        int a=rand.nextInt(21);
        int b= rand.nextInt(21);

        sumtextview.setText(Integer.toString(a)+"+"+Integer.toString(b));

        correctanswerlocation=rand.nextInt(4);

        answers.clear();

        for(int i=0;i<4;i++)
        {
            if(i==correctanswerlocation)
            {
                answers.add(a+b);
            }
            else
            {
                int wronganswer = rand.nextInt(41);
                while(wronganswer == a+b)
                {
                    wronganswer = rand.nextInt(41);
                }
                answers.add(wronganswer);
            }
        }


        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("GOOD","WRITE");
        gobutton = findViewById(R.id.goButton);
        resulttextview=findViewById(R.id.resulttextView);
        scoretextview=findViewById(R.id.scoretextview);
        sumtextview=findViewById(R.id.sumtextview);
        timertextview=findViewById(R.id.Timertextview);
        playagain=findViewById(R.id.playagain);
        gamepage=findViewById(R.id.game);
        options = findViewById(R.id.options);


         button0=findViewById(R.id.button0);
         button1=findViewById(R.id.button1);
         button2=findViewById(R.id.button2);
         button3=findViewById(R.id.button3);


         gamepage.setVisibility(View.INVISIBLE);
         gobutton.setVisibility(View.VISIBLE);







    }
}