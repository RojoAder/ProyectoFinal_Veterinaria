package rojo.ader.mascotas

import android.content.ContentValues
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class adaptadorCitas: BaseAdapter {
    lateinit var context: Context
    var citas: ArrayList<Cita> = ArrayList()

    constructor(context: Context, citas: ArrayList<Cita>){
        this.context = context
        this.citas = citas
    }

    override fun getCount(): Int {
       return  citas.size
    }

    override fun getItem(position: Int): Any {
        return citas[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflador = LayoutInflater.from(context)
        var vista = inflador.inflate(R.layout.cita_formato,null)

        val nombreEvento: TextView = vista.findViewById(R.id.nombreEvento)
        val fechaEvento: TextView = vista.findViewById(R.id.fechaEvento)

        var cita:Cita = citas[position]
        var fechaL:List<String> = cita.fecha.split(" ")
        var fechaS:String = fechaL.get(0) + " " + fechaL.get(1) + " " + fechaL.get(2)

        nombreEvento.setText(cita.nombreEvento+":")
        fechaEvento.setText(fechaS)

        return vista
    }


}