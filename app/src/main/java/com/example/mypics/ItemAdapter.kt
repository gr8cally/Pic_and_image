package com.example.mypics

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

/**
 * Adapter for the [RecyclerView] in [MainActivity].
 */
class ItemAdapter (private val dataSet: Array<Array<Int>>, private val context: Context):
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {


    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.singu)
        val imageView: ImageView = view.findViewById(R.id.item_image)

    }

    /**
     * Creates new views with R.layout.item_view as its template
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return dataSet.size
    }

    /**
     * Sets/ Replaces the content of an existing view with new data
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentWord = dataSet[position][1]
        val currentImg = dataSet[position][0]

        //Sets the text and image content of the ViewHolder
        holder.textView.text = context.resources.getString(currentWord)
        holder.imageView.setImageResource(currentImg)

        // Assigns an [OnClickListener] to the imageView contained in the [ViewHolder]
        holder.imageView.setOnClickListener {
            val intent: Intent = Intent(context, EnlargeImage::class.java)
            intent.putExtra("image", currentImg)
            intent.putExtra("word", context.resources.getString(currentWord))
            context.startActivity(intent)
        }

    }
}