package com.example.kocsistemcase.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kocsistemcase.data.dto.MusicResponse
import com.example.kocsistemcase.databinding.MusicItemBinding
import com.example.kocsistemcase.util.loadImage

class MusicPagingAdapter(private val onItemClick: (MusicResponse.Result) -> Unit) :
    PagingDataAdapter<MusicResponse.Result, MusicPagingAdapter.ViewHolder>(diffUtilCallback) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            MusicItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    inner class ViewHolder(private val binding: MusicItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MusicResponse.Result) = with(binding) {
            poster.loadImage(item.artworkUrl100)
            artistName.text = item.artistName
            trackName.text = item.trackName
            binding.root.setOnClickListener {
                onItemClick.invoke(item)
            }
        }
    }

    companion object {
        private val diffUtilCallback = object : DiffUtil.ItemCallback<MusicResponse.Result>() {
            override fun areItemsTheSame(
                oldItem: MusicResponse.Result,
                newItem: MusicResponse.Result
            ): Boolean {
                return oldItem.trackId == newItem.trackId
            }

            override fun areContentsTheSame(
                oldItem: MusicResponse.Result,
                newItem: MusicResponse.Result
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}