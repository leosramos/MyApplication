package com.example.voicer03.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NavDrawerListAdapter extends BaseAdapter
{
	private Context context;
	private ArrayList<NavDrawerItem> navDrawerItems;

	public NavDrawerListAdapter(Context context, ArrayList<NavDrawerItem> navDrawerItems){
		this.context = context;
		this.navDrawerItems = navDrawerItems;
	}

	@Override
	public int getCount() {
		return navDrawerItems.size();
	}

	@Override
	public NavDrawerItem getItem(int position) {
		return navDrawerItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_perfil, null);
        }
		
		ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);

		imgIcon.setImageResource(getItem(position).getIcon());
		imgIcon.setBackgroundColor(Color.rgb(112, 128, 144));

		TextView title = (TextView) convertView.findViewById(R.id.title);
		// Pego a string que está na posição(position) e faço ficar em negrito
//		System.out.println(getItem(position).getTitle());
		title.setText(getItem(position).getTitle());
		title.setTextColor(Color.WHITE);
//		Devido ser especifico não será usado o método genérico.
//       NavDrawerItem.createConvertView(navDrawerItems.get(position), convertView);
       return convertView;
	}

}

