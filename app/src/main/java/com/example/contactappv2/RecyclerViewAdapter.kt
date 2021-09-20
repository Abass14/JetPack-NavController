package com.example.contactappv2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val contactList: List<Player>, var onPlayerClickLister: OnPlayerClickLister) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var mOnPlayerClickLister = this.onPlayerClickLister
    inner class ViewHolder(view: View, onPlayerClickLister: OnPlayerClickLister) : RecyclerView.ViewHolder(view){

        var theContacts = view.findViewById<TextView>(R.id.playerTxt)
        val contactImage = view.findViewById<ImageView>(R.id.playerImage)
        var vOnPlayerClickLister = onPlayerClickLister
        val nestedConst = view.findViewById<ConstraintLayout>(R.id.nestedConst)
        var views = view
        fun bindView(contactList: Player){
            theContacts.text = contactList.theText
            contactImage.setImageResource(contactList.image)
        }


    }
    interface OnPlayerClickLister{
        fun onPlayerClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_list, parent, false)
        return ViewHolder(view, mOnPlayerClickLister)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(contactList[position])
        holder.nestedConst.setOnClickListener {
            mOnPlayerClickLister.onPlayerClick(position)
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}