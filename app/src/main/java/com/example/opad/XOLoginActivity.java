package com.example.opad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class XOLoginActivity extends AppCompatActivity {

    EditText player1EditText;
    EditText player2EditText;
    Button startGameButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xo_login);
        player1EditText=findViewById(R.id.player1_et);
        player2EditText=findViewById(R.id.player2_et);
        startGameButton=findViewById(R.id.start_xo_game_bt);
        startGameButton.setOnClickListener(view -> startGame());
    }

    private void startGame() {
        String player1Name=player1EditText.getText().toString();
        String player2Name=player2EditText.getText().toString();
        Intent intent=new Intent(XOLoginActivity.this,XOGameActivity.class);
        intent.putExtra("n1",player1Name);
        intent.putExtra("n2",player2Name);
        startActivity(intent);
    }
}