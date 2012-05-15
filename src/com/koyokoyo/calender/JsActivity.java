package com.koyokoyo.calender;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.webkit.WebView;

public class JsActivity extends Activity {
	  /** Called when the activity is first created. */
	  @Override
	   public void onCreate(Bundle icicle) {
	      super.onCreate(icicle);
	      WebView wv = new WebView(this);
	      wv.getSettings().setJavaScriptEnabled(true);
	      JsObj jo = new JsObj(this);
	      wv.addJavascriptInterface(jo, "roid");
	      wv.loadUrl("http://uu-ka.com/TestJs.html");
	      
	      setContentView(wv);
	     
	  }
	 
	   class JsObj {
	      private Context con;
	 
	      public JsObj(Context con) {
	         this.con = con;
	      }
	 
	      public String gps(String top, String end) {
	         LocationManager locman = (LocationManager) con
	              .getSystemService(Context.LOCATION_SERVICE);
	         //Location loc = locman.getCurrentLocation("gps");
	         //int lat = (int) (loc.getLatitude() * 1000000);
	         //int lon = (int) (loc.getLongitude() * 1000000);
	         return top + "緯度:" + 11+ ", 経度: " + 11 + end;
	      }
	  }
	}

