package com.example.thiago.alunomapa;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DiciplinasActivityDelete extends AppCompatActivity {
    private int status;
    private ArrayList<Diciplinas> diciplinasArrayList= new ArrayList<>();
    private LinearLayout parentLinearLayout;
    private Button finalizarDiciplinas;
    private TextView cadeira;
    private String []cadeirastring = new String[10];
    private TextView bloco;
    private TextView horario;
    private ImageView deletar;
    Banco banco = new Banco(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diciplinasdeletar);
        parentLinearLayout = (LinearLayout) findViewById(R.id.parent_linear_layout);
        finalizarDiciplinas = (Button) findViewById(R.id.buttonFinalizarDiciplinas);
        diciplinasArrayList = banco.consultaDiciplinas();




         for (int i=0;i<diciplinasArrayList.size();i++) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View[] rowView= new View[10] ;
            rowView[i]=  inflater.inflate(R.layout.fieldcarregado, null);
        // Add the new row before the add field button.

        parentLinearLayout.addView(rowView[i], parentLinearLayout.getChildCount() - 1);
        cadeira = (TextView) rowView[i].findViewById(R.id.textViewCadeiraDeletar);
        bloco = (TextView) rowView[i].findViewById(R.id.textviewBlocoDeletar);
        horario = (TextView) rowView[i].findViewById(R.id.textViewHorarioDeletar);
        deletar = (ImageView) rowView[i].findViewById(R.id.imageViewDeletar);
            cadeira.setText(diciplinasArrayList.get(i).getNomeCadeira());
             cadeirastring[i]=cadeira.getText().toString();
            horario.setText(diciplinasArrayList.get(i).getHorario());
            bloco.setText(diciplinasArrayList.get(i).getBloco());
             final int finalI = i;
             deletar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 banco.deleteDiciplina(cadeirastring[finalI]);
                 parentLinearLayout.removeView((View) v.getParent());

             }
         });
         }
        finalizarDiciplinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DiciplinasActivityDelete.this,MenuActivity.class);


                startActivity(intent);
                finish();

            }
        });

    }

}
