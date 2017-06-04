package com.example.thiago.alunomapa;

import android.content.res.Resources;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A basic example of how to use week view library.
 * Created by Raquib-ul-Alam Kanak on 1/3/2014.
 * Website: http://alamkanak.github.io
 */
public class BasicActivity extends BaseActivity {
    //PROFESSORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        // Populate the week view with some events.

        List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();
        // INICIO ENTRADA DE DADOS
        Banco banco = new Banco(this);

        ArrayList<Diciplinas>diciplinasList =banco.consultaDiciplinas();

        for (int i = 0; i <diciplinasList.size() ; i++) {

            for (int j = 0; j < diciplinasList.get(i).getHorario().length(); j++) {

                if(diciplinasList.get(i).getHorario().charAt(j)=='1'||
                        diciplinasList.get(i).getHorario().charAt(j)=='2'||
                        diciplinasList.get(i).getHorario().charAt(j)=='3'||
                        diciplinasList.get(i).getHorario().charAt(j)=='4'||
                        diciplinasList.get(i).getHorario().charAt(j)=='5'||
                        diciplinasList.get(i).getHorario().charAt(j)=='6'||
                        diciplinasList.get(i).getHorario().charAt(j)=='7')  {
                    if(diciplinasList.get(i).getHorario().contains("M")){
                        if(diciplinasList.get(i).getHorario().contains("ABCDEF")){

                            Calendar startTime = Calendar.getInstance();

                            int dayofweek= Integer.parseInt(String.valueOf(diciplinasList.get(i).getHorario().charAt(j)));
                            //START horario
                            startTime.set(Calendar.DAY_OF_WEEK,dayofweek);
                            startTime.set(Calendar.HOUR_OF_DAY,7);
                            startTime.set(Calendar.MINUTE,30);
                            startTime.set(Calendar.MONTH,newMonth-1);
                            startTime.set(Calendar.YEAR, newYear);
                            //END horario
                            Calendar endTime = (Calendar) startTime.clone();
                            endTime.add(Calendar.HOUR_OF_DAY, 5);
                            endTime.add(Calendar.MINUTE, 30);

                            WeekViewEvent event = new WeekViewEvent(1, diciplinasList.get(i).getNomeCadeira()+" Bloco: "+diciplinasList.get(i).getBloco(), startTime, endTime);
                            event.setColor(tratamentoStringHorario(i));
                            events.add(event);





                        }else{
                            if(diciplinasList.get(i).getHorario().contains("ABCD")){
                                Calendar startTime = Calendar.getInstance();

                                int dayofweek= Integer.parseInt(String.valueOf(diciplinasList.get(i).getHorario().charAt(j)));
                                //START horario
                                startTime.set(Calendar.DAY_OF_WEEK,dayofweek);
                                startTime.set(Calendar.HOUR_OF_DAY,7);
                                startTime.set(Calendar.MINUTE,30);
                                startTime.set(Calendar.MONTH,newMonth-1);
                                startTime.set(Calendar.YEAR, newYear);
                                //END horario
                                Calendar endTime = (Calendar) startTime.clone();
                                endTime.add(Calendar.HOUR_OF_DAY, 3);
                                endTime.add(Calendar.MINUTE, 40);

                                WeekViewEvent event = new WeekViewEvent(1, diciplinasList.get(i).getNomeCadeira()+" Bloco: "+diciplinasList.get(i).getBloco(), startTime, endTime);
                                event.setColor(tratamentoStringHorario(i));
                                events.add(event);

                            }else{
                                if(diciplinasList.get(i).getHorario().contains("CDEF")){
                                    Calendar startTime = Calendar.getInstance();

                                    int dayofweek= Integer.parseInt(String.valueOf(diciplinasList.get(i).getHorario().charAt(j)));
                                    //START horario
                                    startTime.set(Calendar.DAY_OF_WEEK,dayofweek);
                                    startTime.set(Calendar.HOUR_OF_DAY,9);
                                    startTime.set(Calendar.MINUTE,30);
                                    startTime.set(Calendar.MONTH,newMonth-1);
                                    startTime.set(Calendar.YEAR, newYear);
                                    //END horario
                                    Calendar endTime = (Calendar) startTime.clone();
                                    endTime.add(Calendar.HOUR_OF_DAY, 3);
                                    endTime.add(Calendar.MINUTE, 30);

                                    WeekViewEvent event = new WeekViewEvent(1, diciplinasList.get(i).getNomeCadeira()+" Bloco: "+diciplinasList.get(i).getBloco(), startTime, endTime);
                                    event.setColor(tratamentoStringHorario(i));
                                    events.add(event);

                                }else{
                                    if(diciplinasList.get(i).getHorario().contains("AB")){
                                        Calendar startTime = Calendar.getInstance();

                                        int dayofweek= Integer.parseInt(String.valueOf(diciplinasList.get(i).getHorario().charAt(j)));
                                        //START horario
                                        startTime.set(Calendar.DAY_OF_WEEK,dayofweek);
                                        startTime.set(Calendar.HOUR_OF_DAY,7);
                                        startTime.set(Calendar.MINUTE,30);
                                        startTime.set(Calendar.MONTH,newMonth-1);
                                        startTime.set(Calendar.YEAR, newYear);
                                        //END horario
                                        Calendar endTime = (Calendar) startTime.clone();
                                        endTime.add(Calendar.HOUR_OF_DAY, 1);
                                        endTime.add(Calendar.MINUTE, 40);

                                        WeekViewEvent event = new WeekViewEvent(1, diciplinasList.get(i).getNomeCadeira()+" Bloco: "+diciplinasList.get(i).getBloco(), startTime, endTime);
                                        event.setColor(tratamentoStringHorario(i));
                                        events.add(event);
                                    }else{
                                        if(diciplinasList.get(i).getHorario().contains("CD")){
                                            Calendar startTime = Calendar.getInstance();

                                            int dayofweek= Integer.parseInt(String.valueOf(diciplinasList.get(i).getHorario().charAt(j)));
                                            //START horario
                                            startTime.set(Calendar.DAY_OF_WEEK,dayofweek);
                                            startTime.set(Calendar.HOUR_OF_DAY,9);
                                            startTime.set(Calendar.MINUTE,30);
                                            startTime.set(Calendar.MONTH,newMonth-1);
                                            startTime.set(Calendar.YEAR, newYear);
                                            //END horario
                                            Calendar endTime = (Calendar) startTime.clone();
                                            endTime.add(Calendar.HOUR_OF_DAY, 1);
                                            endTime.add(Calendar.MINUTE, 40);

                                            WeekViewEvent event = new WeekViewEvent(1, diciplinasList.get(i).getNomeCadeira()+" Bloco: "+diciplinasList.get(i).getBloco(), startTime, endTime);
                                            event.setColor(tratamentoStringHorario(i));
                                            events.add(event);
                                        }else{
                                            if(diciplinasList.get(i).getHorario().contains("EF")){
                                                Calendar startTime = Calendar.getInstance();

                                                int dayofweek= Integer.parseInt(String.valueOf(diciplinasList.get(i).getHorario().charAt(j)));
                                                //START horario
                                                startTime.set(Calendar.DAY_OF_WEEK,dayofweek);
                                                startTime.set(Calendar.HOUR_OF_DAY,11);
                                                startTime.set(Calendar.MINUTE,20);
                                                startTime.set(Calendar.MONTH,newMonth-1);
                                                startTime.set(Calendar.YEAR, newYear);
                                                //END horario
                                                Calendar endTime = (Calendar) startTime.clone();
                                                endTime.add(Calendar.HOUR_OF_DAY, 1);
                                                endTime.add(Calendar.MINUTE, 40);

                                                WeekViewEvent event = new WeekViewEvent(1, diciplinasList.get(i).getNomeCadeira()+" Bloco: "+diciplinasList.get(i).getBloco(), startTime, endTime);
                                                event.setColor(tratamentoStringHorario(i));
                                                events.add(event);
                                            }


                                        }
                                    }
                                }
                            }
                        }

                    }else{
                        if(diciplinasList.get(i).getHorario().contains("T")){
                            if(diciplinasList.get(i).getHorario().contains("ABCDEF")){

                                Calendar startTime = Calendar.getInstance();

                                int dayofweek= Integer.parseInt(String.valueOf(diciplinasList.get(i).getHorario().charAt(j)));
                                //START horario
                                startTime.set(Calendar.DAY_OF_WEEK,dayofweek);
                                startTime.set(Calendar.HOUR_OF_DAY,13);
                                startTime.set(Calendar.MINUTE,30);
                                startTime.set(Calendar.MONTH,newMonth-1);
                                startTime.set(Calendar.YEAR, newYear);
                                //END horario
                                Calendar endTime = (Calendar) startTime.clone();
                                endTime.add(Calendar.HOUR_OF_DAY, 5);
                                endTime.add(Calendar.MINUTE, 30);

                                WeekViewEvent event = new WeekViewEvent(1, diciplinasList.get(i).getNomeCadeira()+" Bloco: "+diciplinasList.get(i).getBloco(), startTime, endTime);
                                event.setColor(tratamentoStringHorario(i));
                                events.add(event);





                            }else{
                                if(diciplinasList.get(i).getHorario().contains("ABCD")){
                                    Calendar startTime = Calendar.getInstance();

                                    int dayofweek= Integer.parseInt(String.valueOf(diciplinasList.get(i).getHorario().charAt(j)));
                                    //START horario
                                    startTime.set(Calendar.DAY_OF_WEEK,dayofweek);
                                    startTime.set(Calendar.HOUR_OF_DAY,13);
                                    startTime.set(Calendar.MINUTE,30);
                                    startTime.set(Calendar.MONTH,newMonth-1);
                                    startTime.set(Calendar.YEAR, newYear);
                                    //END horario
                                    Calendar endTime = (Calendar) startTime.clone();
                                    endTime.add(Calendar.HOUR_OF_DAY, 3);
                                    endTime.add(Calendar.MINUTE, 40);

                                    WeekViewEvent event = new WeekViewEvent(1, diciplinasList.get(i).getNomeCadeira()+" Bloco: "+diciplinasList.get(i).getBloco(), startTime, endTime);
                                    event.setColor(tratamentoStringHorario(i));
                                    events.add(event);

                                }else{
                                    if(diciplinasList.get(i).getHorario().contains("CDEF")){
                                        Calendar startTime = Calendar.getInstance();

                                        int dayofweek= Integer.parseInt(String.valueOf(diciplinasList.get(i).getHorario().charAt(j)));
                                        //START horario
                                        startTime.set(Calendar.DAY_OF_WEEK,dayofweek);
                                        startTime.set(Calendar.HOUR_OF_DAY,15);
                                        startTime.set(Calendar.MINUTE,30);
                                        startTime.set(Calendar.MONTH,newMonth-1);
                                        startTime.set(Calendar.YEAR, newYear);
                                        //END horario
                                        Calendar endTime = (Calendar) startTime.clone();
                                        endTime.add(Calendar.HOUR_OF_DAY, 3);
                                        endTime.add(Calendar.MINUTE, 30);

                                        WeekViewEvent event = new WeekViewEvent(1, diciplinasList.get(i).getNomeCadeira()+" Bloco: "+diciplinasList.get(i).getBloco(), startTime, endTime);
                                        event.setColor(tratamentoStringHorario(i));
                                        events.add(event);

                                    }else{
                                        if(diciplinasList.get(i).getHorario().contains("AB")){
                                            Calendar startTime = Calendar.getInstance();

                                            int dayofweek= Integer.parseInt(String.valueOf(diciplinasList.get(i).getHorario().charAt(j)));
                                            //START horario
                                            startTime.set(Calendar.DAY_OF_WEEK,dayofweek);
                                            startTime.set(Calendar.HOUR_OF_DAY,13);
                                            startTime.set(Calendar.MINUTE,30);
                                            startTime.set(Calendar.MONTH,newMonth-1);
                                            startTime.set(Calendar.YEAR, newYear);
                                            //END horario
                                            Calendar endTime = (Calendar) startTime.clone();
                                            endTime.add(Calendar.HOUR_OF_DAY, 1);
                                            endTime.add(Calendar.MINUTE, 40);

                                            WeekViewEvent event = new WeekViewEvent(1, diciplinasList.get(i).getNomeCadeira()+" Bloco: "+diciplinasList.get(i).getBloco(), startTime, endTime);
                                            event.setColor(tratamentoStringHorario(i));
                                            events.add(event);
                                        }else{
                                            if(diciplinasList.get(i).getHorario().contains("CD")){
                                                Calendar startTime = Calendar.getInstance();

                                                int dayofweek= Integer.parseInt(String.valueOf(diciplinasList.get(i).getHorario().charAt(j)));
                                                //START horario
                                                startTime.set(Calendar.DAY_OF_WEEK,dayofweek);
                                                startTime.set(Calendar.HOUR_OF_DAY,15);
                                                startTime.set(Calendar.MINUTE,30);
                                                startTime.set(Calendar.MONTH,newMonth-1);
                                                startTime.set(Calendar.YEAR, newYear);
                                                //END horario
                                                Calendar endTime = (Calendar) startTime.clone();
                                                endTime.add(Calendar.HOUR_OF_DAY, 1);
                                                endTime.add(Calendar.MINUTE, 40);

                                                WeekViewEvent event = new WeekViewEvent(1, diciplinasList.get(i).getNomeCadeira()+" Bloco: "+diciplinasList.get(i).getBloco(), startTime, endTime);
                                                event.setColor(tratamentoStringHorario(i));
                                                events.add(event);
                                            }else{
                                                if(diciplinasList.get(i).getHorario().contains("EF")){
                                                    Calendar startTime = Calendar.getInstance();

                                                    int dayofweek= Integer.parseInt(String.valueOf(diciplinasList.get(i).getHorario().charAt(j)));
                                                    //START horario
                                                    startTime.set(Calendar.DAY_OF_WEEK,dayofweek);
                                                    startTime.set(Calendar.HOUR_OF_DAY,17);
                                                    startTime.set(Calendar.MINUTE,20);
                                                    startTime.set(Calendar.MONTH,newMonth-1);
                                                    startTime.set(Calendar.YEAR, newYear);
                                                    //END horario
                                                    Calendar endTime = (Calendar) startTime.clone();
                                                    endTime.add(Calendar.HOUR_OF_DAY, 1);
                                                    endTime.add(Calendar.MINUTE, 40);

                                                    WeekViewEvent event = new WeekViewEvent(1, diciplinasList.get(i).getNomeCadeira()+" Bloco: "+diciplinasList.get(i).getBloco(), startTime, endTime);
                                                    event.setColor(tratamentoStringHorario(i));
                                                    events.add(event);
                                                }


                                            }
                                        }
                                    }
                                }
                            }

                        }else{
                            if(diciplinasList.get(i).getHorario().contains("N")){

                                if(diciplinasList.get(i).getHorario().contains("ABCD")){
                                    Calendar startTime = Calendar.getInstance();

                                    int dayofweek= Integer.parseInt(String.valueOf(diciplinasList.get(i).getHorario().charAt(j)));
                                    //START horario
                                    startTime.set(Calendar.DAY_OF_WEEK,dayofweek);
                                    startTime.set(Calendar.HOUR_OF_DAY,19);
                                    startTime.set(Calendar.MINUTE,0);
                                    startTime.set(Calendar.MONTH,newMonth-1);
                                    startTime.set(Calendar.YEAR, newYear);
                                    //END horario
                                    Calendar endTime = (Calendar) startTime.clone();
                                    endTime.add(Calendar.HOUR_OF_DAY, 3);
                                    endTime.add(Calendar.MINUTE, 40);

                                    WeekViewEvent event = new WeekViewEvent(1, diciplinasList.get(i).getNomeCadeira()+" Bloco: "+diciplinasList.get(i).getBloco(), startTime, endTime);
                                    event.setColor(tratamentoStringHorario(i));
                                    events.add(event);

                                }else{

                                    if(diciplinasList.get(i).getHorario().contains("AB")){
                                        Calendar startTime = Calendar.getInstance();

                                        int dayofweek= Integer.parseInt(String.valueOf(diciplinasList.get(i).getHorario().charAt(j)));
                                        //START horario
                                        startTime.set(Calendar.DAY_OF_WEEK,dayofweek);
                                        startTime.set(Calendar.HOUR_OF_DAY,19);
                                        startTime.set(Calendar.MINUTE,0);
                                        startTime.set(Calendar.MONTH,newMonth-1);
                                        startTime.set(Calendar.YEAR, newYear);
                                        //END horario
                                        Calendar endTime = (Calendar) startTime.clone();
                                        endTime.add(Calendar.HOUR_OF_DAY, 1);
                                        endTime.add(Calendar.MINUTE, 40);

                                        WeekViewEvent event = new WeekViewEvent(1, diciplinasList.get(i).getNomeCadeira()+" Bloco: "+diciplinasList.get(i).getBloco(), startTime, endTime);
                                        event.setColor(tratamentoStringHorario(i));
                                        events.add(event);
                                    }else{
                                        if(diciplinasList.get(i).getHorario().contains("CD")){
                                            Calendar startTime = Calendar.getInstance();

                                            int dayofweek= Integer.parseInt(String.valueOf(diciplinasList.get(i).getHorario().charAt(j)));
                                            //START horario
                                            startTime.set(Calendar.DAY_OF_WEEK,dayofweek);
                                            startTime.set(Calendar.HOUR_OF_DAY,21);
                                            startTime.set(Calendar.MINUTE,00);
                                            startTime.set(Calendar.MONTH,newMonth-1);
                                            startTime.set(Calendar.YEAR, newYear);
                                            //END horario
                                            Calendar endTime = (Calendar) startTime.clone();
                                            endTime.add(Calendar.HOUR_OF_DAY, 1);
                                            endTime.add(Calendar.MINUTE, 40);

                                            WeekViewEvent event = new WeekViewEvent(1, diciplinasList.get(i).getNomeCadeira()+" Bloco: "+diciplinasList.get(i).getBloco(), startTime, endTime);
                                            event.setColor(tratamentoStringHorario(i));
                                            events.add(event);
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }





        }








        return events;
    }
    public int tratamentoStringHorario(int i){
        if(i==0){
            return (getResources().getColor(R.color.event_color_01));

        }else{
            if(i==1){
                //  return getResources().getColor(R.color.event_color_02);
                return (getResources().getColor(R.color.event_color_02));
            }else{
                if(i==2){
                    return  (getResources().getColor(R.color.event_color_03));
                }else{
                    if(i==3){
                        return (getResources().getColor(R.color.event_color_04));
                    }else{
                        if(i==4){
                            return (getResources().getColor(R.color.event_color_05));
                        }else{
                            if(i==5){
                                return (getResources().getColor(R.color.event_color_06));
                            }else{
                                if(i==6){
                                    return (getResources().getColor(R.color.event_color_07));

                                }else{
                                    if(i==7){
                                        return (getResources().getColor(R.color.event_color_08));

                                    }else{
                                        return 0;
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
