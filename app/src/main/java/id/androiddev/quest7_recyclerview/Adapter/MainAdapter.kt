package id.androiddev.quest7_recyclerview.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.androiddev.quest7_recyclerview.DataClass.BannerView1
import id.androiddev.quest7_recyclerview.DataClass.DataItem

import id.androiddev.quest7_recyclerview.DataClass.RecyclerItem0
import id.androiddev.quest7_recyclerview.DataClass.Section
import id.androiddev.quest7_recyclerview.DataTipe.DataItemType
import id.androiddev.quest7_recyclerview.R
import id.androiddev.quest7_recyclerview.databinding.BannerviewBinding
import id.androiddev.quest7_recyclerview.databinding.ChildRecyclervBinding
import id.androiddev.quest7_recyclerview.databinding.ListappItemBinding
import id.androiddev.quest7_recyclerview.databinding.SectionLayoutBinding

class MainAdapter(private val dataItemList: List<DataItem> ):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class BannerItemViewHolder(private val binding: BannerviewBinding): RecyclerView.ViewHolder(binding.root){
        fun bindBannerView(bannerView1: BannerView1) {
            binding.imgbannerview.setImageResource(bannerView1.Image)
        }
    }

    inner class RecyclerItemViewHolder(private val binding: ChildRecyclervBinding) :
    RecyclerView.ViewHolder(binding.root){

        init {
            binding.childRecyclerView.setHasFixedSize(true)
            binding.childRecyclerView.layoutManager=
                LinearLayoutManager(binding.root.context, RecyclerView.HORIZONTAL,false)
        }

        fun bindListItemRecyclerView(recycleItemList: List<RecyclerItem0>) {
            val adapter = ChildAdapter(DataItemType.LIST_ITEM, recycleItemList)
            binding.childRecyclerView.adapter = adapter

        }

        fun bindListPhoneView(recycleItemList: List<RecyclerItem0>) {
            val adapter = ChildAdapter(DataItemType.LIST_VIEWHP, recycleItemList)
            binding.childRecyclerView.adapter = adapter

        }

    }

    override fun getItemViewType(position: Int): Int {
        return when(dataItemList[position].viewType){
            DataItemType.BANNER_VIEW ->
                R.layout.bannerview

            else ->
                R.layout.child_recyclerv

        }
    }


//    inner class SectionViewHolder(private val binding: SectionLayoutBinding) : RecyclerView.ViewHolder(binding.root){
//        fun SectionView(section: Section) {
//            binding.textSection.text
//        }
//    }

    inner class ListItemViewHolder(private val binding: ListappItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            R.layout.bannerview -> {
                val binding = BannerviewBinding.inflate(LayoutInflater.from(parent.context),parent, false)
                BannerItemViewHolder(binding)
            }

            else ->{
                val binding = ChildRecyclervBinding.inflate(LayoutInflater.from(parent.context),parent, false)
                RecyclerItemViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
       return dataItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BannerItemViewHolder -> {
                dataItemList[position].banner?.let { holder.bindBannerView(it) }
            }

            else -> {
                when (dataItemList[position].viewType) {
                    DataItemType.CARDVIEW_TV -> {
                        dataItemList[position].recylerItemList?.let {
                            (holder as RecyclerItemViewHolder).bindListItemRecyclerView(
                                it
                            )
                        }
                    }

                    else -> {
                        dataItemList[position].recylerItemList?.let {
                            (holder as RecyclerItemViewHolder).bindListPhoneView(
                                it
                            )
                        }
                    }
                }
            }
        }
    }
}