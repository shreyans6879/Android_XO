package com.saapps.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
   // Player representation
    //0-0
    //1-X
    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    boolean gameActive = true;
    /* State meaning
        0-x
        1-O
        2- null
     */
    int[][] winPos =  {{0,1,2},{3,4,5},{6,7,8},  {0,3,6},{1,4,7},{2,5,8},  {0,4,8},{2,4,6}};
    public void playerTap(View view)
    {
        ImageView img = (ImageView)view;
        int tapImg = Integer.parseInt(img.getTag().toString());
        /*if(!gameActive)
        {
            reset(view);
            gameActive=true;
        }*/
        if (gameState[tapImg]==2&& gameActive)
        {
            gameState[tapImg]= activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0)
            {
                img.setImageResource(R.drawable.x);
                activePlayer=1;
                TextView status = findViewById(R.id.status);
                status.setText("O' Turn Tap To Play");

            }
            else
            {
                img.setImageResource(R.drawable.o);
                activePlayer=0;
                TextView status = findViewById(R.id.status);
                status.setText("X' Turn Tap To Play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] winPoss: winPos)
        {
            if(gameState[winPoss[0]]== gameState[winPoss[1]]&&gameState[winPoss[1]]== gameState[winPoss[2]]&&gameState[winPoss[0]]!=2)
            {
                String winner ;
                gameActive=false;
                if(gameState[winPoss[0]]==0)
                {
                    winner = "X has won the game";
                }
                else
                {
                    winner = "O has won the game";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winner);

            }
        }
    }
    public void reset(View view)
    {
        gameActive=true;
        activePlayer=0;
                for(int i=0; i< gameState.length;i++)
                {
                    gameState[i]=2;
                }
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText("X' Turn Tap To Play");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
