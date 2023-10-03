package id.androiddev.quest7_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import id.androiddev.quest7_recyclerview.Adapter.MainAdapter
import id.androiddev.quest7_recyclerview.DataClass.BannerView1
import id.androiddev.quest7_recyclerview.DataClass.DataItem
import id.androiddev.quest7_recyclerview.DataClass.RecyclerItem0
import id.androiddev.quest7_recyclerview.DataTipe.DataItemType
import id.androiddev.quest7_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  lateinit var  myList: ArrayList<DataItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainRecyclerViewe.setHasFixedSize(true)
        binding.mainRecyclerViewe.layoutManager=LinearLayoutManager(this)

        myList = ArrayList()
        prepareData()

        val adapter = MainAdapter(myList)
        binding.mainRecyclerViewe.adapter = adapter
    }

    private fun prepareData() {

        val CardViewList = ArrayList<RecyclerItem0>()
        CardViewList.add((RecyclerItem0(R.drawable.icn_bag,"Diskon","Test")))
        CardViewList.add((RecyclerItem0(R.drawable.icn_shop,"Beli","Test")))
        CardViewList.add((RecyclerItem0(R.drawable.icn_star,"Poin","Test")))

        val ListItemViewTv = ArrayList<RecyclerItem0>()
        ListItemViewTv.add(RecyclerItem0(R.drawable.bags,"Test","test"))
        ListItemViewTv.add(RecyclerItem0(R.drawable.mobiles,"Test","test"))
        ListItemViewTv.add(RecyclerItem0(R.drawable.watches,"Test","test"))

        val ListHandPhView = ArrayList<RecyclerItem0>()
        ListHandPhView.add(RecyclerItem0(R.drawable.nokia,"Nokia","test"))
        ListHandPhView.add(RecyclerItem0(R.drawable.mobiles,"test","test"))

        myList.add(DataItem(DataItemType.CARDVIEW_TV,CardViewList))
        myList.add(DataItem(DataItemType.LIST_ITEM,ListItemViewTv))
        myList.add(DataItem(DataItemType.LIST_VIEWHP,ListHandPhView))
        myList.add(DataItem(DataItemType.BANNER_VIEW, BannerView1(R.drawable.banner)))
        myList.add(DataItem(DataItemType.CARDVIEW_TV,CardViewList.asReversed()))

    }
}