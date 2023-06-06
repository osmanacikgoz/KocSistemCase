package com.example.kocsistemcase.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kocsistemcase.data.local.MusicEntity
import com.example.kocsistemcase.databinding.MusicItemRowBinding

class TrackAdapter(private val onItemClick: (MusicEntity) -> Unit) :
    RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {
    var dataList = emptyList<MusicEntity>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = TrackViewHolder(
        MusicItemRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: TrackAdapter.TrackViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class TrackViewHolder(private val binding: MusicItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MusicEntity) = with(binding) {
            artistName.text = item.artistName
            trackName.text = item.trackName
            root.setOnClickListener { onItemClick.invoke(item) }
        }
    }


    fun setData(musicData: List<MusicEntity>) {
        this.dataList = musicData
        notifyDataSetChanged()
    }
}