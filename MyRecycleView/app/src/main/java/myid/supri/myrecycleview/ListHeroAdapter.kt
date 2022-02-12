package myid.supri.myrecycleview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text

class ListHeroAdapter(private val listHero: ArrayList<Hero>): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHeroAdapter.ListViewHolder {
        val view :View =LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListHeroAdapter.ListViewHolder, position: Int) {
       val hero =listHero[position]

        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.IvImgPhoto)
        holder.tvName.text = hero.name

        val image   =hero.photo
        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context,image, Toast.LENGTH_LONG).show()
            onItemClickCallback.onItemClicked(listHero[holder.adapterPosition])
            val sendDataHero = Intent(holder.itemView.context,DetailHeroActivity::class.java)
            sendDataHero.putExtra(DetailHeroActivity.EXTRA_NAME,hero.name)
            sendDataHero.putExtra(DetailHeroActivity.EXTRA_DESC,hero.detail)
            sendDataHero.putExtra(DetailHeroActivity.EXTRA_IMG,hero.imageLink)
           holder.itemView.context.startActivity(sendDataHero)
        }
    }

    override fun getItemCount(): Int {
       return listHero.size
    }


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var IvImgPhoto: ImageView =itemView.findViewById(R.id.img_item_photo)

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }
}