package com.example.pppb_t5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pppb_t5.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    companion object {
        const val EXTRA_USERNAME = "username"
        const val EXTRA_EMAIL = "email"
        const val EXTRA_PHONE = "phone"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            registerBtn.setOnClickListener {
                var username = inputUsername.text.toString()
                var email = inputEmail.text.toString()
                var phone = inputPhone.text.toString()
                var password = inputPhone.text.toString()

                if (username == "" || email == "" || phone == "" || password == "") {
                    Toast.makeText(
                        this@RegisterActivity, "Input cannot be blank", Toast.LENGTH_SHORT
                    ).show()
                } else if (!termsCheck.isChecked) {
                    Toast.makeText(
                        this@RegisterActivity, "Please agree to terms and conditions", Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val intentToHomepageActivity = Intent(this@RegisterActivity, HomepageActivity::class.java)
                    intentToHomepageActivity.putExtra(EXTRA_USERNAME, inputUsername.text.toString())
                    intentToHomepageActivity.putExtra(EXTRA_EMAIL, inputEmail.text.toString())
                    intentToHomepageActivity.putExtra(EXTRA_PHONE, inputPhone.text.toString())
                    startActivity(intentToHomepageActivity)
                    finish()
                }
            }
        }
    }
}