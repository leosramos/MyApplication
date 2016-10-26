/*
 * PerfilFragment.java
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

import android.content.res.TypedArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class MenuEsquerdo {

    private ArrayList<NavDrawerItem> listaDeItensMenuEsquerdo;
    private NavDrawerListAdapter listAdapterMenuEsquerdo;
    private String[] listaTitulosMenuEsquerdo;
    private TypedArray listaIconesMenuEsquerdo;
    private ListView listViewMenuEsquerdo;

    public MenuEsquerdo() {

    }

    public MenuEsquerdo(Fragment myFragment) {
        setmDrawerLeftList(criarLeftListView());
    }

    public synchronized void abreMenuEsquerda() {
        MainActivity.getMainActivity().getMainActivityModel().getLayoutBaseMenusLaterais().openDrawer(getmDrawerLeftList());
    }

    public synchronized void fechaMenuEsquerda() {
        MainActivity.getMainActivity().getMainActivityModel().getLayoutBaseMenusLaterais().closeDrawer(getmDrawerLeftList());
    }


    public ListView criarLeftListView() {
        setListaTitulosMenuEsquerdo(MainActivity.getMainActivity().getResources().getStringArray(R.array.nav_drawer_items));
        setListaIconesMenuEsquerdo(MainActivity.getMainActivity().getResources().obtainTypedArray(R.array.nav_drawer_icons));
        setmDrawerLeftList((ListView) MainActivity.getMainActivity().findViewById(R.id.list_slidermenu));
        setListaDeItensMenuEsquerdo(new ArrayList<NavDrawerItem>());

        getListaDeItensMenuEsquerdo().add(new NavDrawerItem(getListaTitulosMenuEsquerdo()[0], getListaIconesMenuEsquerdo().getResourceId(0, -1)));
        getListaDeItensMenuEsquerdo().add(new NavDrawerItem(getListaTitulosMenuEsquerdo()[1], getListaIconesMenuEsquerdo().getResourceId(1, -1)));
        getListaDeItensMenuEsquerdo().add(new NavDrawerItem(getListaTitulosMenuEsquerdo()[2], getListaIconesMenuEsquerdo().getResourceId(2, -1)));
        getListaDeItensMenuEsquerdo().add(new NavDrawerItem(getListaTitulosMenuEsquerdo()[3], getListaIconesMenuEsquerdo().getResourceId(3, -1)));
//		navDrawerLeftListItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
        getListaDeItensMenuEsquerdo().add(new NavDrawerItem(getListaTitulosMenuEsquerdo()[5], getListaIconesMenuEsquerdo().getResourceId(5, -1)));
        getListaDeItensMenuEsquerdo().add(new NavDrawerItem(getListaTitulosMenuEsquerdo()[6], getListaIconesMenuEsquerdo().getResourceId(6, -1)));
        getListaDeItensMenuEsquerdo().add(new NavDrawerItem(getListaTitulosMenuEsquerdo()[7], getListaIconesMenuEsquerdo().getResourceId(7, -1)));
        getListaDeItensMenuEsquerdo().add(new NavDrawerItem(getListaTitulosMenuEsquerdo()[8], getListaIconesMenuEsquerdo().getResourceId(8, -1)));
        getListaIconesMenuEsquerdo().recycle();

        getmDrawerLeftList().setOnItemClickListener(new SlideMenuClickListener());
        setListAdapterMenuEsquerdo(new NavDrawerListAdapter(MainActivity.getMainActivity(), getListaDeItensMenuEsquerdo()));
        getmDrawerLeftList().setAdapter(getListAdapterMenuEsquerdo());
        getmDrawerLeftList().setClickable(true);
        return getmDrawerLeftList();
    }

    private class SlideMenuClickListener implements OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        }
    }


    public ListView getmDrawerLeftList() {
        return getListViewMenuEsquerdo();
    }

    public void setmDrawerLeftList(ListView mDrawerLeftList) {
        this.setListViewMenuEsquerdo(mDrawerLeftList);
    }

    public ArrayList<NavDrawerItem> getListaDeItensMenuEsquerdo() {
        return listaDeItensMenuEsquerdo;
    }

    public void setListaDeItensMenuEsquerdo(ArrayList<NavDrawerItem> listaDeItensMenuEsquerdo) {
        this.listaDeItensMenuEsquerdo = listaDeItensMenuEsquerdo;
    }

    public NavDrawerListAdapter getListAdapterMenuEsquerdo() {
        return listAdapterMenuEsquerdo;
    }

    public void setListAdapterMenuEsquerdo(NavDrawerListAdapter listAdapterMenuEsquerdo) {
        this.listAdapterMenuEsquerdo = listAdapterMenuEsquerdo;
    }

    public String[] getListaTitulosMenuEsquerdo() {
        return listaTitulosMenuEsquerdo;
    }

    public void setListaTitulosMenuEsquerdo(String[] listaTitulosMenuEsquerdo) {
        this.listaTitulosMenuEsquerdo = listaTitulosMenuEsquerdo;
    }

    public TypedArray getListaIconesMenuEsquerdo() {
        return listaIconesMenuEsquerdo;
    }

    public void setListaIconesMenuEsquerdo(TypedArray listaIconesMenuEsquerdo) {
        this.listaIconesMenuEsquerdo = listaIconesMenuEsquerdo;
    }

    public ListView getListViewMenuEsquerdo() {
        return listViewMenuEsquerdo;
    }

    public void setListViewMenuEsquerdo(ListView listViewMenuEsquerdo) {
        this.listViewMenuEsquerdo = listViewMenuEsquerdo;
    }

}
