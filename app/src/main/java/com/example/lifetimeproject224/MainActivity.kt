package com.example.lifetimeproject224

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listmap: ArrayList<Model> = ArrayList()
        var model1 = Model("So nha 100 Pham Van Dong", "so nha 100 ngo 401 /72/14, Pham Vam Dong , Tu Liem , Ha Noi, Viet Nam", "100m  200km",  1234567)
        var model2 = Model("so nha 20 pham van dong", "so nha 100 ngo 401 /72/14, Pham Vam Dong , Tu Liem , Ha Noi, Viet Nam", "100m  200km",  1234567)
        listmap.add(model1)
        listmap.add(model1)
        listmap.add(model1)
        listmap.add(model1)
        listmap.add(model1)
        listmap.add(model1)
        listmap.add(model1)
        listmap.add(model1)
        listmap.add(model1)



        var adapter = Adapter(this, listmap)
        rvmap.layoutManager = LinearLayoutManager(this@MainActivity)


        imgsetting.setOnClickListener {
            val intent = Intent(this@MainActivity, SettingActivity::class.java)
            startActivity(intent)
        }
        floatingActionButton.setOnClickListener {
            rvmap.visibility = VISIBLE
            rvmap.adapter = adapter
            tvcontinueshipping.setTextColor(Color.parseColor("#009688"))
        }
    }

}
