package com.example.mypics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView


/**
 * Main Activity and entry point for the app. Displays a RecyclerView of text and image.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2D-Array that contains image resource and text string
        val image_text_array = arrayOf(
                arrayOf(R.drawable.image1, R.string.pic_1),
                arrayOf(R.drawable.image2, R.string.pic_2),
                arrayOf(R.drawable.image3, R.string.pic_3),
                arrayOf(R.drawable.image4, R.string.pic_4),
                arrayOf(R.drawable.image5, R.string.pic_5),
                arrayOf(R.drawable.image6, R.string.pic_6)
        )

        val recyclerView : RecyclerView = findViewById<RecyclerView>(R.id.scrol)

        val itemAdapter = ItemAdapter(image_text_array, this)
        recyclerView.adapter = itemAdapter
        recyclerView.setHasFixedSize(true)
    }
}