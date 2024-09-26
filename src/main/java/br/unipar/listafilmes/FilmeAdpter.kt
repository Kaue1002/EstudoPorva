package br.unipar.listafilmes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class FilmeAdpter(context: Context, private val alunos: List<Filme>) :
    ArrayAdapter<Filme>(context, 0, alunos) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val aluno = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(
            android.R.layout.simple_list_item_1, parent, false
        )

        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.text = "${aluno?.nome} - ${aluno?.genero} (Data: ${aluno?.ano})"
        return view
    }

}
