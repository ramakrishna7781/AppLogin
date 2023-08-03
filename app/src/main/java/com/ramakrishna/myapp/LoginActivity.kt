package com.ramakrishna.myapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPwd: TextView
    lateinit var txtRegisterYourself: TextView
    val validMobileNumber = "14636"
    val validPassword = arrayOf("Ramki","Tate","Dhoni")

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)


        if(isLoggedIn){
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPwd = findViewById(R.id.txtForgotPwd)
        txtRegisterYourself = findViewById(R.id.txtRegisterYourself)



        btnLogin.setOnClickListener{
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()

            var nameOfPerson = "Person"

            val intent = Intent(this@LoginActivity, MainActivity::class.java)

            if((mobileNumber == validMobileNumber) ) {
                if (password == validPassword[0]) {
                    nameOfPerson = "Ramakrishna"
                    savePreferences(nameOfPerson)
                    startActivity(intent)
                }else if (password == validPassword[1]){
                    nameOfPerson = "Andrew Tate"
                    savePreferences(nameOfPerson)
                    startActivity(intent)
                }else if (password == validPassword[2]){
                    nameOfPerson = "MS Dhoni"
                    savePreferences(nameOfPerson)
                    startActivity(intent)
                }
            }
            else {
                    Toast.makeText(this@LoginActivity, "Incorrect Credentials.", Toast.LENGTH_LONG).show()
            }

        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}