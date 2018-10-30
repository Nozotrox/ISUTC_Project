package Screens;

import java.io.*;
import java.text.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.DateFormat;
import java.util.Date;

public class ClassRelatorio {

    public ClassRelatorio(){
    }

    public String getTime(){
        Date now = new Date();
        DateFormat defaultDf = DateFormat.getTimeInstance();
        return defaultDf.format(now)+"";
    }

    public void salvar_Relatorio(String s) {


        try{
            Vector ls = new Vector();
            ls = ler_Relatorio();

            File f = new File("Relatorio.dat");
            FileWriter fw = new FileWriter(f, false);
            BufferedWriter bw = new BufferedWriter(fw);



            String save = "["+getTime()+"] "+s+";";
            bw.write(save);

            for(int i=0; i<ls.size(); i++){
                bw.newLine();
                bw.write(ls.get(i)+"");
            }
            bw.newLine();

            bw.close();
        }
        catch (Exception ex){
            System.out.println("404 Escrever");
        }


    }

    public Vector<String> ler_Relatorio(){
        Vector ler = new Vector();

        try{
            String txt;
            File f = new File("Relatorio.dat");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            txt = br.readLine();

            while(txt!=null){
                ler.add(txt);
                txt=br.readLine();
            }

            br.close();
        }
        catch(Exception e){
            System.out.println("404 Ler");
        }
        return ler;
    }

}
