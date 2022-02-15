package myid.supri.mycustomview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import java.util.*

class MyEditText  :AppCompatEditText, View.OnTouchListener {

    internal lateinit var mClearButtonImage:Drawable

    constructor(context: Context) : super(context) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        mClearButtonImage = ContextCompat.getDrawable(context, R.drawable.ic_baseline_close_24) as Drawable
        setOnTouchListener(this)

        addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               if (s.toString().isNotEmpty()) showClearButton() else hideClearButton()
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }

    fun showClearButton(){
        setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,mClearButtonImage,null)
    }

    fun hideClearButton(){
        setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,null)
    }

    override fun onTouch(v: View?, event: MotionEvent): Boolean {
        if (compoundDrawables[2] != null){
            val clearButtonStart:Float
            val clearButtonEnd:Float
            var isClearButtonClicked = false
            when(layoutDirection){
                View.LAYOUT_DIRECTION_RTL->{
                    clearButtonEnd = (mClearButtonImage.intrinsicWidth+ paddingStart).toFloat()
                    when{
                        event.x<clearButtonEnd ->isClearButtonClicked = true
                    }
                }
                else->{
                    clearButtonStart=(width-paddingEnd-mClearButtonImage.intrinsicWidth).toFloat()
                    when{
                        event.x > clearButtonStart ->isClearButtonClicked =true
                    }
                }
            }
        }
        return false
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        hint= "Masukan Nama anda"
        textAlignment =View.TEXT_ALIGNMENT_VIEW_START
    }

}