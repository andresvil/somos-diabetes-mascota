package com.example.andresvil.mascota;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView botella;
    ImageView corazon;
    ImageView cofre;

    Boolean corazonClicked = false;

    TextView estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        // Set animationDrawable to drawable from imageView
        final AnimationDrawable pulpoAnimado = (AnimationDrawable) imageView.getDrawable();

        // Start animation
        imageView.post(new Runnable() {
            @Override
            public void run() {
                pulpoAnimado.start();
            }
        });

        // Set views
        botella = (ImageView) findViewById(R.id.botella);
        corazon = (ImageView) findViewById(R.id.corazon);
        cofre = (ImageView) findViewById(R.id.tesoro);
        estado = (TextView) findViewById(R.id.estadoTV);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void verEstado(View view)
    {
        // if corazon has not been clicked
        if(!corazonClicked) {
            corazon.setColorFilter(Color.argb(255, 179, 24, 34));
            estado.setVisibility(View.VISIBLE);
            corazonClicked = true;
        }

        // if corazon has already been clicked
        else {
            corazon.setColorFilter(Color.argb(255, 0, 0, 0));
            estado.setVisibility(View.INVISIBLE);
            corazonClicked = false;
        }
    }

    public void verBotella(View view)
    {
        corazon.setColorFilter(Color.argb(255, 0, 0, 0));
        estado.setVisibility(View.INVISIBLE);
        corazonClicked = false;
    }
}
