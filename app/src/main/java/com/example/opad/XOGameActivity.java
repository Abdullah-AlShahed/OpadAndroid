package com.example.opad;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.opad.databinding.ActivityXoGameBinding;


public class XOGameActivity extends AppCompatActivity {
    ActivityXoGameBinding bind;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityXoGameBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        String player1name= getIntent().getStringExtra("n1");
        String player2name= getIntent().getStringExtra("n2");
        bind.tvPlayer1.setText(player1name);
        bind.tvPlayer2.setText(player2name);
    }

    @SuppressLint("ResourceAsColor")
    public void onXOButtonClicked(View view) {
        Button clickedButton = ((Button) view);
        if (clickedButton.getText().toString().isEmpty()) {
            if (counter % 2 == 0 ) {
                clickedButton.setText("X");
                clickedButton.setTag(1);
            } else {
                clickedButton.setText("O");
                clickedButton.setTag(2);
            }
            counter++;
            checkWinner();
        }
        if (clickedButton.getTag().equals(2)){
            clickedButton.setTextColor(R.color.o_color);
        }else {
            clickedButton.setTextColor(R.color.app_taxt_color);
        }
    }

    public void checkWinner() {
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
                resetBoard();
            }
        }
    }

    @SuppressLint("SetTextI18n")
    public void setWinnerScore(Button btn) {
        if (btn.getText().equals("X")) {
            String s = bind.tvScoreplayer1.getTag().toString();
            int newScore = Integer.parseInt(s);
            newScore += 5;
            bind.tvScoreplayer1.setText("Score (" + newScore + ")");
            bind.tvScoreplayer1.setTag(newScore);
            Toast.makeText(this, bind.tvPlayer1.getText()+" Wins", Toast.LENGTH_SHORT).show();
        }
        if (btn.getText().equals("O")) {
            String s = bind.tvScoreplayer2.getTag().toString();
            int newScore = Integer.parseInt(s);
            newScore += 5;
            bind.tvScoreplayer2.setText("Score (" + newScore + ")");
            bind.tvScoreplayer2.setTag(newScore);
            Toast.makeText(this, bind.tvPlayer2.getText()+" Wins", Toast.LENGTH_SHORT).show();
        }
    }

    public void resetBoard() {
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

