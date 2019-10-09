package com.example.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Class.UserModel
import com.example.kotlindemo.R
import java.util.ArrayList

data class UserAdapter(var userModel: ArrayList<UserModel>/*, var context: Context*/) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.userdetailslayout, parent, false);
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {

        return userModel.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //holder.tv_username.setText(userModel.get(position).username)

        holder.tv_username.text = userModel.get(position).username
        holder.iv.setImageResource(R.mipmap.ic_launcher)

        holder.tv_contact.setText("${userModel.get(position).contact}")

    }

    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var tv_username = itemview.findViewById(R.id.tv_username) as TextView
        var tv_contact = itemview.findViewById(R.id.tv_contact) as TextView
        var iv = itemview.findViewById(R.id.iv) as ImageView

    }
}


/*
package com.example.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Class.UserModel
import com.example.kotlindemo.R
import java.util.ArrayList

data class UserAdapter(var userModel: ArrayList<UserModel>*/
/*, var context: Context*//*
) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.userdetailslayout, parent, false);
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {

        return userModel.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //holder.tv_username.setText(userModel.get(position).username)

        holder.tv_username.text = userModel.get(position).name_of_song
        holder.tv_contact.text = userModel.get(position).artist_name
        holder.iv.setImageResource(R.mipmap.ic_launcher)

        //holder.tv_contact.setText("${userModel.get(position).contact}")

    }

    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var tv_username = itemview.findViewById(R.id.tv_username) as TextView
        var tv_contact = itemview.findViewById(R.id.tv_contact) as TextView
        var iv = itemview.findViewById(R.id.iv) as ImageView

    }
}*/
