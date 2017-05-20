package com.example.thiago.alunomapa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

import javax.xml.validation.Validator;

public class DiciplinasActivity extends AppCompatActivity {
    private int status;
    private ArrayList<Diciplinas> diciplinasArrayList= new ArrayList<>();
    private LinearLayout parentLinearLayout;
    private Button finalizarDiciplinas;
    private EditText cadeira;
    private EditText bloco;
    private EditText horario;
    private ToggleButton salvar;
    private Button adicionar;
    Banco banco = new Banco(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diciplinas);
        parentLinearLayout = (LinearLayout) findViewById(R.id.parent_linear_layout);
        finalizarDiciplinas= (Button)findViewById(R.id.buttonFinalizarDiciplinas);
         adicionar= (Button)findViewById(R.id.add_field_button);

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onAddField(v);

            }
        });

        finalizarDiciplinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DiciplinasActivity.this,MenuActivity.class);


                startActivity(intent);
                finish();

            }
        });



    }
    public void reloadactivity(){
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.field, null);
        // Add the new row before the add field button.
        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
        cadeira=(EditText) rowView.findViewById(R.id.editTextCadeira);
        bloco=(EditText) rowView.findViewById(R.id.editTextBloco);
        horario=(EditText)rowView.findViewById(R.id.editTextHorario);

    }

    public void onAddField(View v) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.field, null);
        // Add the new row before the add field button.
        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
        cadeira=(EditText) rowView.findViewById(R.id.editTextCadeira);
        bloco=(EditText) rowView.findViewById(R.id.editTextBloco);
        horario=(EditText)rowView.findViewById(R.id.editTextHorario);
        final ToggleButton salvar;
        salvar= (ToggleButton)rowView.findViewById(R.id.toggleButtonSalvarCancelar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(salvar.isChecked()==true){
                    if(cadeira.getText().toString().length()==0){
                        cadeira.setError("Escreva o nome da cadeira");
                        salvar.setChecked(false);

                    }else{
                        if(horario.getText().toString().length()==0){

                            horario.setError("Digite o horario Ex: M35AB");
                            salvar.setChecked(false);
                        }else{
                            if((horario.getText().toString().toUpperCase().contains("AB")||
                                    horario.getText().toString().toUpperCase().contains("CD")||
                                    horario.getText().toString().toUpperCase().contains("EF"))&&(
                                    horario.getText().toString().contains("2")||
                                    horario.getText().toString().contains("3")||
                                    horario.getText().toString().contains("4")||
                                    horario.getText().toString().contains("5")||
                                    horario.getText().toString().contains("6")||
                                    horario.getText().toString().contains("7"))&&(
                                    horario.getText().toString().toUpperCase().contains("M")||
                                    horario.getText().toString().toUpperCase().contains("T")||
                                    horario.getText().toString().toUpperCase().contains("N")

                            )){

                                if(bloco.getText().toString().length()==0){
                                    bloco.setError("digite o bloco Ex: D14");
                                    salvar.setChecked(false);

                                }else{
                                    String aux;
                                    int auxInt;
                                    aux=bloco.getText().toString();
                                    if(aux.length()==3){
                                        auxInt= Integer.parseInt(aux.substring(aux.length()-2));

                                    }else {
                                        if(aux.length()==2){
                                            auxInt= Integer.parseInt(aux.substring(aux.length()-1));

                                        }else{
                                            auxInt=00;
                                        }

                                    }
                                    aux=aux.toUpperCase();
                                    aux=aux.substring(0,1);
                                    String auxHorario= horario.getText().toString();
                                    auxHorario=auxHorario.toUpperCase();
                                    //   Toast.makeText(getBaseContext(),auxInt,Toast.LENGTH_LONG).show();
                                    Diciplinas d = new Diciplinas(cadeira.getText().toString(),auxHorario,aux,auxInt);
                                    Toast.makeText(getBaseContext(),"Cadeira armazenada com SUCESSO CRITICO!!!",Toast.LENGTH_LONG).show();

                                    banco.addCadeiras(d);
                                    diciplinasArrayList.add(d);
                                }
                            }else{
                                horario.setError("Digite o horario Ex: M35AB");
                                salvar.setChecked(false);
                            }

                        }
                    }


                }else{
                    onDelete(v,cadeira);


                }
            }
        });


    }


    public void onDelete(View v,EditText cadeira) {

        
        parentLinearLayout.removeView((View) v.getParent());
        banco.deleteDiciplina(cadeira.getText().toString());


    }
}
