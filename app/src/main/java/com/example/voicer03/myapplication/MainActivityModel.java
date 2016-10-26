package com.example.voicer03.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityModel {

    private DrawerLayout layoutBaseMenusLaterais;
    private TextView linhaSelecionada;
    private ProgressDialog dialogProgress;
    private MenuItem menuCheckout;
    private MenuItem menuCheckin;
    private Button botaoBuscarRotas;
    private Button botaoModoConsulta;
    private String url;
    private Fragment fragment;
    private static Intent atualizarListaCheckinsService = new Intent("ATUALIZAR_CHECKIN_SERVICE");
    private static Intent checkinService = new Intent("CHECKIN_SERVICE");

    private MenuDireto menuDireitoFragment;
    private MenuEsquerdo menuEsquerdoFragment;

    public void instanciaVariaveis() {
        setFragment((Fragment) MainActivity.getMainActivity().getSupportFragmentManager().findFragmentById(R.id.frag2));
        setLayoutBaseMenusLaterais((DrawerLayout) MainActivity.getMainActivity().findViewById(R.id.drawer_layout));
        setMenuDireitoFragment(new MenuDireto());
        setMenuEsquerdoFragment(new MenuEsquerdo(getFragment()));
        setLinhaSelecionada((TextView) MainActivity.getMainActivity().findViewById(R.id.linhaSelecionada));
    }

    public void limparUrl() {
        setUrl(null);
    }

    public TextView getLinhaSelecionada() {
        return linhaSelecionada;
    }

    public void setLinhaSelecionada(TextView linhaSelecionada) {
        this.linhaSelecionada = linhaSelecionada;
    }

    public ProgressDialog getDialogProgress() {
        return dialogProgress;
    }

    public void setDialogProgress(ProgressDialog progress) {
        this.dialogProgress = progress;
    }

    public MenuItem getMenuCheckout() {
        return menuCheckout;
    }

    public void setMenuCheckout(MenuItem menuCheckout) {
        this.menuCheckout = menuCheckout;
    }

    public MenuItem getMenuCheckin() {
        return menuCheckin;
    }

    public void setMenuCheckin(MenuItem menuCheckin) {
        this.menuCheckin = menuCheckin;
    }

    public Button getBotaoBuscarRotas() {
        return botaoBuscarRotas;
    }

    public void setBotaoBuscarRotas(Button buscarRotas) {
        this.botaoBuscarRotas = buscarRotas;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public DrawerLayout getLayoutBaseMenusLaterais() {
        return layoutBaseMenusLaterais;
    }

    public void setLayoutBaseMenusLaterais(DrawerLayout mDrawerLayout) {
        this.layoutBaseMenusLaterais = mDrawerLayout;
    }

    public MenuDireto getMenuDireitoFragment() {
        return menuDireitoFragment;
    }

    public void setMenuDireitoFragment(MenuDireto menuDireitoFragment) {
        this.menuDireitoFragment = menuDireitoFragment;
    }

    public MenuEsquerdo getMenuEsquerdoFragment() {
        return menuEsquerdoFragment;
    }

    public void setMenuEsquerdoFragment(MenuEsquerdo menuEsquerdoFragment) {
        this.menuEsquerdoFragment = menuEsquerdoFragment;
    }


    public static Intent getAtualizarListaCheckinsService() {
        return atualizarListaCheckinsService;
    }

    public static void setAtualizarListaCheckinsService(Intent atualizarCheckins) {
        MainActivityModel.atualizarListaCheckinsService = atualizarCheckins;
    }

    public static Intent getCheckinService() {
        return checkinService;
    }

    public static void setCheckinService(Intent checkinService) {
        MainActivityModel.checkinService = checkinService;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public Button getBotaoModoConsulta() {
        return botaoModoConsulta;
    }

    public void setBotaoModoConsulta(Button botaoModoConsulta) {
        this.botaoModoConsulta = botaoModoConsulta;
    }


}
