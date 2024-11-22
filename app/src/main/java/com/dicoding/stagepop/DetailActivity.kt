package com.dicoding.stagepop

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class DetailActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var dateTextView: TextView
    private lateinit var timeTextView: TextView
    private lateinit var venueTextView: TextView
    private lateinit var shareButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        imageView = findViewById(R.id.imageConcertDetail)
        titleTextView = findViewById(R.id.textTitleDetail)
        descriptionTextView = findViewById(R.id.textDescriptionDetail)
        dateTextView = findViewById(R.id.textDateDetail)
        timeTextView = findViewById(R.id.textTimeDetail)
        venueTextView = findViewById(R.id.textVenueDetail)

        shareButton = findViewById(R.id.action_share)

        val concert: Concert? = intent.getParcelableExtra("key_concert")

        concert?.let {
            imageView.setImageResource(it.imageResId)
            titleTextView.text = it.title
            descriptionTextView.text = it.description
            dateTextView.text = "Date: ${it.date}"
            timeTextView.text = "Time: ${it.time}"
            venueTextView.text = "Venue: ${it.venue}"
        }

        shareButton.setOnClickListener {
            shareConcertDetails(concert)
        }
    }

    private fun shareConcertDetails(concert: Concert?) {
        concert?.let {
            val shareMessage = "Check out this concert!\n\n" +
                    "Title: ${it.title}\n" +
                    "Description: ${it.description}\n" +
                    "Date: ${it.date}\n" +
                    "Time: ${it.time}\n" +
                    "Venue: ${it.venue}"

            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, shareMessage)
                type = "text/plain"
            }

            startActivity(Intent.createChooser(shareIntent, "Share concert details via"))
        }
    }
}
