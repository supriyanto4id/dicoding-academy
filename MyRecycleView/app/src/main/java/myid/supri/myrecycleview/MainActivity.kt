package myid.supri.myrecycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var rvHeroes :RecyclerView
    private var list:ArrayList<Hero> = arrayListOf()

    lateinit var tvResult :String

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){result->
        if (result.resultCode == MoveWithResulthActivity.RESULT_CODE && result.data !=null){
            val selectedValue = result.data?.getIntExtra(MoveWithResulthActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult="$selectedValue"
        }
        Toast.makeText(this,tvResult, Toast.LENGTH_LONG).show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle("Mode List ")
       rvHeroes =findViewById(R.id.rv_heroes)
       rvHeroes.setHasFixedSize(true)

        list.addAll(HeroesData.listData)
        showRecycleList()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                showRecycleList()
                setActionBarTitle("Mode List ")
            }
            R.id.action_grid -> {
            showRecyclerGrid()
                setActionBarTitle("Mode Grid ")
            }
            R.id.action_cardView -> {
                showRecyclerCardView()
                setActionBarTitle("Mode Card View ")
            }
            R.id.select_number->{
                val selectNumberIntent = Intent(this,MoveWithResulthActivity::class.java)
                resultLauncher.launch(selectNumberIntent)


            }
        }
    }


    private fun showRecycleList(){
        rvHeroes.layoutManager = LinearLayoutManager(this)

        val listHeroAdapter = ListHeroAdapter(list)

        rvHeroes.adapter =listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Hero) {
               // showSelectedHero(data)


            }

        })
    }

    private fun showRecyclerGrid() {
        rvHeroes.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridHeroAdapter(list)
        rvHeroes.adapter = gridHeroAdapter
    }

    private fun showRecyclerCardView() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val cardViewHeroAdapter = CardHeroAdapter(list)
        rvHeroes.adapter = cardViewHeroAdapter
    }

    private fun setActionBarTitle(title:String){
        supportActionBar?.title =title
    }

    private fun showSelectedHero(hero: Hero){
        Toast.makeText(this,"Kamu Memilih "+ hero.name + "= "+hero.photo, Toast.LENGTH_SHORT).show()
    }

}