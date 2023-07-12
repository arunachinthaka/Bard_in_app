package com.example.bardinapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.webkit.WebSettingsCompat;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.webkit.*;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView=(WebView) findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("https://bard.google.com/");
        WebSettings webSettings=myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Enable dark mode for the WebView
        int nightModeFlags = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        if (nightModeFlags == Configuration.UI_MODE_NIGHT_YES) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                WebSettingsCompat.setForceDark(myWebView.getSettings(), WebSettingsCompat.FORCE_DARK_ON);
            }
        }



    }
    public class mywebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}