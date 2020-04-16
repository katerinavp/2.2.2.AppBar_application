package com.example.a222androidpetukhova_appbar_application;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private EditText enterTextEdtx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


    }

    private void initView() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
//        enterTextEdtx = findViewById(R.id.enteredText);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_open_notes) {

            Toast.makeText(MainActivity.this, "Открыть записную книжку", Toast.LENGTH_LONG).show();

            Intent intentNotes = new Intent(MainActivity.this, NotesActivity.class);

            startActivity(intentNotes);


        }
        if (id == R.id.action_deadline) {

            Toast.makeText(MainActivity.this, "Открыть сроки задачи", Toast.LENGTH_LONG).show();

            Intent intentNotes = new Intent(MainActivity.this, DeadlineActivity.class);

            startActivity(intentNotes);


        }
        if (id == R.id.action_exit) {
            Toast.makeText(MainActivity.this, "Exiting", Toast.LENGTH_LONG).show();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}


