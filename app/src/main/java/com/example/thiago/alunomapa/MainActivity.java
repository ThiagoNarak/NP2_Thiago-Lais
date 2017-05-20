package com.example.thiago.alunomapa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    //declaracao dos botoes
    private Button buttonLogin;
    private TextView textCadastro; //TEXTO CADASTRAR TELA INICIO
    private EditText matricula;
    private EditText senha;
    private Matricula matriculaBanco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //ACOPLA ESTA CLASSE A INTERFACE ACTIVITY
        try {
            Banco banco = new Banco(this);
            matriculaBanco = banco.retornarMatriculaBanco();
        }catch (Exception e){
            deleteCache(this);

        }
        //atribuicao a botoes

        buttonLogin = (Button)findViewById(R.id.buttonLogin);
        textCadastro= (TextView)findViewById(R.id.textViewCadastrar);
        textCadastro.setText("Click aqui para Cadastrar.");
         textCadastro.setOnClickListener(cadastrar);
        matricula= (EditText)findViewById(R.id.editTextMatriculaLogin) ;
        senha=(EditText)findViewById(R.id.editTextSenhaLogin);

        if(matriculaBanco.getMatricula()!=null) {
            matricula.setText(matriculaBanco.getMatricula());
            senha.setText(matriculaBanco.getSenha());
        }





        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(matricula.getText().toString().equals(matriculaBanco.getMatricula())){
                    if(senha.getText().toString().equals(matriculaBanco.getSenha())){
                        Intent i = new Intent(MainActivity.this,MenuActivity.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(getBaseContext(),"Senha incorreta",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getBaseContext(),"Matricula Inexistente ",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) {}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }

    public View.OnClickListener cadastrar= new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent =new Intent(MainActivity.this,CadastroActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
