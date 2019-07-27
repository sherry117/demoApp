package com.example.demoapp2

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.gategory_ticket.view.*

class categoryAdapter (var context: Context, var list:ArrayList<categoryClass>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        var v: View = LayoutInflater.from(context).inflate(R.layout.gategory_ticket,p0,false)
        return ItemHolder(v)

    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        (p0 as ItemHolder).bind(list[p1].id,list[p1].name,list[p1].photo)

    }

    class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {

        fun bind(id:Int,n:String,u:String)
        {
            itemView.categoryName.text=n
            // itemView.item_price.text=p.toString()
            var web:String="http://192.168.8.101/saleweb/images/"+u
            web=web.replace(" ","%20")
            Picasso.with(itemView.context).load(web).into(itemView.categoryImage)
            itemView.categoryImage.setOnClickListener {

                //Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}