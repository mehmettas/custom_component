package com.mehmettas.kotlin_practice

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.common_layout.view.*

class CustomComponent @JvmOverloads constructor(
    context: Context,
    attrs:AttributeSet?=null,
    defStyle:Int=0,
    defStyleRes: Int=0) : LinearLayout(context,attrs,defStyle,defStyleRes) {

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.common_layout,this,true)

        orientation = VERTICAL

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it,R.styleable.custom_compenent_attributes,0,0)
            val title = resources.getText(typedArray.getResourceId(R.styleable.custom_compenent_attributes_custom_component_title,
                R.string.string_one))

            textMain.text = title
            edittextMain.hint = "${resources.getString(R.string.hint)} $title"

            typedArray.recycle()
        }

    }
}