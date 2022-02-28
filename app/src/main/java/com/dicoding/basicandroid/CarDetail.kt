package com.dicoding.basicandroid

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CarDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_car_detail)
        val actionbar = supportActionBar
        actionbar!!.title = "Team Detail"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetName: TextView = findViewById(R.id.tv_set_name)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val imgCarPhoto: ImageView = findViewById(R.id.car_img)
        val tvRacer1: TextView = findViewById(R.id.tv_racer1)
        val tvRacer2: TextView = findViewById(R.id.tv_racer2)
        val tvDetail: TextView = findViewById(R.id.tv_set_overview)

        val tName  = intent.getStringExtra(EXTRA_NAME)
        val tImg = intent.getIntExtra(EXTRA_PHOTO, 0)
        val tCarImg = intent.getIntExtra(EXTRA_IMAGE, 0)
        val tRacer1 = intent.getStringExtra(EXTRA_RACER1)
        val tRacer2 = intent.getStringExtra(EXTRA_RACER2)
        val tDetail = intent.getStringExtra(EXTRA_DETAIL)

        tvSetName.text = tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        Glide.with(this)
            .load(tCarImg)
            .apply(RequestOptions())
            .into(imgCarPhoto)
        tvRacer1.text = tRacer1
        tvRacer2.text = tRacer2
        tvDetail.text = tDetail
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_RACER1 = "extra_racer1"
        const val EXTRA_RACER2 = "extra_racer2"
        const val EXTRA_IMAGE = "extra_image"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}