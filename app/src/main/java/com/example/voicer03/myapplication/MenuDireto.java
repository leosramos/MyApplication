/*
 * SmapleListFragment.java
 * 
 * Data: 2013
 * 
 * Autor: Anderson Marques
 * 
 * Copyright (c) 2013 Rotaurbana/Execute TI
 * Rotaurbana - www.rotaurbana.net.br
 * Todos os direitos reservados.
 */

package com.example.voicer03.myapplication;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class MenuDireto {

	private ArrayList<NavDrawerItemRight> listaDeItensMenuDireito;
	private ArrayList<NavDrawerItemRight> listaDeItensMenuDireitoAuxiliar;
	private NavDrawerListAdapterRight listAdapterMenuDireito;
	private ListView listViewMenuDireito;
	
	private EditText editText;

	public MenuDireto() {
		setListViewMenuDireito((ListView) MainActivity.getMainActivity().findViewById(R.id.list_rightslidermenu));
		setListViewMenuDireito(criarRightListView());
	}
	
	public MenuDireto(ListView mDrawerRightList) {
		this.setListViewMenuDireito(mDrawerRightList);
	}
	
	public synchronized void abreMenuDireita() {
		MainActivity.getMainActivity().getMainActivityModel().getLayoutBaseMenusLaterais().openDrawer(getListViewMenuDireito());
	}

	public synchronized void fechaMenuDireita() {
		MainActivity.getMainActivity().getMainActivityModel().getLayoutBaseMenusLaterais().closeDrawer(getListViewMenuDireito());
	}
	
	public ListView inicio() {
		getListaDeItensMenuDireito().clear();
		getListaDeItensMenuDireito().add(new NavDrawerItemRight("200m", "até"));
		getListaDeItensMenuDireito().add(new NavDrawerItemRight("300m", "até"));
		getListaDeItensMenuDireito().add(new NavDrawerItemRight("500m", "até"));
		
		createNavDrawerRightItems(getListaDeItensMenuDireito());
		return getListViewMenuDireito();
	}
	
	
	public ListView criarRightListView() {
		setListaDeItensMenuDireito(new ArrayList<NavDrawerItemRight>());
		getListaDeItensMenuDireito().add(new NavDrawerItemRight("200m", "até"));
		getListaDeItensMenuDireito().add(new NavDrawerItemRight("300m", "até"));
		getListaDeItensMenuDireito().add(new NavDrawerItemRight("500m", "até"));
		
		createNavDrawerRightItems(getListaDeItensMenuDireito());
//		
//		editText = (EditText) mDrawerRightList.findViewById(R.id.autoCompleteTextView1);
//		editText.addTextChangedListener(textWatcher);
		return getListViewMenuDireito();
	}
	
	public ListView createNavDrawerRightItems(ArrayList<NavDrawerItemRight> navDrawerRightItems){
		setListAdapterMenuDireito(new NavDrawerListAdapterRight(MainActivity.getMainActivity(), navDrawerRightItems));
		
		setListViewMenuDireito((ListView) MainActivity.getMainActivity().findViewById(R.id.list_rightslidermenu));
		getListViewMenuDireito().setOnItemClickListener(new SlideMenuClickListener());
		getListViewMenuDireito().setAdapter(getListAdapterMenuDireito());
		getListViewMenuDireito().setClickable(true);
		return getListViewMenuDireito();
	}
	
	private class SlideMenuClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
			NavDrawerItemRight clicado = getListaDeItensMenuDireito().get(position); 
			if (!clicado.getId().equals("até")) {
			}
		}
	}

	public void filter(String charText) {
		charText = charText.toLowerCase(Locale.getDefault());
		getListaDeItensMenuDireitoAuxiliar().clear();
		if (charText.length() == 0) {
			createNavDrawerRightItems(getListaDeItensMenuDireito());
		} else {
			NavDrawerItemRight item = null;
			for (int i = 0; i < getListaDeItensMenuDireito().size(); i++) {
				item = getListaDeItensMenuDireito().get(i);
				if (item.tag.equalsIgnoreCase("200m")|| item.tag.equalsIgnoreCase("300m")|| item.tag.equalsIgnoreCase("500m")) {
					getListaDeItensMenuDireitoAuxiliar().add(item);
				}
				if (item.tag.toLowerCase(Locale.getDefault()).contains(charText)
						&& !(item.tag.equalsIgnoreCase("200m")|| item.tag.equalsIgnoreCase("300m") || item.tag.equalsIgnoreCase("500m"))) {
					getListaDeItensMenuDireitoAuxiliar().add(item);
				}
			}
			createNavDrawerRightItems(getListaDeItensMenuDireitoAuxiliar());
		}
	}


	public ListView getListViewMenuDireito() {
		return listViewMenuDireito;
	}

	public void setListViewMenuDireito(ListView mDrawerRightList) {
		this.listViewMenuDireito = mDrawerRightList;
	}

	public ArrayList<NavDrawerItemRight> getListaDeItensMenuDireito() {
		return listaDeItensMenuDireito;
	}

	public void setListaDeItensMenuDireito(ArrayList<NavDrawerItemRight> navDrawerRightItems) {
		this.listaDeItensMenuDireito = navDrawerRightItems;
	}
	

	public ArrayList<NavDrawerItemRight> getListaDeItensMenuDireitoAuxiliar() {
		return listaDeItensMenuDireitoAuxiliar;
	}

	public void setListaDeItensMenuDireitoAuxiliar(ArrayList<NavDrawerItemRight> navDrawerRightItemsAux) {
		this.listaDeItensMenuDireitoAuxiliar = navDrawerRightItemsAux;
	}
	
	public NavDrawerListAdapterRight getListAdapterMenuDireito() {
		return listAdapterMenuDireito;
	}

	public void setListAdapterMenuDireito(NavDrawerListAdapterRight adapterRightList) {
		this.listAdapterMenuDireito = adapterRightList;
	}

}
