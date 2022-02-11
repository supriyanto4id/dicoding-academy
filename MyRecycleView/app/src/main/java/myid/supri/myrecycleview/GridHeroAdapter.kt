package myid.supri.myrecycleview

import android.app.DownloadManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestOptions

class GridHeroAdapter(val listHero:ArrayList<Hero>): RecyclerView.Adapter<GridHeroAdapter.GridHeroHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridHeroAdapter.GridHeroHolder {
       val view:View =LayoutInflater.from(parent.context).inflate(R.layout.item_grid_hero,parent,false)
        return  GridHeroHolder(view)
    }

    override fun onBindViewHolder(holder: GridHeroAdapter.GridHeroHolder, position: Int) {

       Glide.with(holder.itemView.context)
           .load(listHero[position].photo)
           .apply(RequestOptions().override(350,350))
           .into(holder.imagePhoto)

        holder.itemView.setOnClickListener{Toast.makeText(holder.itemView.context,listHero[position].name, Toast.LENGTH_LONG).show()}
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    inner class GridHeroHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imagePhoto:ImageView =itemView.findViewById(R.id.img_item_photo)
    }
}