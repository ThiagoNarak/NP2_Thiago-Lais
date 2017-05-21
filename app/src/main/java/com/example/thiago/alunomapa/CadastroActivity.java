package com.example.thiago.alunomapa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {
    private Button button;
    private String cursoAux;
    private Spinner diciplinas;   // criando variavel do tipo Spinner
    private int diciplinaNumero;
    private EditText nomeCadastro;
    private EditText matriculaCadastro;
    private EditText senhaCadastro;
    private String curso;
    Banco banco = new Banco(this);
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        System.out.println(item.getItemId());
        switch(item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MenuActivity.class);
                this.startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }


        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        //LINKs entre VARIAVEIS E BOTOES INTERFACE
        button = (Button) findViewById(R.id.buttonCadastrar); // interliga botao cadastrar ao codigo fonte com variavel
        diciplinas = (Spinner) findViewById(R.id.spinnerCursos);// interligando botao spinner ao codigo fonte com variavel
        nomeCadastro = (EditText)findViewById(R.id.editTextNomeCadastro);
        matriculaCadastro = (EditText) findViewById(R.id.editTextMatriculaCadastro);
        senhaCadastro = (EditText)findViewById(R.id.editTextSenhaCadastro);
        //metodo LINK INTENT CADASTRAR
        button.setOnClickListener(cadastrarDiciplinas);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //SPINNER CRIACAO DO VETOR
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.cursos_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diciplinas.setAdapter(adapter);
        diciplinas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                diciplinaNumero=(int)parent.getItemIdAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }

    public View.OnClickListener cadastrarDiciplinas= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Matricula m = new Matricula();
            m.setMatricula(matriculaCadastro.getText().toString());
            m.setSenha(senhaCadastro.getText().toString());
            if(diciplinaNumero==0){
                curso="Ciencia da Computacao";
            }else{
                if(diciplinaNumero==1){
                    curso="Engenharia da Computacao";

                }else{
                    if(diciplinaNumero==2){
                        curso="Analise e Desenvolvimento de Sistemas";

                    }
                }
            }
            m.setCurso(curso);
            banco.addMatricula(m);
            Intent intent =new Intent(CadastroActivity.this,DiciplinasActivity.class);
            intent.putExtra("diciplinaNumero",diciplinaNumero);
            startActivity(intent);
            finish();

        }
    };
}
