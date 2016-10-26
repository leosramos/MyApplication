package com.example.voicer03.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.Window;

import java.lang.reflect.Method;


public class MainActivity extends AppCompatActivity  {
	public static final int ACCESS_COARSE_LOCATION = 1;

	public final static String END_SERVIDOR = "http://169.57.142.132";
	
	private static MainActivity mainActivity;
	private MainActivityModel mainActivityModel;

	public static MainActivity getMainActivity() {
		return mainActivity;
	}

	public static void setMainActivity(MainActivity mainActivity) {
		MainActivity.mainActivity = mainActivity;
	}

	private void instanciaVariaveis() {
		setTitle("Main Menu");
		setMainActivity(this);
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//	    }else {
//	    	getActionBar().setDisplayHomeAsUpEnabled(true);
//		}

		getMainActivityModel().instanciaVariaveis();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content_frame);
		setMainActivityModel(new MainActivityModel());
		instanciaVariaveis();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		setMainActivityModel(new MainActivityModel());
		instanciaVariaveis();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
	}
	
	@Override
	public void onBackPressed() {
		moveTaskToBack(true);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}
	
	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		if(featureId == Window.FEATURE_ACTION_BAR && menu != null && menu.getClass().getSimpleName().equals("MenuBuilder")){
            try{
                Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                m.setAccessible(true);
                m.invoke(menu, true);
            } catch(Exception e){
                throw new RuntimeException(e);
            }
	    }
		return super.onMenuOpened(featureId, menu);
	}

	public MainActivityModel getMainActivityModel() {
		return mainActivityModel;
	}

	public void setMainActivityModel(MainActivityModel mainActivityModel) {
		this.mainActivityModel = mainActivityModel;
	}
}