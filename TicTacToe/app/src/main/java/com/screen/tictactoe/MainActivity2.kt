package com.screen.tictactoe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity2 : MainActivity() {
    var m = Array(3) {Array(3) {""} }
    var turn = "X"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
    fun putXorO(view: View) {

        val selBut: Button = view as Button
        if (selBut.text.toString() == "" && turn =="X") {
            selBut.text = "X"
            when (selBut.id) {
                R.id.button3 -> {
                   m[0][0] = turn
               }
                R.id.button4-> {
                    m[0][1] = turn
                }
                R.id.button5 -> {
                    m[0][2] = turn
                }
                R.id.button6 -> {
                    m[1][0] = turn
                }
                R.id.button7 -> {
                m[1][2] = turn
            }
                R.id.button8 -> {
                    m[1][1] = turn
                }
                R.id.button9 -> {
                    m[2][0] = turn
                }
                R.id.button10 -> {
                    m[2][1] = turn
                }
                R.id.button11 -> {
                    m[2][2] = turn
                }
            }
            if(winner(m,turn)){
                Toast.makeText(applicationContext,"Player $turn is the winner!",Toast. LENGTH_LONG).show()
                val intent = Intent(this,MainActivity::class.java)
                intent.putExtra("player", turn)
                startActivity(intent)
            }
            turn = "O"
        } else if (selBut.text.toString() == "" && turn =="O")
         {
             selBut.text = "O"
             when (selBut.id) {
                 R.id.button3 -> {
                    m[0][0] = turn
                }
                 R.id.button4 -> {
                    m[0][1] = turn
                }
                 R.id.button5 -> {
                    m[0][2] = turn
                }
                 R.id.button6 -> {
                    m[1][0] = turn
                }
                 R.id.button7 -> {
                    m[1][2] = turn
                }
                 R.id.button8 -> {
                    m[1][1] = turn
                }
                 R.id.button9 -> {
                    m[2][0] = turn
                }
                 R.id.button10 -> {
                    m[2][1] = turn
                }
                 R.id.button11 -> {
                    m[2][2] = turn
                }
            }
             if(winner(m,turn)){
                 Toast.makeText(applicationContext,"Player $turn is the winner!",Toast. LENGTH_LONG).show()
                 val intent = Intent(this,MainActivity::class.java)
                 intent.putExtra("player", turn)
                 startActivity(intent)
             }
            turn = "X"
        }


        if(draw(m)){
            Toast.makeText(applicationContext,"DRAW!",Toast. LENGTH_LONG).show()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
        }
    private fun winner(arr : Array<Array<String>>, temp : String) : Boolean {
        for (i in 0..2) {
            if (arr[i][0] == temp && arr[i][1] == temp && arr[i][2] == temp) {
                return true
            } else if (arr[0][i] == temp && arr[1][i] == temp && arr[2][i] == temp) {
                return true
            }
        }
        if (arr[0][0] == temp && arr[1][1] == temp && arr[2][2] == temp) {
            return true
        } else if (arr[2][0] == temp && arr[1][1] == temp && arr[0][2] == temp) {
            return true
        }
        return false
    }
private fun draw(arr : Array<Array<String>>) : Boolean {
    for(i in 0..2){
        for(j in 0..2){
            if(arr[i][j] == ""){
                return false
            }
        }
    }
    return true
}

