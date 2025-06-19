//Student Number: ST10470970 Student Name: Alexander Tait
package com.example.imadpracticum

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailedViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        Toast.makeText(this, "DetailedViewActivity started", Toast.LENGTH_SHORT).show()


        // Get references to the UI components
        val btnShowSongs = findViewById<Button>(R.id.btnShowSongs)
        val btnAverage = findViewById<Button>(R.id.btnAverage)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val tvOutput = findViewById<TextView>(R.id.tvOutput)

        // Receive data from MainActivity
        val titles = intent.getStringArrayListExtra("titles") ?: arrayListOf()
        val artists = intent.getStringArrayListExtra("artists") ?: arrayListOf()
        val ratings = intent.getIntegerArrayListExtra("ratings") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        // Display the songs using a loop
        btnShowSongs.setOnClickListener {
            val result = StringBuilder()
            for (i in titles.indices) {
                result.append("Title: ${titles[i]}\n")
                result.append("Artist: ${artists[i]}\n")
                result.append("Rating: ${ratings[i]}\n")
                result.append("Comment: ${comments[i]}\n\n")
            }
            tvOutput.text = result.toString()
        }

        // Calculate and display average rating
        btnAverage.setOnClickListener {
            if (ratings.isNotEmpty()) {
                val avg = ratings.average()
                tvOutput.text = "Average Rating: %.2f".format(avg)
            } else {
                tvOutput.text = "No ratings available."
            }
        }

        // Go back to main screen
        btnBack.setOnClickListener {
            finish() // Ends this activity and returns to the previous one
        }
    }
}
