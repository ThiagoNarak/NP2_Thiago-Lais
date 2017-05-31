package com.example.thiago.alunomapa;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button mapa;
    private Button matriz;
    private Button lista;
    private Button deleteDatabase;
    private Button cadastrarDiciplinas;
    private Button buttonDrawview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        final Banco b = new Banco(this);
        matriz = (Button) findViewById(R.id.buttonMapaSemanal);
        mapa = (Button) findViewById(R.id.buttonMapaUnifor);
        lista = (Button) findViewById(R.id.buttonMostrarDiciplinas);
        deleteDatabase = (Button) findViewById(R.id.buttonDeletDataBase);
        cadastrarDiciplinas = (Button)findViewById(R.id.buttonCadastrarDiciplinas);
        buttonDrawview = (Button)findViewById(R.id.mainexperimental);


        deleteDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                b.delete();
                                Intent i = new Intent(MenuActivity.this,MainActivity.class);
                                startActivity(i);
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:

                                Intent j = new Intent(MenuActivity.this,DiciplinasActivityDelete.class);
                                startActivity(j);

                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("Voce deseja realmente apagar todos os dados?").setPositiveButton("Sim", dialogClickListener)
                        .setNegativeButton("Nao", dialogClickListener).show();

            }
        });

        buttonDrawview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MenuActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        cadastrarDiciplinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MenuActivity.this,DiciplinasActivity.class);
                startActivity(intent);
            }
        });
        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,MostrarDiciplinasActivity.class);
                startActivity(intent);
            }
        });

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });

        matriz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,BasicActivity.class);
                startActivity(intent);
            }
        });

}

}
