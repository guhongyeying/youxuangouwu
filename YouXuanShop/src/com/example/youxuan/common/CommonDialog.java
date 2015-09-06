package com.example.youxuan.common;

import android.app.ProgressDialog;
import android.content.Context;

public class CommonDialog {
	private static ProgressDialog progressDialog;
	
	/**
	 * 显示进度条对话框
	 * @param context 上下文
	 * @param message 提示
	 */
	public static void showProgressDialog(Context context, String message) {
		progressDialog = new ProgressDialog(context);
		progressDialog.setMessage(message);
		progressDialog.show();
	}
	
	/**
	 * 关闭进度条对话框
	 */
	public static void hideProgressDialog() {
		progressDialog.dismiss();
	}
}
