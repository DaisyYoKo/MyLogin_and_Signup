package com.example.mylogin_and_signup

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        val signUp = findViewById<TextView>(R.id.signUp)
        val logIn = findViewById<TextView>(R.id.Login)
        val signUpLayout = findViewById<LinearLayout>(R.id.signUpLayout)
        val logInLayout = findViewById<LinearLayout>(R.id.logInLayout)
        val signInL = findViewById<Button>(R.id.signInLogin)
        val signInS = findViewById<Button>(R.id.signInSingup)
        var Email_User = findViewById<TextInputEditText>(R.id.eMail)
        var Password = findViewById<TextInputEditText>(R.id.password)
        var CPassword = findViewById<TextInputEditText>(R.id.confirmPassword)
        var SPEmail = findViewById<TextInputEditText>(R.id.signUpEMail)
        var SPPassword = findViewById<TextInputEditText>(R.id.signUpPassword)
        signUp.setOnClickListener{
            signUp.background = resources.getDrawable(R.drawable.switch_trcks,null);
            signUp.setTextColor(resources.getColor(R.color.textColor, null));
            logIn.background = null
            signUpLayout.visibility = View.VISIBLE
            logInLayout.visibility = View.GONE
            logIn.setTextColor(resources.getColor(R.color.pinkColor, null))
        }
        logIn.setOnClickListener{
            signUp.background = null
            signUp.setTextColor(resources.getColor(R.color.pinkColor, null));
            logIn.background = resources.getDrawable(R.drawable.switch_trcks,null);
            signUpLayout.visibility = View.GONE
            logInLayout.visibility = View.VISIBLE
            logIn.setTextColor(resources.getColor(R.color.textColor, null))
        }
        signInL.setOnClickListener{
            var isempty: Boolean = false
            if (isempty(Email_User))
            {
                Email_User.setError("User Name or Email is required")
                isempty = true
            }
            if (isempty(Password))
            {
                Password.setError("Password is required")
                isempty = true
            }
            if (!isempty)
            {
                Toast.makeText(this,"Login successful", LENGTH_LONG).show()
                startActivity(Intent(this@MainActivity,HomeActivity::class.java))
            }

        }

        signInS.setOnClickListener{
            var isempty: Boolean = false
            if (isempty(SPEmail))
            {
                SPEmail.setError("User Name or Email is required")
                isempty = true
            }
            if (isempty(SPPassword))
            {
                SPPassword.setError("Password is required")
                isempty = true
            }
            if (isempty(CPassword))
            {
                CPassword.setError("ConfirmPassword is required")
                isempty = true
            }
            if (!isempty)
            {
                if(SPPassword.text.toString() == CPassword.text.toString())
                {
                    Toast.makeText(this,"Login successful", LENGTH_LONG).show()
                    startActivity(Intent(this@MainActivity,HomeActivity::class.java))
                }
               else
                {
                    CPassword.setError("ConfirmPassword is no equal with Password !")
                }
            }

        }
    }

    private fun isempty(input: TextInputEditText): Boolean {
        return input.text.toString().trim().isEmpty()
    }
}