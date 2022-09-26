package com.example.proteintracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import com.google.android.material.snackbar.Snackbar

class SampleListViewActivity : AppCompatActivity() {
    var items = arrayOf(
        "lorem", "ipsum", "dolor", "sit", "amet",
        "consectetuer", "adipiscing", "elit", "morbi", "vel",
        "ligula", "vitae", "arcu", "aliquet", "mollis",
        "etiam", "vel", "erat", "placerat", "ante",
        "porttitor", "sodales", "pellentesque", "augue", "purus"
    )

    lateinit var lvSample : ListView
    lateinit var spSampleList : Spinner

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_sample_list_view, menu)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_list_view)

        lvSample = findViewById(R.id.lvSample)
        spSampleList = findViewById(R.id.spSampleListView)

        lvSample.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,items)
        spSampleList.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)

        lvSample.setOnItemClickListener { adapterView, view, i, l ->
            Snackbar.make(view, "Anda Memilih: ${items[i]}",Snackbar.LENGTH_LONG).show()
        }

        spSampleList.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Snackbar.make(lvSample,"Anda Memilih ${items[p2]}",Snackbar.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        registerForContextMenu(lvSample)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        when(item.itemId){
            R.id.menu_add -> {
                Snackbar.make(lvSample, "Anda Memilih: Menu ADD Index ${info.id}",Snackbar.LENGTH_LONG).show()
            }
            R.id.menu_edit -> {
                Snackbar.make(lvSample, "Anda Memilih: Menu EDIT Index ${info.id}",Snackbar.LENGTH_LONG).show()
            }
            R.id.menu_delete -> {
                Snackbar.make(lvSample, "Anda Memilih: Menu DELETE Index ${info.id}",Snackbar.LENGTH_LONG).show()
            }
        }

        return super.onContextItemSelected(item)
    }
}