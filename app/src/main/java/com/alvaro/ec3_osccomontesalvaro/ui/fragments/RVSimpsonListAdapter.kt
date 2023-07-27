package com.alvaro.ec3_osccomontesalvaro.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvaro.ec3_osccomontesalvaro.databinding.ItemNoteBinding
import com.alvaro.ec3_osccomontesalvaro.model.Simpson
import com.bumptech.glide.Glide

class RVNoteListAdapter(var simpsons: List<Simpson>): RecyclerView.Adapter<NoteVH>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVH {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteVH(binding)
    }

    override fun getItemCount(): Int = simpsons.size

    override fun onBindViewHolder(holder: NoteVH, position: Int) {
        holder.bind(simpsons[position])
    }

}

class NoteVH(private val binding: ItemNoteBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(simpson: Simpson) {
        binding.txtNoteTitle.text = simpson.Nombre
        binding.txtContentNote.text = simpson.Genero
        binding.txtLablesNote.text = simpson.Estado
        binding.txtCreateNote.text = simpson.Ocupacion
        // Cargar la imagen usando Glide
        Glide.with(itemView.context)
            .load(simpson.Imagen)
            .into(binding.imgSimpson)
    }

}