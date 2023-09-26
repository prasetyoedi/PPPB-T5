package com.example.pppb_t5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pppb_t5.databinding.ActivityRegisterBinding

// Deklarasi Kelas RegisterActivity
class RegisterActivity : AppCompatActivity() {

// mendeklarasikan variabel binding
    private lateinit var binding: ActivityRegisterBinding
// Deklarasi Companion Object dan Konstanta-Konstanta Ekstra
// untuk mengirimkan data tambahan
    companion object {
        const val EXTRA_USERNAME = "username"
        const val EXTRA_EMAIL = "email"
        const val EXTRA_PHONE = "phone"
    }

//    Membuat method onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            registerBtn.setOnClickListener {
                // Mengambil input dari elemen tampilan
                var username = inputUsername.text.toString()
                var email = inputEmail.text.toString()
                var phone = inputPhone.text.toString()
                var password = inputPhone.text.toString()

                // Memeriksa apakah input kosong
                if (username == "" || email == "" || phone == "" || password == "") {
                    Toast.makeText(
                        this@RegisterActivity, "Input cannot be blank", Toast.LENGTH_SHORT
                    ).show()
                } else if (!termsCheck.isChecked) {
                    // Memeriksa apakah syarat dan ketentuan disetujui
                    Toast.makeText(
                        this@RegisterActivity, "Please agree to terms and conditions", Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // Jika semua validasi berhasil, buat intent dan kirim data tambahan
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