package vcmsa.ci.musical

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import vcmsa.ci.musical.R

// Declare views
private lateinit var avgMinutes: TextView
private lateinit var btnCaluclate: Button
private lateinit var btnBack: Button
private lateinit var btnLeave: Button
private lateinit var textView: TextView

class MainActivity22 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        // Initialize views
        avgMinutes = findViewById(R.id.avgMinutes)
        btnCaluclate = findViewById(R.id.btnCaluclate)
        btnBack = findViewById(R.id.btnBack)
        btnLeave = findViewById(R.id.BtnLeave)
        textView = findViewById(R.id.textView)

        // Retrieve data from the intent
        val title = intent.getStringExtra("songTitle")
        val artist = intent.getStringExtra("artistName")
        val comment = intent.getStringExtra("userComments")
        val rating = intent.getIntExtra("rating", 0)

        // Display the data in the TextView
        avgMinutes.text = "$title by $artist\nRating: $rating\nComment: $comment"


        // Calculate average minutes
        val btnCaluclate = findViewById<Button>(R.id.btnCaluclate)
        btnCaluclate.setOnClickListener {
            avgMinutes.text = "Avg Mins: {GameSessionProcessor.avgMinutes()}"
            // Button actions
            btnBack.setOnClickListener { finish() }

            btnLeave.setOnClickListener { finishAffinity() }
        }
    }
}