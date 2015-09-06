package com.example.youxuan.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jingpingouwu.R;

public class WebviewActivity extends Activity implements OnClickListener {
	private WebView webView;
	private String ST;
	private ImageView imageView;
	private ImageView imageViewclose;

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		ST = (String) getIntent().getStringExtra("link");
		initUI();
		initData();
	}

	@SuppressLint("SetJavaScriptEnabled")
	private void initData() {
		// webView.getSettings().setJavaScriptEnabled(true);
		// webView.loadDataWithBaseURL(null, ST, "text/html","UTF-8", null);
		webView.loadUrl(ST);
		webView.getSettings().setJavaScriptEnabled(true);

		webView.setWebViewClient(new WebViewClient());

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
			webView.goBack(); // goBack()表示返回WebView的上一页面
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	private void initUI() {
		webView = (WebView) findViewById(R.id.webview);
		imageView = (ImageView) findViewById(R.id.XQback1);
		imageView.setOnClickListener(this);

		imageViewclose = (ImageView) findViewById(R.id.fanhuizhujiemian);
		imageViewclose.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// Intent intentback=new Intent(this,MainActivity.class);
		switch (v.getId()) {
		case R.id.XQback1:
			if (webView.canGoBack()) {
				webView.goBack();
			}
			// else
			// finish();

			// startActivity(intentback);
			break;
		case R.id.fanhuizhujiemian:
			Toast.makeText(this, "退出详情", Toast.LENGTH_LONG).show();
			finish();
			break;

		default:
			break;
		}

	}

}
