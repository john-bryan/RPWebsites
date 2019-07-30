package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondActivity extends AppCompatActivity {

    WebView webVi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webVi = findViewById(R.id.webView1);
        webVi.setWebViewClient(new WebViewClient());

        Intent intentReceived = getIntent();
        String web = intentReceived.getStringExtra("url");

        String url = "https://" + web;
        webVi.loadUrl(url);

    }
}
