package com.fantasmaplasma.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var mAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = listOf(
            ItemPrice("Apples", "$1.00"),
            ItemPrice("Banana", "$1.00"),
            ItemPrice("Onion", "$1.00"),
            ItemPrice("Plum", "$1.00"),
            ItemPrice("Pear", "$1.00")
        )

        mAdapter = RecyclerViewAdapter(this)
        mAdapter.setData(data)

        findViewById<RecyclerView>(R.id.rv_main).apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}

