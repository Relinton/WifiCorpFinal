package com.relintonpinheiro.restringidordewifi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.thanosfisherman.wifiutils.WifiUtils;
import com.thanosfisherman.wifiutils.wifiConnect.ConnectionErrorCode;
import com.thanosfisherman.wifiutils.wifiConnect.ConnectionSuccessListener;

import java.util.List;

public class MenuActivity extends AppCompatActivity {
    String novaRede;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        novaRede = "Pinheiro";
    }
    public void ScanearRedes(View view)
    {
        Intent redes = new Intent(MenuActivity.this, MainActivity.class);
        startActivity(redes);
        Toast.makeText(this, "Lista de Redes", Toast.LENGTH_LONG).show();
    }
    public void AdicionarRede(View view)
    {
        Intent adicionarRedeIntent = new Intent(MenuActivity.this, AdicionarRedeActivity.class);
        startActivity(adicionarRedeIntent);
    }
    public void AtivarWifi(View view)
    {
        WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifi.setWifiEnabled(true);
        Toast.makeText(this, "Wifi Ativado com sucesso", Toast.LENGTH_LONG).show();
    }
    public void DesativarWifi(View view)
    {
        WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifi.setWifiEnabled(false);
        Toast.makeText(this, "Wifi Desativado com sucesso", Toast.LENGTH_LONG).show();
    }
}