package com.song.webview

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val url = intent.getStringExtra(Misc.URL)

        val textView = findViewById<TextView>(R.id.second_textView)
        textView.movementMethod = ScrollingMovementMethod()

        val webView = findViewById<WebView>(R.id.second_webView)
        webView.settings.setJavaScriptEnabled(true)
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                webView.evaluateJavascript(
                    "(function() { return ('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>'); })();"
                ) { html ->
                    textView.text = html
                }
            }
        }

        if (url != null) {
            webView.loadUrl(url)
        }
    }
}