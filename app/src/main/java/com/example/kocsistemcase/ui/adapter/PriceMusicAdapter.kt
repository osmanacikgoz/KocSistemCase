package com.example.kocsistemcase.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kocsistemcase.data.local.MusicEntity
import com.example.kocsistemcase.databinding.MusicPriceItemBinding
import com.example.kocsistemcase.util.loadImage

class PriceMusicAdapter(private val onItemClick: (MusicEntity, Boolean) -> Unit) :
    RecyclerView.Adapter<PriceMusicAdapter.PriceMusicViewHolder>() {

    var dataList = ArrayList<MusicEntity>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = PriceMusicViewHolder(
        MusicPriceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: PriceMusicAdapter.PriceMusicViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class PriceMusicViewHolder(private val binding: MusicPriceItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MusicEntity) = with(binding) {
            itemImage.loadImage(item.artworkUrl100)
            tvArtistName.text = item.artistName
            trackName.text = item.trackName
            releaseDate.text = item.releaseDate
            price.text = item.collectionPrice.toString()
            root.setOnClickListener {
                onItemClick.invoke(item, false)
            }

            imgDelete.setOnClickListener {
                removeItem(item = item)
                onItemClick(item, true)
            }
        }
    }

    fun setData(musicData: ArrayList<MusicEntity>) {
        this.dataList = musicData
        notifyDataSetChanged()
    }

    fun removeItem(item: MusicEntity) {
        dataList.remove(item)
        notifyDataSetChanged()
    }
}