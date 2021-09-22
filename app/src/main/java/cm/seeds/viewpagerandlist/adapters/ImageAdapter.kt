package cm.seeds.viewpagerandlist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cm.seeds.viewpagerandlist.databinding.ItemImageBinding
import cm.seeds.viewpagerandlist.models.Image

class ImageAdapter : ListAdapter<Image,ImageAdapter.ImageViewHolder>(object  : DiffUtil.ItemCallback<Image>(){
    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.link == newItem.link
    }

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return newItem == oldItem
    }
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    inner class ImageViewHolder(private val databinding : ItemImageBinding) : RecyclerView.ViewHolder(databinding.root){
        fun bindData(image: Image){
            databinding.imageToShow.setImageResource(image.link)
        }
    }
}