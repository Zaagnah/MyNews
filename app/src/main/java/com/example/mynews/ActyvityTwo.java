package com.example.mynews;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.DocumentsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class ActyvityTwo extends Activity  {

    public Elements content;
    public ArrayList<String> titleList = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actyvity_two);

        listView = (ListView) findViewById(R.id.ListView1);
         NewThread newThread = new  NewThread();
         newThread.execute();
        adapter = new ArrayAdapter<String>(this, R.layout.actyvity_two, R.id.pro_item,titleList);


            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ActyvityTwo.this,android.R.layout.simple_list_item_1,titleList);


    }

    /*@Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ListView1:
                Intent intent = new Intent(this,Activity3.class);
                startActivity(intent);
                break;
        }
    }*/


    public class ParseText extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            String str = " ";
            try {
                Document document = Jsoup.connect(strings[0]).get();
                Element element = document.select(".doc__text").first();
                str = element.text();

            } catch (IOException e) {
                e.printStackTrace();
            }


            return str;
        }

    }



    public class NewThread extends AsyncTask<String,Void, String>{
        @Override
        protected  String doInBackground(String...arg){
            Document document;
            try{
                 document= Jsoup.connect("https://yandex.ru/news/").get();
                content = document.select(".story__title");
                titleList.clear();
                for (Element contents: content){
                    titleList.add(contents.text());
                }
            } catch (IOException e){
                e.printStackTrace();
            }
            return  null;
        }
        @Override
        protected  void onPostExecute(String result){

            listView.setAdapter(adapter);
        }
    }



    }

