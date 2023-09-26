package com.example.pppb_t5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.pppb_t5.databinding.ActivityHomepageBinding
import com.example.pppb_t5.RegisterActivity.Companion.EXTRA_USERNAME
import com.example.pppb_t5.RegisterActivity.Companion.EXTRA_EMAIL
import com.example.pppb_t5.RegisterActivity.Companion.EXTRA_PHONE

class HomepageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            var username = data?.getStringExtra(EXTRA_USERNAME)
            var email = data?.getStringExtra(EXTRA_EMAIL)
            var phone = data?.getStringExtra(EXTRA_PHONE)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var username = intent.getStringExtra(EXTRA_USERNAME)
        var email = intent.getStringExtra(EXTRA_EMAIL)
        var phone = intent.getStringExtra(EXTRA_PHONE)

        with(binding) {
            welcomeTxt.text = getString(R.string.welcome, username, email, phone)

            logoutBtn.setOnClickListener {
                val intentToRegisterActivity = Intent(this@HomepageActivity, RegisterActivity::class.java)
                startActivity(intentToRegisterActivity)
                finish()
            }
        }
    }
}