package com.example.user.kotrv1

import android.content.Context
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.meal_row.view.*

class MealAdapter(var con:Context,var list:ArrayList<Meal>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as MealView).bind(list[position].name,
                list[position].price,list[position].photo)

        (holder as MealView).itemView.meal_photo.setOnClickListener {
            Toast.makeText(con,list[position].name,Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var v=LayoutInflater.from(con).inflate(R.layout.meal_row,
                parent,false)
        return  MealView(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MealView(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        fun bind(n:String,p:Double,i:String)
        {
            itemView.meal_name.text=n
            itemView.meal_price.text=p.toString()
            Picasso.with(itemView.context).load(i).into(itemView.meal_photo)
        }
    }


}