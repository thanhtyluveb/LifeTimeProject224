package com.example.lifetimeproject224

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import java.util.*

class Adapter(internal var context: Context, internal var list: ArrayList<Model>) : RecyclerView.Adapter<Adapter.Viewholder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): Viewholder {
        // khoi tao dong cua recyclerview
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row, viewGroup, false)
        return Viewholder(view)
    }

    //bind du lieu
    override fun onBindViewHolder(viewholder: Viewholder, i: Int) {

        viewholder.tvorder.text = (i+1).toString()
        viewholder.tvaddress.text = list[i].address
        viewholder.tvaddressdigital.text = list[i].addressdigital
        viewholder.tvtime.text = list[i].time.toString()
        viewholder.tvnumberphone.text = list[i].numphone.toString()


    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var tvorder: TextView
        internal var tvaddress: TextView
        internal var tvaddressdigital: TextView
        internal var tvtime: TextView
        internal var tvnumberphone: TextView


        internal var layout: LinearLayout

        init {
            tvorder = itemView.findViewById(R.id.tvnumberorder)
            tvaddress = itemView.findViewById(R.id.tvaddress)
            tvaddressdigital = itemView.findViewById(R.id.tvaddressdigital)
            tvtime = itemView.findViewById(R.id.tvtime)
            tvnumberphone = itemView.findViewById(R.id.numberphone)
            layout = itemView.findViewById(R.id.linearlayout)

        }
    }

}
