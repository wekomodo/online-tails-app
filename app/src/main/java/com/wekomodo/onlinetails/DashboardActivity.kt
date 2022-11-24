package com.wekomodo.onlinetails

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.wekomodo.onlinetails.authentication.LoginActivity
import com.wekomodo.onlinetails.databinding.ActivityDashboardBinding


class DashboardActivity : AppCompatActivity() {
    private lateinit var mAuth : FirebaseAuth
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mAuth = FirebaseAuth.getInstance()
        binding.signout.setOnClickListener{
            MaterialAlertDialogBuilder(this@DashboardActivity)
                .setTitle(resources.getString(R.string.signout))

                .setNegativeButton(resources.getString(R.string.decline)) { _, _ ->
                    // Respond to negative button press
                }
                .setPositiveButton(resources.getString(R.string.accept)) { _, _ ->
                    mAuth.signOut()
                    Log.d("signout","clicked")
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .show()
        }
        binding.myPets.setOnClickListener{
            val intent = Intent(this@DashboardActivity, MyPets::class.java)
            startActivity(intent)
        }
        }
}