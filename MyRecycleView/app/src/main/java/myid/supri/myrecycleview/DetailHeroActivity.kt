package myid.supri.myrecycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text

class DetailHeroActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_NAME="extra_name"
        const val EXTRA_DESC ="extra_desc"
        const val EXTRA_IMG ="extra_img"
        const val EXTRA_HERO ="extra_hero"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hero)

        val dataName: TextView=findViewById(R.id.name_hero)
        val dataDesc:TextView=findViewById(R.id.desription_hero)
       val dataImg: ImageView=findViewById(R.id.img_hero)

//        val name =intent.getStringExtra(EXTRA_NAME)
//        val desc=intent.getStringExtra(EXTRA_DESC)
//        val img =intent.getStringExtra(EXTRA_IMG)
        val hero = intent.getParcelableExtra<Hero>(EXTRA_HERO) as Hero

        dataName.text =hero.name
        dataDesc.text =hero.detail

        Glide.with(this)
            .load(hero.photo)
            .circleCrop()
            .into(dataImg)

        supportActionBar?.title = hero.name


    }
}