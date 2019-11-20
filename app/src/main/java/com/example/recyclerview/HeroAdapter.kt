package com.example.recyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class HeroAdapter(var heros: ArrayList<Hero>,context: Context) : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {
    //var d: Int = 0
    var mContext = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
     //   d++
       // Log.d("holder", "$d")
        return ViewHolder(view)

    }


    override fun getItemCount() = heros.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var hero = heros[position]
        holder.name.text = hero.name
        holder.img.setImageResource(hero.image)
        holder.setOnCustomItemClickListener(object :CustomItemClickListener{
            override fun onCustomItemClickListener(view: View, pos: Int) {
                Toast.makeText(mContext,hero.name, Toast.LENGTH_LONG).show()
            }
        })
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener{
        val name: TextView
        val img: ImageView
        var customItemClickListener:CustomItemClickListener?=null
        init {
            name=itemView.findViewById(R.id.text_name)
            img=itemView.findViewById(R.id.image_hero)
            itemView.setOnClickListener(this)
        }


        fun setOnCustomItemClickListener(itemClickListener: CustomItemClickListener){
            this.customItemClickListener= itemClickListener

        }

        override fun onClick(v: View?) {
            this.customItemClickListener!!.onCustomItemClickListener(v!!,adapterPosition)
        }
    }


}