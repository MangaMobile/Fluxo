package com.cgg.flux;

import android.graphics.Color;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * Created by Gio on 19/11/2015.
 */
public class Escolhas {

    public void escolher(TextView perg,ImageButton bott1, ImageButton bott2, ImageButton bott3, int num){


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
