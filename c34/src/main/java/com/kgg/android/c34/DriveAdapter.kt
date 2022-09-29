package com.kgg.android.c34


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat

class DriveAdapter(cxt: Context, val resId: Int, val datas: MutableList<DriveVO>)
    : ArrayAdapter<DriveVO>(cxt, resId) {
    override fun getCount(): Int {
        return datas.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if(convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                    as LayoutInflater
            convertView = inflater.inflate(resId, null)

            val holder = DriveHolder(convertView)
            convertView!!.tag = holder


        }

        val holder = convertView.getTag() as DriveHolder
        val typeImageView = holder.typeImageView
        val titleView = holder.titleView
        val dateView = holder.dateView
        val menuImageView = holder.menuImageView

        val (title, date, type) = datas[position]
        titleView.text = title
        dateView.text = date
        if(type == "doc") {
            typeImageView.setImageDrawable(
                ResourcesCompat.getDrawable(
                    context.resources,
                    R.drawable.ic_launcher_foreground, null
                )
            )
        } else if(type == "file") {
            typeImageView.setImageDrawable(
                ResourcesCompat.getDrawable(
                    context.resources,
                    R.drawable.ic_launcher_foreground, null
                )
            )
        } else if(type == "img")  {
            typeImageView.setImageDrawable(
                ResourcesCompat.getDrawable(
                    context.resources,
                    R.drawable.ic_launcher_foreground, null
                )
            )
        }
        menuImageView.setOnClickListener {
            Toast.makeText(context, "$title menu click", Toast.LENGTH_SHORT).show()
        }
        return convertView
    }
}