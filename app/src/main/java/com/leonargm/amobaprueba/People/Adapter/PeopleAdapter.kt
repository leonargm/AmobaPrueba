package com.leonargm.amobaprueba.People.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentSnapshot
import com.leonargm.amobaprueba.databinding.PeopleItemBinding
import com.squareup.picasso.Picasso

class PeopleAdapter(var documents: MutableList<DocumentSnapshot>) : RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: PeopleItemBinding) : RecyclerView.ViewHolder(binding.root)
    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PeopleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(documents.get(position)){
                binding.tvName.text = documents.get(position).get("nombre").toString()
                Picasso.get().load(documents.get(position).data?.get("imagen").toString()).into(binding.ivImage)
            }
        }
        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, documents.get(position))
            }
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, documents: DocumentSnapshot)
    }

    override fun getItemCount(): Int {
        return documents.size
    }

}