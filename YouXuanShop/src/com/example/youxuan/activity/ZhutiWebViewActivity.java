package com.example.youxuan.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jingpingouwu.R;
import com.example.youxuan.jiekou.Jiekou;

public class ZhutiWebViewActivity extends Activity implements OnClickListener {
	private WebView webView;
	private ImageView imageback;
	private ImageView imagebreak;
	private String str;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhutiwebview);
		str = getIntent().getStringExtra("id");
		initUI();
		initData();

	}

	@SuppressLint("SetJavaScriptEnabled")
	private void initData() {
		// TODO Auto-generated method stub
		webView.loadUrl(String.format(Jiekou.zhutixiangqingwebview, str));
		webView.getSettings().setJavaScriptEnabled(true);

		webView.setWebViewClient(new WebViewClient());
	}

	private void initUI() {
		// TODO Auto-generated method stub
		webView = (WebView) findViewById(R.id.zhuti_webview);

		imageback = (ImageView) findViewById(R.id.viewback);
		imageback.setOnClickListener(this);

		imagebreak = (ImageView) findViewById(R.id.fanhuizhujiemian2);
		imagebreak.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.viewback:
			if (webView.canGoBack())
				webView.goBack();
			break;

		case R.id.fanhuizhujiemian2:
			Toast.makeText(this, "ÍË³öÏêÇé", Toast.LENGTH_LONG).show();
			finish();

		default:
			break;
		}
	}

}
