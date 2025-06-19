package vcmsa.ci.musical

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import vcmsa.ci.musical.MainActivity22

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


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

                val comments = userComments.text.toString().trim()

                if (comments.isEmpty()) {
                    Toast.makeText(this, "Please enter a comment", Toast.LENGTH_SHORT).show()
                    return
                }

                Toast.makeText(this, userComments.text.toString(), Toast.LENGTH_SHORT).show()

                // Initialize views
                sgTitle = findViewById(R.id.sgTitle)
                artName = findViewById(R.id.artName)
                userComments = findViewById(R.id.userComments)

                // Initialize radio group
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

                // Button actions
                btnAddPlaylist.setOnClickListener { addPlaylist() }

                // Button actions
                btnDetails.setOnClickListener {
                    val intent = Intent(this, MainActivity22::class.java)
                    // intent.putExtra("GameSesssionProcessor", yourGameSessionProcessor) // if needed
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


            // Function to handle the "Add Playlist" button click
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
                // Check if any of the fields are empty
                if (title.isEmpty() || artist.isEmpty() || selectedRating == 0) {
                    Toast.makeText(
                        this,
                        "Please fill in all fields and select a rating",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }

                // Do something with the data, e.g. save it or pass it to another activity
                Toast.makeText(this, "Playlist added: $title by $artist", Toast.LENGTH_SHORT).show()

                if (selectedRating !in 1..5) { // Ensure rating is between 1 and 5
                    Toast.makeText(
                        this,
                        "Please select a rating between 1 and 5",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    return


                }
            }
        }
    }
}