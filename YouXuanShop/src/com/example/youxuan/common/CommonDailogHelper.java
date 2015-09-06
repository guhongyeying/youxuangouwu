package com.example.youxuan.common;

import android.content.Context;

import com.example.youxuan.myview.CustomProgressDialog;

public class CommonDailogHelper {
	
	private static CustomProgressDialog progressDialog = null; 
	public static void startProgressDialog(Context context){  
        if (progressDialog == null){  
            progressDialog = CustomProgressDialog.createDialog(context);  
            
        }  
          
        //progressDialog.show();  
    }  
      
	public static void stopProgressDialog(){  
        if (progressDialog != null){  
            progressDialog.dismiss();  
            progressDialog = null;  
        }  
    }  
}
