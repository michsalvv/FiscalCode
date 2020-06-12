package it.runningexamples.fiscalcode;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


// TODO EXCEPTION

public class Parser {

    private static Context context;
    private static BufferedReader reader;

    public Parser(Context context){
        this.context = context;
    }

    public  List<Comune> parserComuni() {
        List<Comune> comuni = new ArrayList<>();
        String line;

        try {
            reader = new BufferedReader(new InputStreamReader(context.getAssets().open("comuni.csv")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return comuni;
        }
        while (line != null) {
            try {
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                String name = tokenizer.nextToken();
                String province = tokenizer.nextToken();
                String fiscalCode = tokenizer.nextToken();
                Comune comune = new Comune(name, province, fiscalCode);
                comuni.add(comune);
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return comuni;
            }
        }
        return comuni;
    }

    public List<Stato> parserStati(){
        List<Stato> stati = new ArrayList<>();
        String line;

        try {
            reader = new BufferedReader(new InputStreamReader(context.getAssets().open("stati_esteri.csv")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return stati;
        }
        while (line != null) {
            try {
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                String codice = tokenizer.nextToken();
                String nome = tokenizer.nextToken();
                Stato stato = new Stato(nome, codice);
                stati.add(stato);
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return stati;
            }
        }
        return stati;
    }


}
