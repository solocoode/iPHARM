package com.example.ipharm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.ipharm.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignupActivity : AppCompatActivity() {
    lateinit var edt_username: EditText
    lateinit var edt_email2: EditText
    lateinit var edt_phoneno: EditText
    lateinit var edt_Password2: EditText
    lateinit var btn_signup: Button
    lateinit var tv_tologin: TextView
    lateinit var tv_colorlogin: TextView

    lateinit var auth: FirebaseAuth
    lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        edt_username = findViewById(R.id.edt_username)
        edt_email2 = findViewById(R.id.edt_email2)
        edt_phoneno = findViewById(R.id.edt_phoneno)
        edt_Password2 = findViewById(R.id.edt_Password2)
        btn_signup = findViewById(R.id.btn_signup)
        tv_tologin = findViewById(R.id.tv_tologin)
        tv_colorlogin = findViewById(R.id.tv_colorlogin)

        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        tv_tologin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        tv_colorlogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        btn_signup.setOnClickListener {
            signup()
        }
    }
    private fun signup() {
        val username = edt_username.text.toString()
        val email = edt_email2.text.toString()
        val phoneno = edt_phoneno.text.toString()
        val pass = edt_Password2.text.toString()
        if (username.isBlank() ||  email.isBlank() || phoneno.isBlank() || pass.isBlank()){
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this){
            if (it.isSuccessful){
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                //redirect user to home activity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Failed to create user", Toast.LENGTH_SHORT).show()
            }
        }
    }
}