//Student Number: ST10470970 Student Name: Alexander Tait
package com.example.imadpracticum

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declare array lists to hold song data
    private val songTitles = ArrayList<String>()
    private val artistNames = ArrayList<String>()
    private val ratings = ArrayList<Int>()
    private val comments = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to UI components
        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etArtist = findViewById<EditText>(R.id.etArtist)
        val etRating = findViewById<EditText>(R.id.etRating)
        val etComment = findViewById<EditText>(R.id.etComment)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnGoDetails = findViewById<Button>(R.id.btnGoDetails)
        val btnExit = findViewById<Button>(R.id.btnExit)

        // Add button click listener
        btnAdd.setOnClickListener {
            val title = etTitle.text.toString()
            val artist = etArtist.text.toString()
            val rating = etRating.text.toString().toIntOrNull()
            val comment = etComment.text.toString()

            if (title.isBlank() || artist.isBlank() || rating == null || rating !in 1..5) {
                Toast.makeText(this, "Enter valid data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            songTitles.add(title)
            artistNames.add(artist)
            ratings.add(rating)
            comments.add(comment)

            Toast.makeText(this, "Song added!", Toast.LENGTH_SHORT).show()

            // Clear input fields
            etTitle.text.clear()
            etArtist.text.clear()
            etRating.text.clear()
            etComment.text.clear()
        }

        // Go to detailed view screen
        btnGoDetails.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java)
            intent.putStringArrayListExtra("titles", songTitles)
            intent.putStringArrayListExtra("artists", artistNames)
            intent.putIntegerArrayListExtra("ratings", ratings)
            intent.putStringArrayListExtra("comments", comments)
            startActivity(intent)
        }

            btnExit.setOnClickListener(){
                finishAffinity()
            }

    }
}
