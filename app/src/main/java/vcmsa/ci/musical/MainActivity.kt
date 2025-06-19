package vcmsa.ci.musical

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var sgTitle: EditText
    private lateinit var artName: EditText
    private lateinit var userComments: EditText

    private lateinit var rdoGroupRating: RadioGroup
    private lateinit var rdoRating1: RadioButton
    private lateinit var rdoRating2: RadioButton
    private lateinit var rdoRating3: RadioButton
    private lateinit var rdoRating4: RadioButton
    private lateinit var rdoRating5: RadioButton

    private lateinit var btnAddPlaylist: Button
    private lateinit var btnDetails: Button
    private lateinit var btnExit: Button
    private lateinit var btnClear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize views
        sgTitle = findViewById(R.id.sgTitle)
        artName = findViewById(R.id.artName)
        userComments = findViewById(R.id.userComments)

        rdoGroupRating = findViewById(R.id.rdoGroupRating)
        rdoRating1 = findViewById(R.id.rdoRating1)
        rdoRating2 = findViewById(R.id.rdoRating2)
        rdoRating3 = findViewById(R.id.rdoRating3)
        rdoRating4 = findViewById(R.id.rdoRating4)
        rdoRating5 = findViewById(R.id.rdoRating5)



        btnAddPlaylist = findViewById(R.id.btnAddPlaylist)
        btnDetails = findViewById(R.id.btnDetails)
        btnExit = findViewById(R.id.btnExit)
        btnClear = findViewById(R.id.btnClear)

        // Button click listeners
        btnAddPlaylist.setOnClickListener { addPlaylist() }



        btnDetails.setOnClickListener {
            val intent = Intent(this, MainActivity22::class.java)
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            finishAffinity()
        }

        btnClear.setOnClickListener {
            sgTitle.text.clear()
            artName.text.clear()
            userComments.text.clear()
            rdoGroupRating.clearCheck()
        }
    }

    private fun addPlaylist() {
        val title = sgTitle.text.toString().trim()
        val artist = artName.text.toString().trim()
        val comments = userComments.text.toString().trim()
        val selectedRating = when {
            rdoRating1.isChecked -> 1
            rdoRating2.isChecked -> 2
            rdoRating3.isChecked -> 3
            rdoRating4.isChecked -> 4
            rdoRating5.isChecked -> 5
            else -> 0
        }

        if (title.isEmpty() || artist.isEmpty() || selectedRating == 0 || comments.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields and select a rating", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(this, "Playlist added: $title by $artist", Toast.LENGTH_SHORT).show()
    }
}
