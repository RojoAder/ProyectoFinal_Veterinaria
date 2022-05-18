package rojo.ader.mascotas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class adaptadorMascotas: BaseAdapter {

    lateinit var context: Context
    var mascotas: ArrayList<Mascota> = ArrayList()

    constructor(context: Context,mascotas: ArrayList<Mascota>){
        this.context = context
        this.mascotas = mascotas
    }

    override fun getCount(): Int {
        return  mascotas.size
    }

    override fun getItem(position: Int): Any {
        return mascotas[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflador = LayoutInflater.from(context)
        var vista = inflador.inflate(R.layout.mi_mascota,null)

        val nombreMascota:TextView = vista.findViewById(R.id.texto1)

        var mascota:Mascota = mascotas[position]

        nombreMascota.setText(mascota.nombre)

        return vista
    }
}