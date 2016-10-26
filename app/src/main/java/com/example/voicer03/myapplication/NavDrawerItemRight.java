package com.example.voicer03.myapplication;

import android.view.View;

public class NavDrawerItemRight {

	public String tag;
	public String id;
	public String distanciaRota;
	

	public NavDrawerItemRight(){
		
	}

	public NavDrawerItemRight(String tag, String id){
		this.tag = tag;
		this.id = id;
	}
	
	public NavDrawerItemRight(String tag, String id, String distanciaRota){
		this.tag = tag;
		this.id = id;
		this.distanciaRota = distanciaRota;
	}
	

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getDistanciaRota() {
		return distanciaRota;
	}

	public void setDistanciaRota(String distanciaRota) {
		this.distanciaRota = distanciaRota;
	}

	public static void createConvertView(NavDrawerItemRight item, View convertView){
//		ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
//		TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
//		imgIcon.setImageResource(item.getIcon());
//		txtTitle.setText(item.getTitle());
	}
}
