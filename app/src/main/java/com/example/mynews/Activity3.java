package com.example.mynews;

import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;




// НЕ РАБОТАЕТ.




public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

    }

    public class ParseText extends AsyncTask<String, Void, String> {

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
}
