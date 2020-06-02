package kr.co.tjoeun.colosseum_kotlin.adapters

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kr.co.tjoeun.colosseum_kotlin.R
import kr.co.tjoeun.colosseum_kotlin.datas.Topic

class TopicAdapter(context:Context, resId:Int, list:List<Topic>) : ArrayAdapter<Topic>(context,resId,list) {

    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.topic_list_item, null)
        }

        val row = tempRow!!

        return row
    }
}