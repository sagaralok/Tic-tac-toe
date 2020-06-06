package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button again;
    ImageView logo;
    Button backBtn;
    boolean active= true;
    TextView winner;
    int [] gamestate ={2,2,2,2,2,2,2,2,2};
    int [][] winPos = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int player=0;
    Button playgame;
    androidx.gridlayout.widget.GridLayout grid;
    public void playGame(View view){
        logo.setVisibility(View.INVISIBLE);
        grid.setVisibility(View.VISIBLE);
        playgame.setVisibility(View.INVISIBLE);
    }
    public void dropIn(View view){
        ImageView img = (ImageView) view;
        int tap =Integer.parseInt(img.getTag().toString());
        if(gamestate[tap]==2 && active) {
            img.setTranslationY(-1500);
            gamestate[tap] = player;
            if (player == 0) {
                img.setImageResource(R.drawable.xyellow);
                player = 1;
            } else {
                img.setImageResource(R.drawable.ored);
                player = 0;
            }
            img.animate().translationYBy(1500).rotation(1800).setDuration(1);
            for(int[] abc:winPos){
                if(gamestate[abc[0]]==gamestate[abc[1]] && gamestate[abc[1]]==gamestate[abc[2]] && gamestate[abc[0]]!=2){
                    active=false;
                    String str= "has won";
                    if(player==0){
                        str= "Circle "+str;
                    }else{
                        str ="Cross "+str;
                    }
                    winner.setText(str);
                    winner.setVisibility(View.VISIBLE);
                    backBtn.setVisibility(View.VISIBLE);
                    again.setVisibility(View.VISIBLE);
                }
            }
        }
    }
    public void again(View view){
        backBtn.setVisibility(View.INVISIBLE);
        winner.setVisibility(View.INVISIBLE);
        again.setVisibility(View.INVISIBLE);
        fun();
    }
    public void backFun(View view){
        grid.setVisibility(View.INVISIBLE);
        winner.setVisibility(View.INVISIBLE);
        backBtn.setVisibility(View.INVISIBLE);
        playgame.setVisibility(View.VISIBLE);
        again.setVisibility(View.INVISIBLE);
        logo.setVisibility(View.VISIBLE);
        fun();
    }
    public void fun(){
        for(int i=0;i<grid.getChildCount();i++) {
            ImageView img = (ImageView) grid.getChildAt(i);
            img.setImageDrawable(null);
        }
        for (int j = 0; j < gamestate.length; j++) {
                gamestate[j] = 2;
            }
        player = 0;
        active = true;
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        again =(Button) findViewById(R.id.againBtn);
        again.setVisibility(View.INVISIBLE);
        logo =(findViewById(R.id.logoImg));
        grid = findViewById(R.id.lay);
        grid.setVisibility(View.INVISIBLE);
        playgame =(Button) findViewById(R.id.playgameBtn);
        winner =(TextView) findViewById(R.id.winnerTxt);
        winner.setVisibility(View.INVISIBLE);
        backBtn =(Button) findViewById(R.id.backBtn);
        backBtn.setVisibility(View.INVISIBLE);
    }
}