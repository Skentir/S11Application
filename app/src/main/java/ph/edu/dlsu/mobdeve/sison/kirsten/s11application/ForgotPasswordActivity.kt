package ph.edu.dlsu.mobdeve.sison.kirsten.s11application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.edu.dlsu.mobdeve.sison.kirsten.s11application.databinding.ActivityForgotPasswordBinding
import ph.edu.dlsu.mobdeve.sison.kirsten.s11application.databinding.ActivityRegisterBinding

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmitRecovery.setOnClickListener {
            val intent = Intent()
            intent.putExtra("email", binding.etEmailRecovery.text.toString())
            setResult(1,intent)
            finish()
        }
    }

}