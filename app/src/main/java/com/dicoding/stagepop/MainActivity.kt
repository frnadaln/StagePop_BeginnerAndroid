package com.dicoding.stagepop

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.stagepop.adapter.ConcertAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var concertAdapter: ConcertAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "StagePop"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val concertList = listOf(
            Concert("Chanyeol Concert", "Live Tour AsiaWorld-Expo", R.drawable.chanyeol, "7 Desember 2024", "19:00", "Beach City International Stadium, Jakarta"),
            Concert("Seventeen Concert", "Right Here: World Tour in Asia", R.drawable.svt, "8 Februari 2025", "19:00", "Jakarta"),
            Concert("2NE1 Concert", "Welcome Back 2024-25 Asia Tour", R.drawable.twone1, "23 November 2024", "19:00", "Beach City International Stadium, Jakarta"),
            Concert("BoA Concert", "BoA: One's Own", R.drawable.boa, "26 Oktober 2024", "15:00", "Basket Hall, GBK Senayan, Jakarta"),
            Concert("Day6 Concert", "Forever Young: Day6 3rd World Tour", R.drawable.day6, "19 Oktober 2024", "19:00", "Beach City International Stadium, Jakarta"),
            Concert("Stray Kids Concert", "Domin ATE World Tour", R.drawable.straykids, "21 Desember 2024", "19:00", "Madya Stadium Gelora Bung Karno, Jakarta"),
            Concert("Taemin Concert", "Ephemeral Gaze World Tour", R.drawable.taemin, "26 Oktober 2024", "19:00", "Mercedes-Benz Arena, Jakarta"),
            Concert("WayV Concert", "2024 WayV Concert", R.drawable.wayv, "05 Oktober 2024", "15:00", "Istora Senayan, Jakarta"),
            Concert("ZB1 Concert", "Timeless World: 2024 Zerobaseone The First Tour", R.drawable.zerobaseone, "26 Oktober 2024", "19:00", "ICE BSD Hall, Jakarta"),
            Concert("TXT Concert", "Act Promise: TXT World Tour", R.drawable.txt, "2 Oktober 2024", "19:00", "ICE BSD Hall, Jakarta")
        )
        concertAdapter = ConcertAdapter(this, concertList)
        recyclerView.adapter = concertAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
