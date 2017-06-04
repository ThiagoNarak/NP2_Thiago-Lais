package com.example.thiago.alunomapa;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SobreActivity extends AppCompatActivity {
    private ImageView vaderimg;

    private ImageView coracao;
    private TextView lais;
    private int numero=0;
    private int numero2=0;
    private TextView laisAparecer;
    private TextView thiagoAparecer;
    private TextView laisDesaparecer;
    private TextView thiagoDesaparecer;
    private TextView darth;
    private MediaPlayer vadermusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        laisDesaparecer=(TextView)findViewById(R.id.textViewLais);
        laisAparecer=(TextView)findViewById(R.id.textViewLaisAparecer) ;
        thiagoDesaparecer=(TextView)findViewById(R.id.TextViewThiago);
        thiagoAparecer=(TextView)findViewById(R.id.textViewThiagoAparecer);
        coracao = (ImageView)findViewById(R.id.imageViewCoracao1);
        vaderimg=(ImageView)findViewById(R.id.imageViewvader1) ;
        lais= (TextView)findViewById(R.id.textViewLais);
        darth = (TextView)findViewById(R.id.textViewPROF);
        vadermusic = MediaPlayer.create(SobreActivity.this, R.raw.march);
        darth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numero2==0){
                    vaderimg = (ImageView)findViewById(R.id.imageViewvader1);
                    vaderimg.setVisibility(View.VISIBLE);
                    vadermusic.start();
                    numero2++;
                }else{
                    if(numero2==1){
                        vaderimg = (ImageView)findViewById(R.id.imageViewvader1);
                        vaderimg.setVisibility(View.INVISIBLE);
                        vaderimg = (ImageView)findViewById(R.id.imageViewvader2);
                        vaderimg.setVisibility(View.VISIBLE);
                        numero2++;
                    }else{
                        if(numero2==2){
                            vaderimg = (ImageView)findViewById(R.id.imageViewvader2);
                            vaderimg.setVisibility(View.INVISIBLE);
                            vaderimg = (ImageView)findViewById(R.id.imageViewvader3);
                            vaderimg.setVisibility(View.VISIBLE);
                            numero2++;
                        }else{
                            if(numero2==3){
                                vaderimg = (ImageView)findViewById(R.id.imageViewvader3);
                                vaderimg.setVisibility(View.INVISIBLE);
                                vaderimg = (ImageView)findViewById(R.id.imageViewvader4);
                                vaderimg.setVisibility(View.VISIBLE);
                                numero2++;
                            }else{
                                if(numero2==4){
                                    vaderimg = (ImageView)findViewById(R.id.imageViewvader4);
                                    vaderimg.setVisibility(View.INVISIBLE);
                                    vaderimg = (ImageView)findViewById(R.id.imageViewvader5);
                                    vaderimg.setVisibility(View.VISIBLE);
                                    numero2++;

                                }else{
                                    if(numero2==5){
                                        vaderimg = (ImageView)findViewById(R.id.imageViewvader5);
                                        vaderimg.setVisibility(View.INVISIBLE);
                                        vaderimg = (ImageView)findViewById(R.id.imageViewvader6);
                                        vaderimg.setVisibility(View.VISIBLE);
                                        numero2++;
                                    }else{
                                        if(numero2==6){
                                            vaderimg = (ImageView)findViewById(R.id.imageViewvader6);
                                            vaderimg.setVisibility(View.INVISIBLE);
                                            vaderimg = (ImageView)findViewById(R.id.imageViewvader7);
                                            vaderimg.setVisibility(View.VISIBLE);
                                            numero2++;
                                        }else{
                                            if(numero2==7){
                                                vaderimg = (ImageView)findViewById(R.id.imageViewvader7);
                                                vaderimg.setVisibility(View.INVISIBLE);
                                                vaderimg = (ImageView)findViewById(R.id.imageViewvader8);
                                                vaderimg.setVisibility(View.VISIBLE);
                                                numero2++;
                                            }else{
                                                if(numero2==8){
                                                    vaderimg = (ImageView)findViewById(R.id.imageViewvader8);
                                                    vaderimg.setVisibility(View.INVISIBLE);
                                                    vaderimg = (ImageView)findViewById(R.id.imageViewvader9);
                                                    vaderimg.setVisibility(View.VISIBLE);
                                                    numero2++;
                                                }else{
                                                    if(numero2==9){
                                                        vaderimg = (ImageView)findViewById(R.id.imageViewvader9);
                                                        vaderimg.setVisibility(View.INVISIBLE);
                                                        vaderimg = (ImageView)findViewById(R.id.imageViewvader10);
                                                        vaderimg.setVisibility(View.VISIBLE);
                                                        numero2++;
                                                    }else{
                                                        if(numero2==10){
                                                            vaderimg = (ImageView)findViewById(R.id.imageViewvader10);
                                                            vaderimg.setVisibility(View.INVISIBLE);
                                                            vaderimg = (ImageView)findViewById(R.id.imageViewvader11);
                                                            vaderimg.setVisibility(View.VISIBLE);
                                                            numero2++;
                                                            darth.setText("Prof. Lord Vader");
                                                        }else{

                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }




        });


        lais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numero==0){
                    coracao = (ImageView)findViewById(R.id.imageViewCoracao1);
                    coracao.setVisibility(View.VISIBLE);
                    numero++;
                }else{
                    if(numero==1){
                        coracao = (ImageView)findViewById(R.id.imageViewCoracao1);
                        coracao.setVisibility(View.INVISIBLE);
                        coracao = (ImageView)findViewById(R.id.imageViewCoracao2);
                        coracao.setVisibility(View.VISIBLE);
                        numero++;
                    }else{
                        if(numero==2){
                            coracao = (ImageView)findViewById(R.id.imageViewCoracao2);
                            coracao.setVisibility(View.INVISIBLE);
                            coracao = (ImageView)findViewById(R.id.imageViewCoracao3);
                            coracao.setVisibility(View.VISIBLE);
                            numero++;
                        }else{
                            if(numero==3){
                                coracao = (ImageView)findViewById(R.id.imageViewCoracao3);
                                coracao.setVisibility(View.INVISIBLE);
                                coracao = (ImageView)findViewById(R.id.imageViewCoracao4);
                                coracao.setVisibility(View.VISIBLE);
                                numero++;
                            }else{
                                if(numero==4){
                                    coracao = (ImageView)findViewById(R.id.imageViewCoracao4);
                                    coracao.setVisibility(View.INVISIBLE);
                                    coracao = (ImageView)findViewById(R.id.imageViewCoracao5);
                                    coracao.setVisibility(View.VISIBLE);
                                    numero++;

                                }else{
                                    if(numero==5){
                                        coracao = (ImageView)findViewById(R.id.imageViewCoracao5);
                                        coracao.setVisibility(View.INVISIBLE);
                                        coracao = (ImageView)findViewById(R.id.imageViewCoracao6);
                                        coracao.setVisibility(View.VISIBLE);
                                        numero++;
                                    }else{
                                        if(numero==6){
                                            coracao = (ImageView)findViewById(R.id.imageViewCoracao6);
                                            coracao.setVisibility(View.INVISIBLE);
                                            coracao = (ImageView)findViewById(R.id.imageViewCoracao7);
                                            coracao.setVisibility(View.VISIBLE);
                                            numero++;
                                        }else{
                                            if(numero==7){
                                                coracao = (ImageView)findViewById(R.id.imageViewCoracao7);
                                                coracao.setVisibility(View.INVISIBLE);
                                                coracao = (ImageView)findViewById(R.id.imageViewCoracao8);
                                                coracao.setVisibility(View.VISIBLE);
                                                numero++;
                                            }else{
                                                if(numero==8){
                                                    coracao = (ImageView)findViewById(R.id.imageViewCoracao8);
                                                    coracao.setVisibility(View.INVISIBLE);
                                                    coracao = (ImageView)findViewById(R.id.imageViewCoracao9);
                                                    coracao.setVisibility(View.VISIBLE);
                                                    numero++;
                                                }else{
                                                    if(numero==9){
                                                        coracao = (ImageView)findViewById(R.id.imageViewCoracao9);
                                                        coracao.setVisibility(View.INVISIBLE);
                                                        coracao = (ImageView)findViewById(R.id.imageViewCoracao10);
                                                        coracao.setVisibility(View.VISIBLE);
                                                        numero++;
                                                    }else{
                                                        if(numero==10){
                                                            coracao = (ImageView)findViewById(R.id.imageViewCoracao10);
                                                            coracao.setVisibility(View.INVISIBLE);
                                                            numero++;
                                                        }else{
                                                            if(numero==11){
                                                                thiagoDesaparecer.setVisibility(View.INVISIBLE);
                                                                laisDesaparecer.setVisibility(View.INVISIBLE);
                                                                thiagoAparecer.setVisibility(View.VISIBLE);
                                                                laisAparecer.setVisibility(View.VISIBLE);
                                                                coracao=(ImageView)findViewById(R.id.imageViewcoracaofinal);
                                                                coracao.setVisibility(View.VISIBLE);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });






    }
}
