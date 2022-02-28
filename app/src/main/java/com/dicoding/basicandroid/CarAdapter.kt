package com.dicoding.basicandroid

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CarAdapter(private val listCar: ArrayList<Car>): RecyclerView.Adapter<CarAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.layout_car, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCar.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, racer1, racer2, photo, detail, carPhoto) = listCar[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvRacer1.text = racer1
        holder.tvRacer2.text = racer2

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, CarDetail::class.java)
            moveDetail.putExtra(CarDetail.EXTRA_NAME, name)
            moveDetail.putExtra(CarDetail.EXTRA_RACER1, racer1)
            moveDetail.putExtra(CarDetail.EXTRA_RACER2, racer2)
            moveDetail.putExtra(CarDetail.EXTRA_PHOTO, photo)
            moveDetail.putExtra(CarDetail.EXTRA_DETAIL, detail)
            moveDetail.putExtra(CarDetail.EXTRA_IMAGE, carPhoto)
            mContext.startActivity(moveDetail)
        }
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvRacer1: TextView = itemView.findViewById(R.id.tv_racer1)
        var tvRacer2: TextView = itemView.findViewById(R.id.tv_racer2)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}