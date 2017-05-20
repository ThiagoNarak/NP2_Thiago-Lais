package com.example.thiago.alunomapa;

/**
 * Created by toliveira on 18/04/17.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public  class Banco extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Banco.db";
    private static final String TABLE_DICIPLINAS = "diciplinas";
    private static final String TABLE_CADASTRO = "cadastro";
    //private static final String TABLE_RANKING = "ranking";

    private static final int DATABASE_VERSION = 1;

    // Criando as TAGS para imprimir o Log de cada operação
    private static final String TAG_D = "DELETAR REGISTRO";
    private static final String TAG_I = "INSERIR REGISTRO";
    private static final String TAG_S = "SELECIONAR REGISTROS";

    public Banco(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql_questao = "CREATE TABLE " + TABLE_DICIPLINAS
                + "(cadeira TEXT, "
                + "horario TEXT, "
                + "bloco TEXT, "
                + "sala INT); ";
        sqLiteDatabase.execSQL(sql_questao);

        String sql_cadastro = "CREATE TABLE " + TABLE_CADASTRO
                +"(matricula TEXT,"
                +"senha TEXT,"
                +"curso TEXT); ";

        sqLiteDatabase.execSQL(sql_cadastro);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public  ArrayList<Matricula> consultaMatricula(){
        ArrayList<Matricula>  matriculaArrayList = new ArrayList<Matricula>();
        String sql = "SELECT * FROM " + TABLE_CADASTRO;
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);

        while (cursor.moveToNext()) {

            Matricula m = new Matricula();

            m.setMatricula(cursor.getString(0));
            m.setSenha(cursor.getString(1));
            m.setCurso(cursor.getString(2));

            matriculaArrayList.add(m);

        }
        return matriculaArrayList;
    }
    public ArrayList<Diciplinas> consultaDiciplinas() {

        ArrayList<Diciplinas> diciplinasArrayList = new ArrayList<Diciplinas>();

        String sql = "SELECT * FROM " + TABLE_DICIPLINAS;

        Cursor cursor = getReadableDatabase().rawQuery(sql, null);

        while (cursor.moveToNext()) {

            Diciplinas d = new Diciplinas();

            d.setNomeCadeira(cursor.getString(0));
            d.setHorario(cursor.getString(1));
            d.setBloco(cursor.getString(2));
            d.setSala(cursor.getInt(3));
            diciplinasArrayList.add(d);


        }

        return diciplinasArrayList;
    }

    public void addMatricula(Matricula m) {

        ContentValues contentValues = new ContentValues();

        contentValues.put("matricula", m.getMatricula());
        contentValues.put("senha", m.getSenha());
        contentValues.put("curso",m.getCurso());




        getWritableDatabase().insert(TABLE_CADASTRO, null, contentValues);


    }
    public Matricula retornarMatriculaBanco(){


        ArrayList<Matricula>listaTemp=consultaMatricula();

        Matricula matricula= new Matricula();
        if(listaTemp.size()!=0) {
            matricula.setMatricula(listaTemp.get(0).getMatricula());
            matricula.setSenha(listaTemp.get(0).getSenha());
        }
            return matricula;
    }


    public void addCadeiras(Diciplinas d) {

        ContentValues contentValues = new ContentValues();

        contentValues.put("cadeira", d.getNomeCadeira());
        contentValues.put("horario", d.getHorario());
        contentValues.put("bloco", d.getBloco());
        contentValues.put("sala", d.getSala());



        getWritableDatabase().insert(TABLE_DICIPLINAS, null, contentValues);


    }
    public void delete(){
      getWritableDatabase().delete(TABLE_DICIPLINAS,null,null);
        getWritableDatabase().delete(TABLE_CADASTRO,null,null);

    }
    public void deleteDiciplina( String cadeira){

        SQLiteDatabase db = this.getReadableDatabase();

        db.execSQL("DELETE FROM diciplinas WHERE cadeira = '"+cadeira+"';");


    }

}

