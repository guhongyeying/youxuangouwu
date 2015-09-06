package com.example.youxuan.activity;

import com.example.jingpingouwu.R;
import com.example.youxuan.jiekou.Jiekou;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GouwucheWebview extends Activity {

	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mydipan_webview);
		initUI();
		initData();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		webView = (WebView) findViewById(R.id.mydipan_webview);
	}

	@SuppressLint("SetJavaScriptEnabled")
	private void initData() {
		// TODO Auto-generated method stub
		webView.loadUrl(Jiekou.gouwuche);
		webView.getSettings().setJavaScriptEnabled(true);

		webView.setWebViewClient(new WebViewClient());
	}

}
