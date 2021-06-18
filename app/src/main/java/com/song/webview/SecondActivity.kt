package com.song.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val url = intent.getStringExtra(Misc.URL)

        val webView = findViewById<WebView>(R.id.second_webView)
        if (url != null) {
            webView.loadUrl(url)
        }
    }
}