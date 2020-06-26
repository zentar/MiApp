package com.pm.miapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button boton;
    ListView myListView;
    GridView myGridView;
    List<Estacion> estaciones;
    MyAdapter myListAdapter;
    MyAdapter myGridAdapter;
    int layout;

    MenuItem itemListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout=0;


        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myListView=findViewById(R.id.myListView);
        myGridView=findViewById(R.id.myGridView);

        estaciones=getAllEstaciones();

        //ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        //myListAdapter=new MyAdapter(this,R.layout.item_list,estaciones);
        //myListView.setAdapter(myListAdapter);
        myListAdapter=new MyAdapter(this,R.layout.item_list,estaciones);
        myListView.setAdapter(myListAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Has pulsado el item: "+estaciones.get(position).getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

        myGridAdapter=new MyAdapter(this,R.layout.item_grid,estaciones);
        myGridView.setAdapter(myGridAdapter);

        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Has pulsado el item: "+estaciones.get(position).getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

        registerForContextMenu(myListView);
        registerForContextMenu(myGridView);

        boton=findViewById(R.id.miBoton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Intercambiar el Layout List-Grid
                if(layout==0){
                    myListView.setVisibility(View.INVISIBLE);
                    myGridView.setVisibility(View.VISIBLE);
                    layout=1;
                }
                else{
                    myListView.setVisibility(View.VISIBLE);
                    myGridView.setVisibility(View.INVISIBLE);
                    layout=0;
                }

            }
        });




    }

    public void miMetodo(View v) {
        Toast.makeText(this,"Has pulsado el botón",Toast.LENGTH_SHORT).show();
    }

    //Funciones para CRUD clase
    public List<Estacion> getAllEstaciones(){
        estaciones = new ArrayList<Estacion>();
        estaciones.add(new Estacion("Estacion 1", "Anterior1","Siguiente1",R.drawable.ic_primera_estacion));
        estaciones.add(new Estacion("Estacion 2", "Anterior2","Siguiente2",R.drawable.ic_estacion_segunda));
        estaciones.add(new Estacion("Estacion 3", "Anterior3","Siguiente3",R.drawable.ic_estacion_tercera));
        estaciones.add(new Estacion("Estacion 4", "Anterior1","Siguiente1",R.drawable.ic_primera_estacion));
        estaciones.add(new Estacion("Estacion 5", "Anterior2","Siguiente2",R.drawable.ic_estacion_segunda));
        estaciones.add(new Estacion("Estacion 6", "Anterior3","Siguiente3",R.drawable.ic_estacion_tercera));
        estaciones.add(new Estacion("Estacion 7", "Anterior1","Siguiente1",R.drawable.ic_primera_estacion));
        estaciones.add(new Estacion("Estacion 8", "Anterior2","Siguiente2",R.drawable.ic_estacion_segunda));
        estaciones.add(new Estacion("Estacion 9", "Anterior3","Siguiente3",R.drawable.ic_estacion_tercera));
        estaciones.add(new Estacion("Estacion 10", "Anterior1","Siguiente1",R.drawable.ic_primera_estacion));
        estaciones.add(new Estacion("Estacion 11", "Anterior2","Siguiente2",R.drawable.ic_estacion_segunda));
        estaciones.add(new Estacion("Estacion 12", "Anterior3","Siguiente3",R.drawable.ic_estacion_tercera));
        estaciones.add(new Estacion("Estacion 13", "Anterior1","Siguiente1",R.drawable.ic_primera_estacion));
        estaciones.add(new Estacion("Estacion 14", "Anterior2","Siguiente2",R.drawable.ic_estacion_segunda));
        estaciones.add(new Estacion("Estacion 15", "Anterior3","Siguiente3",R.drawable.ic_estacion_tercera));
        estaciones.add(new Estacion("Estacion 16", "Anterior1","Siguiente1",R.drawable.ic_primera_estacion));
        estaciones.add(new Estacion("Estacion 17", "Anterior2","Siguiente2",R.drawable.ic_estacion_segunda));
        estaciones.add(new Estacion("Estacion 18", "Anterior3","Siguiente3",R.drawable.ic_estacion_tercera));
        estaciones.add(new Estacion("Estacion 19", "Anterior1","Siguiente1",R.drawable.ic_primera_estacion));
        estaciones.add(new Estacion("Estacion 20", "Anterior2","Siguiente2",R.drawable.ic_estacion_segunda));

        return estaciones;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);

        this.itemListView = menu.findItem(R.id.myTextView);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add_item:
                this.estaciones.add(new Estacion("Nueva estacion", "Anterior3","Siguiente3",R.drawable.ic_estacion_tercera));
                this.myListAdapter.notifyDataSetChanged();
                this.myGridAdapter.notifyDataSetChanged();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        MenuInflater inflater= getMenuInflater();
        menu.setHeaderTitle(this.estaciones.get(info.position).getNombre());
        inflater.inflate(R.menu.context_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.delete:
                this.deleteEstacion(info.position);
                return true;
            case R.id.show:
                //Codigo que necesitemos
                return true;
        }
        return super.onContextItemSelected(item);
    }

    private void deleteEstacion(int position){
        this.estaciones.remove(position);
        this.myListAdapter.notifyDataSetChanged();
        this.myGridAdapter.notifyDataSetChanged();
    }
}
