package myid.supri.myrecycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class MoveWithResulthActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit  var btnPilih : Button
    private lateinit var radioGroup: RadioGroup

    companion object{
        const val EXTRA_SELECTED_VALUE ="extra_selected_value"
        const val RESULT_CODE =110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_resulth)

        btnPilih =findViewById(R.id.btn_choose)
        radioGroup=findViewById(R.id.rg_number)

        btnPilih.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_choose){
            if (radioGroup.checkedRadioButtonId>0){
                var value =0
                when(radioGroup.checkedRadioButtonId){
                    R.id.rb_10 -> value =10
                    R.id.rb_100 -> value =100
                    R.id.rb_20 -> value =20
                    R.id.rb_50 -> value =50
                    R.id.rb_90 -> value =90
                }

                val result = Intent ()

                result.putExtra(EXTRA_SELECTED_VALUE,value)
                setResult(RESULT_CODE,result)
                finish()
            }
        }
    }
}