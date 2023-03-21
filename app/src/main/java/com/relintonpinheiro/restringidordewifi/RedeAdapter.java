package com.relintonpinheiro.restringidordewifi;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RedeAdapter extends BaseAdapter {

    private List<Rede> redes;
    private Activity activity;

    public RedeAdapter(List<Rede> redes, Activity activity) {
        this.redes = redes;
        this.activity = activity;
    }


    @Override public int getCount() { return redes.size(); }

    @Override public Object getItem(int position) { return redes.get(position); }

    @Override public long getItemId(int position) { return redes.get(position).getId(); }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.lista_rede_personalizada, parent, false);
        TextView ssid = view.findViewById(R.id.lista_rede_personalizada_ssid);
        Rede rede = redes.get(position);
        ssid.setText(rede.getSsid());

        return view;
    }
}
