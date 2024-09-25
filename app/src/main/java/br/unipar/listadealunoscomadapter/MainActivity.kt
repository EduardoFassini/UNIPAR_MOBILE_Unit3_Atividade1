package br.unipar.listadealunoscomadapter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {


    private val listaDeAlunos = mutableListOf<AlunosAdapter>()
    private lateinit var adapter : AdapterLista
   // private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val edAluno = findViewById<TextInputEditText>(R.id.inputAluno)
        val edArea = findViewById<TextInputEditText>(R.id.inputArea)
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val listViewAlunos = findViewById<ListView>(R.id.listViewAlunos)
        val tvAlunos = findViewById<TextView>(R.id.tvAlunos)
        val btnZerar = findViewById<Button>(R.id.btnZerar)
        var contAlunos = 0

        adapter = AdapterLista(this,listaDeAlunos)
        // Vinculando o meu Adapter com a minha View
        listViewAlunos.adapter = adapter

        btnInserir.setOnClickListener{
            val aluno = edAluno.text.toString()
            val area = edArea.text.toString()
            val dateFormat = SimpleDateFormat("dd/MM/yyyy")
            val data = Calendar.getInstance().time
            val dataFormatada = dateFormat.format(data)

            if (aluno.isNotEmpty() and area.isNotEmpty()){
                listaDeAlunos.add(AlunosAdapter("Aluno: "+aluno,"Área: "+area,"Data: "+dataFormatada))
                adapter.notifyDataSetChanged()

                edAluno.text?.clear()
                edArea.text?.clear()
                contAlunos++
                tvAlunos.text = "Alunos: " + contAlunos
            }
        }

        btnZerar.setOnClickListener{
            listaDeAlunos.clear()
            adapter.notifyDataSetChanged()
            contAlunos = 0
            tvAlunos.text = "Alunos: " + contAlunos
        }

    }
}