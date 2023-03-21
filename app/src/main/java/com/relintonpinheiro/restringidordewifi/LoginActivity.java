package com.relintonpinheiro.restringidordewifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText nomeDeUsuario;
    EditText senhaDeUsuario;
    Button efetuarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nomeDeUsuario = findViewById(R.id.username);
        senhaDeUsuario = findViewById(R.id.password);
        efetuarLogin = findViewById(R.id.loginButton);

        efetuarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nomeDeUsuario.getText().toString().equals("") && senhaDeUsuario.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Os campos 'Nome de Usuário' e 'Senha de Acesso' são obrigatórios", Toast.LENGTH_SHORT).show();
                } else if(nomeDeUsuario.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Favor, Digite o 'Nome de Usuário'", Toast.LENGTH_SHORT).show();
                } else if(senhaDeUsuario.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Favor, Digite a 'Senha de Acesso'", Toast.LENGTH_SHORT).show();
                } else if(nomeDeUsuario.getText().toString().equals("@Admin") && senhaDeUsuario.getText().toString().equals("777")) {
                    Intent menu = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(menu);
                    Toast.makeText(LoginActivity.this, "Bem vindo Administrador :)", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Login incorreto :(", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}