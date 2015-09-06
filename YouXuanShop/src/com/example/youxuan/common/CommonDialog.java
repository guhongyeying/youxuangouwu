package com.example.youxuan.common;

import android.app.ProgressDialog;
import android.content.Context;

public class CommonDialog {
	private static ProgressDialog progressDialog;
	
	/**
	 * ��ʾ�������Ի���
	 * @param context ������
	 * @param message ��ʾ
	 */
	public static void showProgressDialog(Context context, String message) {
		progressDialog = new ProgressDialog(context);
		progressDialog.setMessage(message);
		progressDialog.show();
	}
	
	/**
	 * �رս������Ի���
	 */
	public static void hideProgressDialog() {
		progressDialog.dismiss();
	}
}
