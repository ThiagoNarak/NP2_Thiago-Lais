package com.example.thiago.alunomapa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MostrarDiciplinasActivity extends AppCompatActivity {
        private ListView cadeira;
        private ListView horario;
        private ListView bloco;
        private ListView sala;
        private ArrayList<String> cadeiraString =new ArrayList<String>();
    private ArrayList<String> horarioString=new ArrayList<String>();
    private ArrayList<String> blocoString=new ArrayList<String>();
    private ArrayList<String> salaString=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_diciplinas);
        Banco b = new Banco(this);
        ArrayList<Diciplinas> diciplinasList= b.consultaDiciplinas();


        cadeira = (ListView) findViewById(R.id.listCadeira);
        bloco = (ListView) findViewById(R.id.listBloco);
        horario = (ListView)findViewById(R.id.listHorario);
        sala = (ListView) findViewById(R.id.listSala);

        //TODO: TERMINAR IMPLEMENTACAO MALDITA QUE NAO SEI COMO FAZER ESSES LIST

        atualizarListaCadeira(diciplinasList,cadeira,horario,bloco,sala);

    }
    public void atualizarListaCadeira(ArrayList<Diciplinas> diciplinas, ListView cadeira,ListView horario,ListView bloco,ListView sala){

        for (int i = 0; i <diciplinas.size() ; i++) {
            cadeiraString.add(diciplinas.get(i).getNomeCadeira());
           horarioString.add(diciplinas.get(i).getHorario());
           blocoString.add(diciplinas.get(i).getBloco());
           salaString.add(String.valueOf(diciplinas.get(i).getSala()));
        }


        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(MostrarDiciplinasActivity.this, android.R.layout.simple_list_item_1, cadeiraString);
        cadeira.setAdapter(adaptador);
       adaptador = new ArrayAdapter<String>(MostrarDiciplinasActivity.this, android.R.layout.simple_list_item_1, blocoString);
        bloco.setAdapter(adaptador);
        adaptador = new ArrayAdapter<String>(MostrarDiciplinasActivity.this, android.R.layout.simple_list_item_1, horarioString);
        horario.setAdapter(adaptador);
        adaptador = new ArrayAdapter<String>(MostrarDiciplinasActivity.this, android.R.layout.simple_list_item_1, salaString);

        sala.setAdapter(adaptador);


    }






}