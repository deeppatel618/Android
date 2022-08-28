package com.example.apicalling

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class photoAdapter(var context:Context,var photolist:ArrayList<photoData>):RecyclerView.Adapter<photoAdapter.myClass>() {
    class myClass(var itemView:View):RecyclerView.ViewHolder(itemView){
        var photo_view=itemView.findViewById<ImageView>(R.id.imview)
        var tv_view=itemView.findViewById<TextView>(R.id.tvview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myClass {
      var v=LayoutInflater.from(context).inflate(R.layout.rowdata,parent,false)
        return myClass(v)
    }

    override fun onBindViewHolder(holder: myClass, position: Int) {
        var photoitem= photolist[position]
        Picasso.get()
            .load(photoitem.url)
            .into(holder.photo_view);
        holder.tv_view.text=photoitem.title
    }

    override fun getItemCount(): Int {
        return photolist.size
    }
}