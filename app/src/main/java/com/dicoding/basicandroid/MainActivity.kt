package com.dicoding.basicandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvCar: RecyclerView
    private var list: ArrayList<Car> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "Formula 1"

        rvCar = findViewById(R.id.rv_car)
        rvCar.setHasFixedSize(true)

        list.addAll(CarsData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvCar.layoutManager = LinearLayoutManager(this)
        val carAdapter = CarAdapter(list)
        rvCar.adapter = carAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val iAbout = Intent(this@MainActivity,
                    About::class.java)
                startActivity(iAbout)
            }
        }
    }
}