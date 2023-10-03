package id.androiddev.quest7_recyclerview.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.androiddev.quest7_recyclerview.DataClass.ListItem24
import id.androiddev.quest7_recyclerview.DataClass.RecyclerItem0
import id.androiddev.quest7_recyclerview.DataTipe.DataItemType
import id.androiddev.quest7_recyclerview.databinding.HandphoneCardviewBinding
import id.androiddev.quest7_recyclerview.databinding.ListappItemBinding
// Sampai Class Adapter CHILD
class ChildAdapter(private val viewType: Int,private val recylerItemList :List<RecyclerItem0> ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
   inner class  ListItemViewHolder(private val binding: ListappItemBinding) :RecyclerView.ViewHolder(binding.root) {
       fun bindListItemView(ListItem : ListItem24) {
           binding.imglistapp.setImageResource(ListItem.Image)
           binding.clothingOfferTv.text = ListItem.Teks
       }
   }

    inner class ListItemPhoneViewHolder(private val binding : HandphoneCardviewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindListPhoneView(ListItem: ListItem24) {
            binding.imglistphone.setImageResource(ListItem.Image)
            binding.texthandphonetv.text =ListItem.Teks
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