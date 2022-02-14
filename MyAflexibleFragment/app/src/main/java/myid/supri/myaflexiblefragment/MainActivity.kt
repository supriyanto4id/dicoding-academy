package myid.supri.myaflexiblefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mFragmentManager = supportFragmentManager
        val mHomeFragment = HomeFragment()

        val fragment =mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment){

            mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, mHomeFragment, HomeFragment::class.java.simpleName)
                    .commit()
        }

    }


}