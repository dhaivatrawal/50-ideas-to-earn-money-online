package com.zedrapps.moneymoney;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ResepAdapter.ResepListener
{
    private ResepAdapter adapter;
    public static final String POSITION = "position";
    ImageView share,rateMe;
    private ImageView button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        String title[] = getResources().getStringArray(R.array.title_resep);
        adapter = new ResepAdapter(title,this);
        recyclerView.setAdapter(adapter);
        ImageView share=findViewById(R.id.share);
        ImageView rateMe=findViewById(R.id.rateMe);

        rateMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Intent.ACTION_SEND);
                final  String appPackageNAm = getApplicationContext().getPackageName();
                String strAppLink ="";
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + appPackageNAm)));
                } catch (android.content.ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageNAm)));
                }
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Intent.ACTION_SEND);
                final  String appPackageNAme = getApplicationContext().getPackageName();
                String strAppLink ="";

                try
                {
                    strAppLink = "http://play.google.com/store/apps/details?id=" + appPackageNAme;
                }
                catch (android.content.ActivityNotFoundException anfe)
                {
                    strAppLink = "https:/play.google.com/store/apps/details?id=" + appPackageNAme;
                }
                a.setType("text/link");
                String sharebody = "This app is basically on Online Money Earning ideas which anyone can Earn Money from home by just having an Internet Connection .\" +\n" +
                        "                        \"This App will inspire you to implement new ideas and different ways to earn money with different online platforms."+ " " +
                        " Please Comment and Rate Us." + "Download this Exclusive application and Share it." + "\n"+""+strAppLink;
                String sharesub = "APP NAME ";
                a.putExtra(Intent.EXTRA_SUBJECT,sharesub);
                a.putExtra(Intent.EXTRA_TEXT,sharebody);
                startActivity(Intent.createChooser(a,"Share Using"));
            }

        });

        button = (ImageView) findViewById(R.id.buttonShowCustomDialog);

        // add button listener
        button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {

                // custom dialog
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom);

                // set the custom dialog components - text, image and button
                TextView title_law = (TextView) dialog.findViewById(R.id.title_law);
                title_law.setText("#50 Online Earning Ideas !");
                TextView text = (TextView) dialog.findViewById(R.id.text);
                text.setText("This app is basically on Online Money Earning ideas which anyone can Earn Money from home by just having an Internet Connection ." +
                        "This App will inspire you to implement new ideas and different ways to earn money with different online platforms.");
                ImageView image = (ImageView) dialog.findViewById(R.id.image);
                image.setImageResource(R.mipmap.app_icon);

                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });
    }








    @Override
    public void onClick(int position)
    {
        Intent intent = new Intent(this,DetailResepActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT,adapter.getJudul(position));
        intent.putExtra(POSITION,position);

        startActivity(intent);

    }


}
