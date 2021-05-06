package com.example.openbrowserwithheaders

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Browser
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.net.URLEncoder


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->

            val url = "https://afternoon-scrubland-98993.herokuapp.com/"
            // Option 1
//            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//            val bundle = Bundle()
//            bundle.putString("X-Access-Token", "hello-world")
//            bundle.putString("X-Refresh-Token", "hello-world-2")
//            browserIntent.putExtra(Browser.EXTRA_HEADERS, bundle)
//            startActivity(browserIntent)

            // Option 2
//            val webview =  WebView(this)
//            val extraHeaders: MutableMap<String, String> = HashMap()
//            extraHeaders["Authorization"] = "Bearer secret access token"
//            setContentView(webview);
//            webview.loadUrl(url, extraHeaders);

            // Option 3
            //CustomTabsIntent.Builder().build().launchUrl(this, Uri.parse(url))

//            val intent = CustomTabsIntent.Builder().build()
//
//            val headers = Bundle()
//            headers.putString("bearer-token", "Some token")
//            headers.putString("redirect-url", "Some redirect url")
//            intent.intent.putExtra(Browser.EXTRA_HEADERS, headers)
//
//            intent.launchUrl(this, Uri.parse(url))

            // Option 4
            val html = "<html><body>hello world</body></html>"

            // Replace params (if any replacement needed)
            // May work without url encoding, but I think is advisable
            // URLEncoder.encode replace space with "+", must replace again with %20
            val dataUri = "data:text/html," + URLEncoder.encode(html)

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(dataUri))
            val bundle = Bundle()
            bundle.putString("X-Access-Token", "hello-world")
            bundle.putString("X-Refresh-Token", "hello-world-2")
            browserIntent.putExtra(Browser.EXTRA_HEADERS, bundle)
            startActivity(browserIntent)


            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}