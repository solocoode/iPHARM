package com.example.ipharm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var edt_email: EditText
    private lateinit var edt_Password: EditText
    lateinit var btn_login: Button
    lateinit var tv_tosignup: TextView
    lateinit var tv_colorsignup: TextView
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edt_email = findViewById(R.id.edt_email)
        edt_Password = findViewById(R.id.edt_Password)
        btn_login = findViewById(R.id.btn_login)
        tv_tosignup = findViewById(R.id.tv_tosignup)
        tv_colorsignup = findViewById(R.id.tv_colorsignup)

        auth = FirebaseAuth.getInstance()

        btn_login.setOnClickListener {
            login()
        }

        tv_tosignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
        tv_colorsignup.setOnClickListener {
            val intent2 = Intent(this, SignupActivity::class.java)
            startActivity(intent2)
            finish()
        }

    }

    private fun login() {
        val email = edt_email.text.toString()
        val pass = edt_Password.text.toString()
        if (email.isBlank() || pass.isBlank()){
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful){
                Toast.makeText(this, "Successfully Logged in", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }else
                Toast.makeText(this, "Log in failed", Toast.LENGTH_SHORT).show()
        }
    }


}