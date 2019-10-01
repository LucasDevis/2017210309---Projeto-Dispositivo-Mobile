package com.example.jogodavelha2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun boClique (view: View) {
        val boSelecionado = view as Button
        var bID = 0

        when (boSelecionado.id) {
            R.id.bo1 -> bID = 1
            R.id.bo2 -> bID = 2
            R.id.bo3 -> bID = 3
            R.id.bo4 -> bID = 4
            R.id.bo5 -> bID = 5
            R.id.bo6 -> bID = 6
            R.id.bo7 -> bID = 7
            R.id.bo8 -> bID = 8
            R.id.bo9 -> bID = 9
        }

        //Toast.makeText(this, "ID: "+cellID, Toast.LENGTH_SHORT).show()
        playGame(bID, boSelecionado)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var inicia = 1

    fun playGame(bID: Int, boSelecionado: Button) {
        if(inicia == 1) {
            boSelecionado.text = "X"
            boSelecionado.setBackgroundColor(Color.YELLOW)
            player1.add(bID)
            inicia = 2
        } else {
            boSelecionado.text = "O"
            boSelecionado.setBackgroundColor(Color.GREEN)
            player2.add(bID)
            inicia = 1
        }

        boSelecionado.isEnabled = false
        vencedor()
    }

    fun vencedor () {
        var win = -1

        /////////////////////////// LINHAS //////////////////////////////////

        // Vencendo pela linha 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            win = 1
        }

        if(player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            win = 2
        }

        // Vencendo pela linha 2

        if(player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            win = 1
        }

        if(player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            win = 2
        }

        // Vencendo pela linha 3

        if(player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            win = 1
        }

        if(player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            win = 2
        }

        ////////////////////////////////// COLUNAS /////////////////////////////

        // Vencendo pela coluna 1

        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            win = 1
        }

        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            win = 2
        }

        // Vencendo pela coluna 2

        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            win = 1
        }

        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            win = 2
        }

        // Vencendo pela coluna 3

        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            win = 1
        }

        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            win = 2
        }

        /////////////////////////////// DIAGONAl ////////////////////////////

        // Vencendo pela diagonal principal

        if (player1.contains(1) && player1.contains(5) && player1.contains(9)){
            win = 1
        }

        if (player2.contains(1) && player2.contains(5) && player2.contains(9)){
            win = 2
        }

        // Vencendo pela diagonal secundaria

        if (player1.contains(3) && player1.contains(5) && player1.contains(7)){
            win = 1
        }

        if (player2.contains(3) && player2.contains(5) && player2.contains(7)){
            win = 2
        }

        // Vencedor

        if (win != -1) {
            if(win == 1){
                Toast.makeText(this, "Player 1 venceu o jogo!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Player 2 venceu o jogo!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
