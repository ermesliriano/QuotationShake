package com.example.quotationshake

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuotationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotation)

        val tvQuote = findViewById<TextView>(R.id.tv_quotation)
        val defaultName = getString(R.string.default_name)
        var currentText = tvQuote.text.toString()

        currentText = currentText.replace("%1s", defaultName)

        tvQuote.text = currentText

    }

    fun refreshQuote(view: View){

        val quotationTextView = findViewById<TextView>(R.id.tv_quotation)
        val authorTextView = findViewById<TextView>(R.id.tv_author)

        val sampleQuotation = getString(R.string.quotation)
        val sampleAuthor = getString(R.string.author)

        quotationTextView.text = sampleQuotation
        authorTextView.text = sampleAuthor
    }
}