package jawoheer.example.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class TripsRecyclerViewHolder(view: View): RecyclerView.ViewHolder(view){
    val initialPoint=view.findViewById<TextView>(R.id.txt_initialPoint)
    val destination=view.findViewById<TextView>(R.id.txt_destination)
    val date=view.findViewById<TextView>(R.id.txt_date)
    val cost=view.findViewById<TextView>(R.id.txt_cost)

    fun bind(item:BookInfo, listener: TripsRecyclerViewAdapter.OnItemClickListener){
      itemView.setOnClickListener(View.OnClickListener {
          listener.onItemClick(item)
      })
    }
}


class TripsRecyclerViewAdapter(private var bookInfo: List<BookInfo>, private var listener:OnItemClickListener)
    : RecyclerView.Adapter<TripsRecyclerViewHolder>() {

    interface OnItemClickListener{
        fun onItemClick(item:BookInfo)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripsRecyclerViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return TripsRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bookInfo.size
    }

    override fun onBindViewHolder(holder: TripsRecyclerViewHolder, position: Int) {
        val bookInfoItem=bookInfo[position]
        holder.initialPoint.text=bookInfoItem.initialPoint
        holder.destination.text=bookInfoItem.destination
        holder.date.text=bookInfoItem.date
        holder.cost.text=bookInfoItem.cost
        holder.bind(bookInfoItem, listener)
    }
}