package com.cgg.flux;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class Geral extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageButton music,bott1,bott2,bott3,bott4;
    TextView timer;
    boolean Click1 = false;
    boolean Click = false;
    MediaPlayer rap,rock,eletro;
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        music = (ImageButton) findViewById(R.id.som);
        bott1 = (ImageButton) findViewById(R.id.But1);
        bott2 = (ImageButton) findViewById(R.id.But2);
        bott3 = (ImageButton) findViewById(R.id.But3);
        bott4 = (ImageButton) findViewById(R.id.But4);
        timer = (TextView) findViewById(R.id.timer);
        rap = MediaPlayer.create(this,R.raw.dresnoop);
        rock = MediaPlayer.create(this,R.raw.jeremy);
        eletro = MediaPlayer.create(this,R.raw.playhard);


        timer.setText("00:00:45");

        final CounterClass ti = new CounterClass(46000,1000, timer);
        ti.start();

        music.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){

                if(Click  == false){
                    music.setBackgroundResource(R.mipmap.oie_transparentnots);
                    Click = true;
                    rap.pause();
                    rock.pause();
                    eletro.pause();
                }
                else {
                    music.setBackgroundResource(R.mipmap.oie_transparent2);
                    Click = false;
                }
            }
        });

        bott1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                if(Click1  == false){
                    //bott1.setBackgroundColor(Color.RED);
                    Click1 = true;
                    boolean diag = exemplo_simples(1);
                    //startFourthActivity();
                }
                else {
                    // bott1.setBackgroundColor(Color.BLUE);
                    Click1 = false;
                }
            }
        });

        bott2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if (Click1 == false) {
                    // bott2.setBackgroundColor(Color.LTGRAY);
                    exemplo_simples(2);
                    Click1 = true;
                } else {
                    // bott2.setBackgroundColor(Color.CYAN);
                    Click1 = false;
                }
            }
        });
        bott3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if (Click1 == false) {
                    //bott3.setBackgroundColor(Color.MAGENTA);
                    exemplo_simples(3);
                    Click1 = true;
                } else {
                    //bott3.setBackgroundColor(Color.GRAY);
                    Click1 = false;
                }
            }
        });
        bott4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if (Click1 == false) {
                    // bott4.setBackgroundColor(Color.GREEN);
                    Click1 = true;
                } else {
                    //bott4.setBackgroundColor(Color.BLACK);
                    Click1 = false;
                }
            }
        });

    }


    protected void onPause(){
        super.onPause();
        rap.release();
        rock.release();
        eletro.release();
    }

    public void startFourthActivity() {

        Intent fourthActivity = new Intent(this, Chat.class);
        startActivity(fourthActivity);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            startFourthActivity();
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private boolean exemplo_simples(final int opc) {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Ligar Rádio?");
        builder.setMessage("Tocar tipo de música favorita?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                //Toast.makeText(MainActivity.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
                if (opc == 1) rap.start();
                else if (opc == 2) eletro.start();
                else rock.start();
                //Intent i = new Intent(this,Principal.class);
                //startActivity(i);
                // animationActivity();
                overridePendingTransition(R.anim.transicao, R.anim.transicao2);

            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                //Toast.makeText(MainActivity.this, "negativo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });
        alerta = builder.create();
        alerta.show();

        return true;
    }

    public void animationActivity() {

        Intent i= new Intent(this, Principal.class);
        startActivity(i);
    }


}



