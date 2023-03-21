package com.relintonpinheiro.restringidordewifi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thanosfisherman.wifiutils.WifiUtils;
import com.thanosfisherman.wifiutils.wifiConnect.ConnectionErrorCode;
import com.thanosfisherman.wifiutils.wifiConnect.ConnectionSuccessListener;

public class AdicionarRedeActivity extends AppCompatActivity {

    EditText ssid, password;
    Button adicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_rede);

        ssid = findViewById(R.id.editSSID);
        password = findViewById(R.id.editChavePwa);
        adicionar = findViewById(R.id.btnAdicionarRede);
    }

    public void AdicionarRedeWifi(View view){
        if(ssid.getText().toString().equals("") && password.getText().toString().equals("")) {
            Toast.makeText(AdicionarRedeActivity.this, "Os campos 'SSID' e 'Chave WPA' são obrigatórios", Toast.LENGTH_SHORT).show();
        }else if(ssid.getText().toString().equals("")) {
            Toast.makeText(AdicionarRedeActivity.this, "Favor, Digite o 'SSID' da Rede", Toast.LENGTH_SHORT).show();
        }else if(password.getText().toString().equals("")){
            Toast.makeText(AdicionarRedeActivity.this, "Favor, Digite a 'Chave WPA' da Rede", Toast.LENGTH_SHORT).show();
        }else{
            WifiUtils.withContext(getApplicationContext())
                    .connectWith(ssid.getText().toString(), password.getText().toString())
                    .setTimeout(40000)
                    .onConnectionResult(new ConnectionSuccessListener() {
                        @Override
                        public void success() {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(AdicionarRedeActivity.this);
                            dialog.setCancelable(false);
                            dialog.setTitle("Mensagem");
                            dialog.setMessage("Você se conectou com sucesso na Rede " + ssid.getText().toString() );
                            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent irParaMenu = new Intent(AdicionarRedeActivity.this, MenuActivity.class);
                                    startActivity(irParaMenu);
                                }
                            });
                            final AlertDialog alert = dialog.create();
                            alert.show();
                        }

                        @Override
                        public void failed(@NonNull ConnectionErrorCode errorCode) {
                            Toast.makeText(AdicionarRedeActivity.this, "Falha ao conectar " + errorCode.toString(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .start();
        }
    }
}