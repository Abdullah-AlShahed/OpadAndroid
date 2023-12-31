package com.example.opad.xo_game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.example.opad.R;
import com.example.opad.databinding.ActivityXoGameBinding;


public class XOGameActivity extends AppCompatActivity {
    ActivityXoGameBinding bind;
    int gameTurn ;
    int counter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityXoGameBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        String player1name = getIntent().getStringExtra("n1");
        String player2name = getIntent().getStringExtra("n2");
        bind.tvPlayer1.setText(player1name);
        bind.tvPlayer2.setText(player2name);
        counter=0;
        gameTurn=0;
    }

    public void onXOButtonClicked(View view) {
        Button clickedButton = ((Button) view);
        //we make sure the button is empty
        if (clickedButton.getText().toString().isEmpty()) {
            //gameturn to Decide who starts the game
            if (gameTurn == 0) {
                //counter to switch between X & O turns
                if (counter % 2 == 0) {
                    clickedButton.setText("X");
                    clickedButton.setTag(1);
                } else {
                    clickedButton.setText("O");
                    clickedButton.setTag(2);
                }
              //  Log.d("XOGameActivity", "X started the game & Counter="+counter+" Game Turn="+gameTurn);
            } else {
                if (counter % 2 == 0) {
                    clickedButton.setText("O");
                    clickedButton.setTag(2);
                } else {
                    clickedButton.setText("X");
                    clickedButton.setTag(1);
                }
              //  Log.d("XOGameActivity", "O started the game & Counter="+counter+" Game Turn="+gameTurn);
            }
            counter++;
            checkWinner();
            onPlayChangeColors(clickedButton);
        }


    }

    private void checkWinner() {
        //we check clicked buttons text if 3 texts are the same to say who wins
        //and make sure that they are not empty when any tag =0 by (!bind.xo1.getTag().equals(0))
        if (bind.xo1.getText().equals(bind.xo2.getText()) && bind.xo1.getText().equals(bind.xo3.getText()) && !bind.xo1.getTag().equals(0)) {
            setWinnerScore(bind.xo1);
            resetBoard();
        } else if (bind.xo4.getText().equals(bind.xo5.getText()) && bind.xo4.getText().equals(bind.xo6.getText()) && !bind.xo4.getTag().equals(0)) {
            setWinnerScore(bind.xo4);
            resetBoard();
        } else if (bind.xo7.getText().equals(bind.xo8.getText()) && bind.xo7.getText().equals(bind.xo9.getText()) && !bind.xo7.getTag().equals(0)) {
            setWinnerScore(bind.xo7);
            resetBoard();
        } else if (bind.xo1.getText().equals(bind.xo4.getText()) && bind.xo1.getText().equals(bind.xo7.getText()) && !bind.xo1.getTag().equals(0)) {
            setWinnerScore(bind.xo1);
            resetBoard();
        } else if (bind.xo2.getText().equals(bind.xo5.getText()) && bind.xo2.getText().equals(bind.xo8.getText()) && !bind.xo2.getTag().equals(0)) {
            setWinnerScore(bind.xo2);
            resetBoard();
        } else if (bind.xo3.getText().equals(bind.xo6.getText()) && bind.xo3.getText().equals(bind.xo9.getText()) && !bind.xo3.getTag().equals(0)) {
            setWinnerScore(bind.xo3);
            resetBoard();
        } else if (bind.xo1.getText().equals(bind.xo5.getText()) && bind.xo1.getText().equals(bind.xo9.getText()) && !bind.xo1.getTag().equals(0)) {
            setWinnerScore(bind.xo1);
            resetBoard();
        } else if (bind.xo3.getText().equals(bind.xo5.getText()) && bind.xo3.getText().equals(bind.xo7.getText()) && !bind.xo3.getTag().equals(0)) {
            setWinnerScore(bind.xo3);
            resetBoard();
        } else {
            if (counter == 9) {
                Toast.makeText(this, "DRAW", Toast.LENGTH_SHORT).show();
                changeGameTurn();
                resetBoard();
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void setWinnerScore(Button btn) {
        if (btn.getText().equals("X")) {
            //we take the old score we stored at the player score tag
            String s = bind.tvScoreplayer1.getTag().toString();
            int newScore = Integer.parseInt(s);
            //and add 5
            newScore += 5;
            //print the new score
            bind.tvScoreplayer1.setText("Score (" + newScore + ")");
            //store the new score in the tag
            bind.tvScoreplayer1.setTag(newScore);
            //make x starts the next game
            gameTurn=0;
            Toast.makeText(this, bind.tvPlayer1.getText() + " Wins", Toast.LENGTH_SHORT).show();
        }
        if (btn.getText().equals("O")) {
            String s = bind.tvScoreplayer2.getTag().toString();
            int newScore = Integer.parseInt(s);
            newScore += 5;
            bind.tvScoreplayer2.setText("Score (" + newScore + ")");
            bind.tvScoreplayer2.setTag(newScore);
            gameTurn=1;
            Toast.makeText(this, bind.tvPlayer2.getText() + " Wins", Toast.LENGTH_SHORT).show();
        }
    }

    private void changeGameTurn() {
        //a variable changes when the game ends to see who will play the next game first
        if (gameTurn == 0) {
            gameTurn = 1;
        } else {
            gameTurn = 0;
        }
    }
    @SuppressLint("ResourceAsColor")
    private void onPlayChangeColors(Button clickedButton){
        //if tag =2 it means O is playing so we change the text color of the button
        if (clickedButton.getTag().equals(2)) {
            clickedButton.setTextColor(ContextCompat.getColor(this, R.color.orange_color));
        } else {
            clickedButton.setTextColor(ContextCompat.getColor(this, R.color.app_taxt_color));
        }
    }

    private void resetBoard() {
        bind.xo1.setText("");
        bind.xo1.setTag(0);
        bind.xo2.setText("");
        bind.xo2.setTag(0);
        bind.xo3.setText("");
        bind.xo3.setTag(0);
        bind.xo4.setText("");
        bind.xo4.setTag(0);
        bind.xo5.setText("");
        bind.xo5.setTag(0);
        bind.xo6.setText("");
        bind.xo6.setTag(0);
        bind.xo7.setText("");
        bind.xo7.setTag(0);
        bind.xo8.setText("");
        bind.xo8.setTag(0);
        bind.xo9.setText("");
        bind.xo9.setTag(0);
        counter = 0;
    }


}

