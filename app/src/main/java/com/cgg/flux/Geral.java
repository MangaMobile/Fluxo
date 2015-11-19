package com.cgg.flux;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
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
    TextView timer,perg;
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
        perg = (TextView) findViewById(R.id.text1);

        timer = (TextView) findViewById(R.id.timer);
        rap = MediaPlayer.create(this,R.raw.dresnoop);
        rock = MediaPlayer.create(this,R.raw.jeremy);
        eletro = MediaPlayer.create(this,R.raw.playhard);


        timer.setText("00:00:45");

        final CounterClass ti = new CounterClass(46000,1000, timer);
        ti.start();
        //perg.setText("Cor favorita?");
        int cont = (int)(10*Math.random());
        escolher(cont);
        //bott1.setBackgroundColor(Color.RED);
        //bott2.setBackgroundColor(Color.LTGRAY);
        //bott3.setBackgroundColor(Color.MAGENTA);


        music.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                if (Click == false) {
                    music.setBackgroundResource(R.mipmap.oie_transparentnots);
                    Click = true;
                    rap.pause();
                    rock.pause();
                    eletro.pause();
                } else {
                    music.setBackgroundResource(R.mipmap.oie_transparent2);
                    Click = false;
                }
            }
        });

        bott1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // bott2.setBackgroundColor(Color.LTGRAY);
                animationActivity();
                overridePendingTransition(R.anim.transicao, R.anim.transicao2);
                finish();
            }
        });

        bott2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            // bott2.setBackgroundColor(Color.LTGRAY);
                    animationActivity();
                    overridePendingTransition(R.anim.transicao, R.anim.transicao2);
                finish();


            }
        });
        bott3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                animationActivity();
                overridePendingTransition(R.anim.transicao, R.anim.transicao2);
                finish();

            }
        });
        bott4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                animationActivity();
                overridePendingTransition(R.anim.transicao, R.anim.transicao2);
                finish();

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

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            startFourthActivity();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

   /* private boolean exemplo_simples(final int opc) {
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
    }*/

    public void animationActivity() {

        Intent i= new Intent(this, Geral.class);
        startActivity(i);
    }

    public void escolher(int num){


        if(num == 1 ) {
            perg.setText("Cor favorita?");
            bott1.setBackgroundColor(Color.RED);
            bott2.setBackgroundColor(Color.LTGRAY);
            bott3.setBackgroundColor(Color.MAGENTA);
        }
        else if(num == 2 ) {
            perg.setText("Fruta favorita?");
            bott1.setBackgroundResource(R.mipmap.manga1);
            bott2.setBackgroundResource(R.mipmap.laranja);
            bott3.setBackgroundResource(R.mipmap.maca);
        }
        else if(num == 3 ) {
            perg.setText("Animal favorito?");
            bott1.setBackgroundResource(R.mipmap.dog);
            bott2.setBackgroundResource(R.mipmap.leo);
            bott3.setBackgroundResource(R.mipmap.cat);
        }
        else if(num == 4 ) {
            perg.setText("Empresa favorita?");
            bott1.setBackgroundResource(R.mipmap.apple);
            bott2.setBackgroundResource(R.mipmap.google);
            bott3.setBackgroundResource(R.mipmap.manga);
        }
        else if(num == 5 ) {
            perg.setText("Cidade favorita?");
            bott1.setBackgroundResource(R.mipmap.paris);
            bott2.setBackgroundResource(R.mipmap.vegas);
            bott3.setBackgroundResource(R.mipmap.tokyo);
        }
        else if(num == 6 ) {
            perg.setText("Jogo favorito?");
            bott1.setBackgroundResource(R.mipmap.gta);
            bott2.setBackgroundResource(R.mipmap.hf2);
            bott3.setBackgroundResource(R.mipmap.assassin);
        }
        else if(num == 7 ) {
            perg.setText("Clima favorito?");
            bott1.setBackgroundResource(R.mipmap.sol);
            bott2.setBackgroundResource(R.mipmap.nublado);
            bott3.setBackgroundResource(R.mipmap.neve);
        }

        else if(num == 8 ) {
            perg.setText("Planeta favorito?");
            bott1.setBackgroundResource(R.mipmap.saturn);
            bott2.setBackgroundResource(R.mipmap.marte);
            bott3.setBackgroundResource(R.mipmap.jupiter);
        }
        else if(num == 9 ) {
            perg.setText("Banda de Rock favorito?");
            bott1.setBackgroundResource(R.mipmap.angra);
            bott2.setBackgroundResource(R.mipmap.metalica);
            bott3.setBackgroundResource(R.mipmap.artic);
        }
    }


}



