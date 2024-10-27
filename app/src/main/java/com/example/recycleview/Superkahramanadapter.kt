package com.example.recycleview

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.databinding.ActivityMainBinding
import com.example.recycleview.databinding.RecyclerrowBinding

class Superkahramanadapter(val superKahramanListesi: ArrayList<superkahraman>) :RecyclerView.Adapter<Superkahramanadapter.SuperkahramanViewHolder>(){
    class SuperkahramanViewHolder(val binding: RecyclerrowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperkahramanViewHolder {

        val binding = RecyclerrowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SuperkahramanViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return superKahramanListesi.size
    }

    override fun onBindViewHolder(holder: SuperkahramanViewHolder, position: Int) {
        holder.binding.Recycletextview.text = superKahramanListesi[position].isim
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,TanitimAktivitesi::class.java)
            intent.putExtra("secilenKahraman",superKahramanListesi[position])
            holder.itemView.context.startActivity(intent)
        }
    }
}