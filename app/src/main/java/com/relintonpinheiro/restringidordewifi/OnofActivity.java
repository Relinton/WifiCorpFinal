package com.relintonpinheiro.restringidordewifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class OnofActivity extends AppCompatActivity {

    Button ativarWifi,desativarWifi;
    String novaRede;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onof);

        ativarWifi=(Button)findViewById(R.id.btnAtivar);
        desativarWifi=(Button)findViewById(R.id.btnDesativar);
        novaRede = "Pinheiro";

        ativarWifi.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

                List<ScanResult> wifiList = wifi.getScanResults();
                for (ScanResult scanResult : wifiList) {
                    if (scanResult.SSID.contains("JOSENILDA 2.4G"))
                    {

                        //WifiConfiguration wc = new WifiConfiguration();
                        //wc.SSID = scanResult.SSID;
                        //int netId = wifi.addNetwork(wc);
                        //boolean wifiEnabled = wifi.enableNetwork(netId, true);
                        //wifi.setWifiEnabled(true);
                        //Toast.makeText(getApplicationContext(), "Adicionado com sucesso" + netId, Toast.LENGTH_SHORT).show();
                        //wifi.setWifiEnabled(true);
                        //wifiList.remove(scanResult.SSID);
                        //wifiList.removeAll(wifi.getScanResults());
                        //wifi.getScanResults().size();
                        WifiConfiguration wc = new WifiConfiguration();
                        wc.SSID = novaRede;
                        wifi.addNetwork(wc);
                    }
                }
            }
        });

        desativarWifi.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(false);
            }
        });
    }
}