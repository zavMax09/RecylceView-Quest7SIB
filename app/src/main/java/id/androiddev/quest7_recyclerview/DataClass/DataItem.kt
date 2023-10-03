package id.androiddev.quest7_recyclerview.DataClass

data class DataItem(val viewType: Int) {
    var recylerItemList : List<RecyclerItem0>? = null
    var banner: BannerView1 ? = null
    var section : Section? = null
    var ListItem : List<RecyclerItem0>? = null

    constructor(viewType: Int, recylerItemList:List<RecyclerItem0>) : this(viewType){
        this.recylerItemList = recylerItemList
    }

    constructor(viewType: Int, banner : BannerView1): this(viewType) {
        this.banner = banner
    }

    constructor(viewType: Int, section: Section) : this(viewType) {
        this.section = section
    }

//    constructor(viewType: Int, listItem:List<ListItem24>) : this(viewType) {
//        this.ListItem = listItem
//    }

}

data class RecyclerItem0( val Icon: Int, val Title: String, val Desc : String)

data class BannerView1 ( val Image : Int)

data class Section ( val DescLanjut: String)

//data class ListItem24 ( val Image: Int, val Teks: String)
