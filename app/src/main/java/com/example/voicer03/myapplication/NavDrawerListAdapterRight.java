package com.example.voicer03.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NavDrawerListAdapterRight extends BaseAdapter
{
	private Context context;
	private ArrayList<NavDrawerItemRight> navDrawerItems;
	
	private final int ITEM_VIEW_LINHA = 0;
	private final int ITEM_VIEW_SEPARADOR = 1;

	public NavDrawerListAdapterRight(Context context, ArrayList<NavDrawerItemRight> navDrawerItems){
		this.context = context;
		this.navDrawerItems = navDrawerItems;
	}
	
	@Override
	public int getItemViewType(int position) {
		return (getItem(position).id.equals("até")) ? ITEM_VIEW_SEPARADOR
				: ITEM_VIEW_LINHA;
	}

	@Override
	public int getCount() {
		return navDrawerItems.size();
	}

	@Override
	public NavDrawerItemRight getItem(int position) {
		return navDrawerItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
 
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Vai verificar se é separador ou linha
		final int type = getItemViewType(position);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = inflater.inflate(type == ITEM_VIEW_SEPARADOR ? R.layout.separador: R.layout.row, null);

		if (type == ITEM_VIEW_SEPARADOR) {
			ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
			icon.setImageResource(R.drawable.ic_action_place);

			TextView title = (TextView) convertView.findViewById(R.id.row_sep);
			title.setText(getItem(position).id + " "+ getItem(position).tag);
			title.setTextColor(Color.BLACK);
		} else {
			TextView title = (TextView) convertView.findViewById(R.id.row_title);
			TextView codigo = (TextView) convertView.findViewById(R.id.row_teste);
			//System.out.println("enable" + codigo.isEnabled());

			codigo.setTextColor(Color.WHITE);
			title.setTextColor(Color.WHITE);
			title.setText(getItem(position).tag);
			codigo.setText(getItem(position).id);
		}
       return convertView;
	}

}

