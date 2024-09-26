package br.unipar.listafilmes

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val listaDeFilmes = ArrayList<Filme>()

    private lateinit var adapter: FilmeAdpter

    private lateinit var listViewFilmes: ListView

    private lateinit var textViewContagemFilmes: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.lista_filmes)

        val edNomeFilme = findViewById<EditText>(R.id.edNomeFilme)

        val edGenero = findViewById<EditText>(R.id.edGenero)

        val edDataFilme = findViewById<EditText>(R.id.edDataFilme)

        val btnInserir = findViewById<Button>(R.id.btnInserir)

        val btnZerar = findViewById<Button>(R.id.btnZerar)

        listViewFilmes = findViewById(R.id.listViewFilmes)

        textViewContagemFilmes = findViewById(R.id.textViewContagemFilmes)

        adapter = FilmeAdpter(this, listaDeFilmes)

        listViewFilmes.adapter = adapter


        btnInserir.setOnClickListener {
            val nomeFilme = edNomeFilme.text.toString()
            val genero = edGenero.text.toString()
            val dataFilme = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

            if (nomeFilme.isNotEmpty() && genero.isNotEmpty() && dataFilme.isNotEmpty()) {

                val filme = Filme(nomeFilme, genero, dataFilme)

                listaDeFilmes.add(filme)
                adapter.notifyDataSetChanged()

                edNomeFilme.text.clear()
                edGenero.text.clear()
                edDataFilme.text.clear()

                atualizarContagemFilmes()

            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }


        btnZerar.setOnClickListener {
            listaDeFilmes.clear()
            edNomeFilme.text.clear()
            edGenero.text.clear()
            edDataFilme.text.clear()
            atualizarContagemFilmes()
            adapter.notifyDataSetChanged()
        }

    }

    private fun atualizarContagemFilmes() {
        textViewContagemFilmes.text = "Total de filmes: ${listaDeFilmes.size}"
    }
}