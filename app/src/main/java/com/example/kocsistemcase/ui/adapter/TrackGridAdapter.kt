package com.example.kocsistemcase.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kocsistemcase.data.local.MusicEntity
import com.example.kocsistemcase.databinding.MusicGridItemBinding

class TrackGridAdapter(private val onItemClick: (MusicEntity) -> Unit) :
    RecyclerView.Adapter<TrackGridAdapter.TrackGridViewHolder>() {
    var dataList = emptyList<MusicEntity>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = TrackGridViewHolder(
        MusicGridItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: TrackGridViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class TrackGridViewHolder(private val binding: MusicGridItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MusicEntity) = with(binding) {
            artistName.text = item.artistName
            trackName.text = item.trackName
            arrow.setOnClickListener { onItemClick.invoke(item) }
        }
    }


    fun setData(musicData: List<MusicEntity>) {
        this.dataList = musicData
        notifyDataSetChanged()
    }
}