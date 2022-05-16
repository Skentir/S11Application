package ph.edu.dlsu.mobdeve.sison.kirsten.s11application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import ph.edu.dlsu.mobdeve.sison.kirsten.s11application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:ActivityMainBinding
    private var launchForgotPassword = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result -> val data = result.data
        Snackbar.make(binding.root, "Recovering ${data!!.getStringExtra("email")}", Snackbar.LENGTH_LONG).show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOne.setOnClickListener {
            val goToLogin = Intent(this, LoginActivity::class.java)
            startActivity(goToLogin)
//            view: View? ->
//            Snackbar.make(binding.root, "Button one clicked", Snackbar.LENGTH_LONG).show()
//            Toast.makeText(applicationContext,"Button One Clicked",Toast.LENGTH_SHORT).show()
        }
        binding.btnTwo.setOnClickListener(this)

        binding.btnThree.setOnClickListener {
            var goToForgotPassword = Intent(this, ForgotPasswordActivity::class.java)
            launchForgotPassword.launch(goToForgotPassword)
        }

//        setContentView(R.layout.activity_main)
//        var button:Button = Button(applicationContext)
//        button = findViewById(R.id.button)
    }
    override fun onClick(view:View?){
        when (view!!.id) {
            R.id.btn_two -> {
                var goToRegister = Intent(this,RegisterActivity::class.java)
                startActivity(goToRegister)
                finish()
//                Toast.makeText(applicationContext,"Button Two Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
    // Third way for onclick
//    fun buttonThreeClick(view:View) {
//        Toast.makeText(applicationContext,"Button Three Clicked", Toast.LENGTH_SHORT).show()
//    }
}