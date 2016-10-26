/*
 * MyFragment.java
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

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment extends android.support.v4.app.Fragment {


	@SuppressLint("InflateParams")
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		setHasOptionsMenu(true);
		return inflater.inflate(R.layout.activity_main, null);
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

}
