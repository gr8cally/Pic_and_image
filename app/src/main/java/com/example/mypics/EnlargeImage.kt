package com.example.mypics

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.mypics.databinding.ActivityEnlargeImageBinding

/**
 *  Displays a text and image with a search icon that Google searches the text when clicked.
 */
class EnlargeImage : AppCompatActivity() {

    //binding variable that gives easier access to all views in [activity_enlarge_image.xml] using their ID
    private lateinit var binding: ActivityEnlargeImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnlargeImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //getting the intent that started this activity so as to extract the Extras from it
        val intent = intent
        val image_resource = intent.getIntExtra("image", 0)
        val test_resource = intent.getStringExtra("word")


        binding.imageView.setImageResource(image_resource)
        binding.textdesc.text = test_resource
    }

    // Displays the [menu_main.xml] in the appbar of this activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    //Provides functionality when a menu item is clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.google_search){
            //Implicit Intent to google search the text on screen
            val search_Url = Uri.parse("https://www.google.com/search?q=" + binding.textdesc.text)
            val intent = Intent(Intent.ACTION_VIEW, search_Url)
            startActivity(intent)
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}