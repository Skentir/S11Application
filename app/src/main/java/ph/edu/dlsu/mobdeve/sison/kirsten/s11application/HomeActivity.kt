package ph.edu.dlsu.mobdeve.sison.kirsten.s11application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.edu.dlsu.mobdeve.sison.kirsten.s11application.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val source = intent.getStringExtra("source")

        println("EXTRA: $source")
        println("USERNAME: ${bundle!!.getString("username")}")
        println("EMAIL: ${bundle.getString("email")}")
        println("PASSWORD: ${bundle.getString("password")}")
    }
}