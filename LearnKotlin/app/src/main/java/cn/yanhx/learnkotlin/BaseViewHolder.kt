package cn.yanhx.learnkotlin

import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewHashMap: MutableMap<Int,View> = HashMap()

    protected open fun <T: View> getView(@IdRes id:Int): T? {
        var view = viewHashMap[id]
        if (view == null) {
            view = itemView.findViewById(id)
            viewHashMap[id] = view
        }
        return view as T
    }

    protected open fun setText(@IdRes id: Int ,text:String?) {
        (getView<View>(id) as TextView).text = text
    }
}