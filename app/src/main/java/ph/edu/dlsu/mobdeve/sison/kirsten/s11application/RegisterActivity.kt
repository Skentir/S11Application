package ph.edu.dlsu.mobdeve.sison.kirsten.s11application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import ph.edu.dlsu.mobdeve.sison.kirsten.s11application.databinding.ActivityMainBinding
import ph.edu.dlsu.mobdeve.sison.kirsten.s11application.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            var goToHome = Intent(this, HomeActivity::class.java)
            var bundle = Bundle()
            bundle.putString("username", binding.etUsername.text.toString())
            bundle.putString("username", binding.etPassword.text.toString())
            goToHome.putExtras(bundle)

            goToHome.putExtra("something", "Extra")
            startActivity(goToHome)
        }
    }


}