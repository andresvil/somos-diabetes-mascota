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
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView botella;
    ImageView corazon;
    ImageView cofre;

    Boolean corazonClicked = false;
    Boolean botellaClicked = false;
    Boolean cofreClicked = false;

    TextView estado;
    ListView reflexionesList;
    ArrayList<String> reflexiones = new ArrayList<>();

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
        reflexionesList = (ListView) findViewById(R.id.reflexionesList);

        reflexiones.add("Aquí está la reflexión que tengo \n" +
                "después de haber completado el reto.");
        reflexiones.add("Aquí está la reflexión que tengo \n" +
                "después de haber completado el reto.");
        reflexiones.add("Aquí está la reflexión que tengo \n" +
                "después de haber completado el reto.");
        reflexiones.add("Aquí está la reflexión que tengo \n" +
                "después de haber completado el reto.");
        reflexiones.add("Aquí está la reflexión que tengo \n" +
                "después de haber completado el reto.");
        reflexiones.add("Aquí está la reflexión que tengo \n" +
                "después de haber completado el reto.");
        reflexiones.add("Aquí está la reflexión que tengo \n" +
                "después de haber completado el reto.");
        reflexiones.add("Aquí está la reflexión que tengo \n" +
                "después de haber completado el reto.");
        reflexiones.add("Aquí está la reflexión que tengo \n" +
                "después de haber completado el reto.");
        reflexiones.add("Aquí está la reflexión que tengo \n" +
                "después de haber completado el reto.");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, reflexiones);
        reflexionesList.setAdapter(adapter);
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

    // asignado al icono de corazón
    public void verEstado(View view)
    {
        // if corazon has not been clicked
        if(!corazonClicked) {
            // botella
            botellaClicked = false;
            reflexionesList.setVisibility(View.INVISIBLE);
            botella.setColorFilter(Color.argb(255, 0, 0, 0));

            // corazón
            corazon.setColorFilter(Color.argb(255, 179, 24, 34));
            estado.setVisibility(View.VISIBLE);
            corazonClicked = true;

            // cofre
            cofreClicked = false;
            cofre.setColorFilter(Color.argb(255, 0, 0, 0));
        }

        // if corazon has already been clicked
        else {
            corazon.setColorFilter(Color.argb(255, 0, 0, 0));
            estado.setVisibility(View.INVISIBLE);
            corazonClicked = false;
        }
    }

    // asignado al icono de botella
    public void verReflexiones(View view)
    {
        // if botella has not been clicked
        if(!botellaClicked) {
            // botella
            botellaClicked = true;
            botella.setColorFilter(Color.argb(255, 179, 24, 34));
            reflexionesList.setVisibility(View.VISIBLE);

            // corazon
            corazon.setColorFilter(Color.argb(255, 0, 0, 0));
            estado.setVisibility(View.INVISIBLE);
            corazonClicked = false;

            // cofre
            cofreClicked = false;
            cofre.setColorFilter(Color.argb(255, 0, 0, 0));
        }

        // if botella has already been clicked
        else {
            botellaClicked = false;
            botella.setColorFilter(Color.argb(255, 0, 0, 0));
            reflexionesList.setVisibility(View.INVISIBLE);
        }
    }

    // asignado al icono de cofre
    public void verItems(View view)
    {
        // if cofre has not been clicked
        if(!cofreClicked) {
            // botella
            botellaClicked = false;
            botella.setColorFilter(Color.argb(255, 0, 0, 0));
            reflexionesList.setVisibility(View.INVISIBLE);

            // corazon
            corazon.setColorFilter(Color.argb(255, 0, 0, 0));
            estado.setVisibility(View.INVISIBLE);
            corazonClicked = false;

            // cofre
            cofreClicked = true;
            cofre.setColorFilter(Color.argb(255, 179, 24, 34));
        }

        // if cofre has already been clicked
        else {
            cofreClicked = false;
            cofre.setColorFilter(Color.argb(255, 0, 0, 0));
        }
    }
}
