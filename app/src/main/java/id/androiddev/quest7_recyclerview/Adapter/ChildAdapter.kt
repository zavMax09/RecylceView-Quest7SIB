package id.androiddev.quest7_recyclerview.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.androiddev.quest7_recyclerview.DataClass.RecyclerItem0
import id.androiddev.quest7_recyclerview.DataTipe.DataItemType
import id.androiddev.quest7_recyclerview.databinding.HandphoneCardviewBinding
import id.androiddev.quest7_recyclerview.databinding.ListappItemBinding
// Sampai Class Adapter CHILD
class ChildAdapter(private val viewType: Int, private val recylerItemList: List<RecyclerItem0>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
   inner class  ListItemViewHolder(private val binding: ListappItemBinding) :RecyclerView.ViewHolder(binding.root) {
       fun bindListItemView(recyclerItem : RecyclerItem0) {
           binding.imglistapp.setImageResource(recyclerItem.Icon)
           binding.clothingOfferTv.text = recyclerItem.Title
           binding.clothingOfferTv.text = recyclerItem.Desc
       }
   }

    inner class ListItemPhoneViewHolder(private val binding : HandphoneCardviewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindListPhoneView(recyclerItem: RecyclerItem0) {
            binding.imglistphone.setImageResource(recyclerItem.Icon)
            binding.texthandphonetv.text =recyclerItem.Title
        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       when(viewType) {
           DataItemType.LIST_ITEM -> {
               val binding = ListappItemBinding.inflate(
                   LayoutInflater.from(parent.context),
                   parent,false
               )
               return ListItemViewHolder(binding)
           }
           else ->{
               val binding = HandphoneCardviewBinding.inflate(
                   LayoutInflater.from(parent.context),parent,false
               )
               return ListItemPhoneViewHolder(binding)
           }

       }
    }

    override fun getItemCount(): Int {
       return recylerItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }
}