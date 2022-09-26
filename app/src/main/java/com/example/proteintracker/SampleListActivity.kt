package com.example.proteintracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SampleListActivity : AppCompatActivity() {
    lateinit var btnList : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_list)

        btnList = findViewById(R.id.btnShowList)
        btnList.setOnClickListener(View.OnClickListener {
            var intent = Intent(this@SampleListActivity,SampleListViewActivity::class.java)
            startActivity(intent)
        })
    }
}