package com.screen.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playerx: EditText = findViewById(R.id.playerX)
        val playero: EditText = findViewById(R.id.playerO)
        val Button = findViewById<Button>(R.id.button)
        var scoreX = 0
        var scoreO = 0
        val pl = intent.getStringExtra("player")
                if(pl == "X"){
                    scoreX++
                    findViewById<TextView>(R.id.scorex).text = scoreX.toString()
                } else if( pl == "O" ){
                    scoreO++
                    findViewById<TextView>(R.id.scoreo).text = scoreO.toString()
                }

            Button.setOnClickListener {
                if(valid(playerx, playero)){
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
        }
            }
    private fun valid(pl1 :EditText, pl2:EditText) : Boolean {
        if (pl1.text.toString().isEmpty()) {
            pl1.error = "Input your name"
            return false
        } else if (pl2.text.toString().isEmpty()) {
            pl2.error = "Input your name"
            return false
        } else if (pl2.text.toString().isEmpty() && pl1.text.toString().isEmpty()) {
            pl1.error = "Input your name"
            pl2.error = "Input your name"
            return false
        }
        return true
    }
}