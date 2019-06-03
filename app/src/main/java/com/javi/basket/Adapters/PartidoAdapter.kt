package com.javi.basket.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.javi.basket.Entities.ClasePartido
import com.javi.basket.R
import kotlinx.android.synthetic.main.fragment_partido.view.*

abstract class PartidoAdapter internal constructor(context:Context):RecyclerView.Adapter<PartidoAdapter.PartidoViewHolder>(){


    private var inflater = LayoutInflater.from(context)
    private var partidos = emptyList<ClasePartido>()

abstract fun setClickListenerToPartido(holderPartido: PartidoViewHolder, partido:ClasePartido,ganador:String)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartidoViewHolder {
        val itemView= inflater.inflate(R.layout.fragment_partido,parent,false)
        return PartidoViewHolder(itemView)
    }

    override fun getItemCount()=partidos.size

    override fun onBindViewHolder(holder: PartidoViewHolder, position: Int) {
val partidoActual = partidos[position]
        //Para el ganador
    var ganador:String
        if(partidoActual.puntos_local>partidoActual.puntos_visitante)
        {
            ganador = partidoActual.local
        }
        else
        {
            ganador = partidoActual.visitante
        }

        setClickListenerToPartido(holder,partidoActual,ganador)
    holder.local.text = partidoActual.local
        holder.visitante.text = partidoActual.visitante
        holder.ganador.text = partidoActual.ganador
        holder.fecha.text = partidoActual.fecha.toString()
    }

    internal fun setPartidos(partidos:List<ClasePartido>)
    {
        this.partidos = partidos
        notifyDataSetChanged()
    }


    inner class PartidoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val fecha: TextView = itemView.fecha
        val hora:TextView = itemView.hora
        val local:TextView = itemView.local
        val visitante:TextView = itemView.visitante
        val ganador: TextView = itemView.winner

        val match_container: LinearLayout = itemView.match_container

    }

}