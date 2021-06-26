package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.example.myapplication.databinding.ActivityScrollingBinding
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding
    var sampleImages = intArrayOf(
        R.drawable.image_1,
        R.drawable.image_2,
        R.drawable.image_3,
        R.drawable.image_4,
        R.drawable.image_5 ,
        R.drawable.image_1,
        R.drawable.image_2,
        R.drawable.image_3,
        R.drawable.image_4,
        R.drawable.image_5
    )

    lateinit var searchView: SearchView
    lateinit var listView: ListView
    lateinit var list: ArrayList<String>
    lateinit var adapter: ArrayAdapter<*>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val carouselView = findViewById(R.id.carouselView) as CarouselView;
        carouselView.setPageCount(sampleImages.size);
        carouselView.setImageListener(imageListener);
        val handler = Handler()
        title = "Mindtek"
        searchView = findViewById(R.id.searchView)
        listView = findViewById(R.id.listView)
        list = ArrayList()
        list.add("Aadi")
        list.add("Aarav")
        list.add("Aarnav")
        list.add("Aarush")
        list.add("Aayush")
        list.add("Abdul")
        list.add("Abeer")
        list.add("Advaith")
        list.add("Advay")
        list.add("Advay")
        list.add("Agastya")
        list.add("Akshay")
        list.add("Amol")
        list.add("Anay")
        list.add("Anirudh")
        list.add("Anmol")
        list.add("Arjun")
        list.add("Ayushman")
        list.add("Ayaan")
        list.add("Ayush")
        list.add("Chaitanya")
        list.add("Champak")
        list.add("Chandresh")
        list.add("Chatresh")
        list.add("Devansh")
        list.add("Dakshesh")
        list.add("Farhan")
        list.add("Falan")
        list.add("Gautam")
        list.add("Gopal")
        list.add("Gaurav")
        list.add("Girish")
        list.add("Hardik")
        list.add("Hemang")
        list.add("Ishaan")
        list.add("Imaran")
        list.add("Jagdish")
        list.add("Kabir")
        list.add("Kalpit")
        list.add("Krishna")
        list.add("Lucky")
        list.add("Mohammed")
        list.add("Naveen")
        adapter = ArrayAdapter<String>(this, R.layout.row, list)
        listView.adapter = adapter

        handler.postDelayed(object : Runnable {
            override fun run() {
                //Call your function here
                list.shuffle()
                adapter.notifyDataSetChanged()
                handler.postDelayed(this, 3000)//1 sec delay
            }
        }, 0)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (list.contains(query)) {
                    adapter.filter.filter(query)

                } else {
                    Toast.makeText(this@ScrollingActivity, "No Match found", Toast.LENGTH_LONG).show()
                }
                return false

            }
            override fun onQueryTextChange(newText: String): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            imageView.setImageResource(sampleImages[position])
//            val handler = Handler()
//            handler.postDelayed(object : Runnable {
//                override fun run() {
//                    //Call your function here
//                    list.shuffle()
//                    adapter.notifyDataSetChanged()
//                    handler.postDelayed(this, 3000)//1 sec delay
//                }
//            }, 0)
        }
    }



}