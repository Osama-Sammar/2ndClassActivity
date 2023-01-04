package com.example.a2nd_class_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd;
    private Button btnSaveAll;



    private EditText editTextBookTitle;
    private EditText editTextAuthorName;
    private EditText editTextPages;
    private Switch switchAvaliable;

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;



    public static final String BOOKS = "BOOKS";

    public static List<Book> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
        setupSharedPrefs();
        btnClick();

    }

    private void setUpViews(){
        this.editTextBookTitle = findViewById(R.id.editTextBookTitle);
        this.editTextAuthorName = findViewById(R.id.editTextAuthorName);
        this.editTextPages = findViewById(R.id.editTextPages);
        this.switchAvaliable = findViewById(R.id.switchAvaliable);
        this.btnAdd = findViewById(R.id.buttonAdd);
        this.btnSaveAll = findViewById(R.id.buttonSaveAll);
    }


    private void btnClick() {
        setUpViews();

        this.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookTitle = editTextBookTitle.getText().toString();
                String authorName = editTextAuthorName.getText().toString();
                String pages = editTextPages.getText().toString();
                boolean avaliable = switchAvaliable.isChecked();

                MainActivity.books.add(new Book(bookTitle,authorName,pages,avaliable));
            }
        });

        this.btnSaveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json = objectToJson(MainActivity.books);
                editor.putString(BOOKS,json);
                Toast.makeText(MainActivity.this, json,Toast.LENGTH_SHORT).show();
            }
        });

    }


    private String objectToJson(Object o){
        Gson gson = new Gson();
        return gson.toJson(o);
    }

    private void setupSharedPrefs() {
        this.prefs = PreferenceManager.getDefaultSharedPreferences(this);
        this.editor = prefs.edit();
    }
}