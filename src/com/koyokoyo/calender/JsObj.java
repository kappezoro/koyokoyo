package com.koyokoyo.calender;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

class JsObj {
	  private Context con;
	 
	  public JsObj(Context con) {
	    this.con = con;
	  }
	 
	  public String gps(String top, String end) {
	    LocationManager locman = (LocationManager) 
	         con.getSystemService(Context.LOCATION_SERVICE);
	    //Location loc = locman.getCurrentLocation("gps");
	    //int lat = (int) (loc.getLatitude() * 1000000);
	    //int lon = (int) (loc.getLongitude() * 1000000);
	    return top + "緯度:" + 11 + ", 経度: " + 11 + end;
	  }
	}