package br.unipar.listadealunoscomadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class AdapterLista  (
    private val context: Context,
    private val listaAlunos: MutableList<AlunosAdapter>)
    : ArrayAdapter<AlunosAdapter>(context,0, listaAlunos) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val aluno = listaAlunos.get(position)
        val view = LayoutInflater.from(context).inflate(R.layout.lista_alunos, parent, false)

        val nome = view.findViewById<TextView>(R.id.textNome)
        val data = view.findViewById<TextView>(R.id.textData)
        val area = view.findViewById<TextView>(R.id.textArea)

        nome.setText(aluno.nome)
        data.setText(aluno.data)
        area.setText(aluno.area)

        return view
    }
}

