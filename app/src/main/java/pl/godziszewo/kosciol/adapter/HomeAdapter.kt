package pl.godziszewo.kosciol.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.godziszewo.kosciol.R
import pl.godziszewo.kosciol.data.model.Biblia

class HomeAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var mLiksiegi = emptyList<Biblia>()
    private var mContext = context


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView = itemView.findViewById(R.id.ksiegiTV)
        var layouty: RelativeLayout = itemView.findViewById(R.id.relatiflejalt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.home_element, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mLiksiegi.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = mLiksiegi[position].ksiega
        holder.layouty.setOnClickListener {
            //            Toast.makeText(mContext, mLiksiegi[position].werset, Toast.LENGTH_SHORT).show()
            val intent = Intent(mContext, InfoActivity::class.java)
            intent.putExtra("kategoria", mLiksiegi[position].ksiega)
            mContext.startActivity(intent)
        }
    }

    internal fun setLiBiblia(liKsiegi: List<Biblia>) {
        this.mLiksiegi = liKsiegi
        notifyDataSetChanged()
    }
}