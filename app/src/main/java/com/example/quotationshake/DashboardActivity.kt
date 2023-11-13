package com.example.quotationshake

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }

    fun callback(view: View) {
        val button = view as? Button ?: return // Casting seguro a Button
        Toast.makeText(this, button.text, Toast.LENGTH_LONG).show()

        val btnGetQ = findViewById<Button>(R.id.btn_getQ)
        val btnFavQ = findViewById<Button>(R.id.btn_favQ)
        val btnSettings = findViewById<Button>(R.id.btn_settings)
        val btnInfo = findViewById<Button>(R.id.btn_info)

        if (button == btnInfo) {
            intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        if (button == btnSettings) {
            intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        if (button == btnFavQ) {
            intent = Intent(this, FavoriteActivity::class.java)
            startActivity(intent)
        }

        if (button == btnGetQ) {
            intent = Intent(this, QuotationActivity::class.java)
            startActivity(intent)
        }
    }
}