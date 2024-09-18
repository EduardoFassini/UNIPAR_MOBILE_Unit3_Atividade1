package br.unipar.listadealunoscomadapter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {


    private val listaDeAlunos = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val edAluno = findViewById<TextInputEditText>(R.id.edAluno)
        val edArea = findViewById<TextInputEditText>(R.id.edArea)
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val listViewAlunos = findViewById<ListView>(R.id.listViewAlunos)
        val tvAlunos = findViewById<TextView>(R.id.tvAlunos)
        val btnZerar = findViewById<Button>(R.id.btnZerar)


        adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, listaDeAlunos)
        // Vinculando o meu Adapter com a minha View
        listViewAlunos.adapter = adapter
    }
}