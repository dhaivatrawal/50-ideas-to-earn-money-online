package com.zedrapps.moneymoney;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import java.util.ArrayList;

public class DetailResepActivity extends AppCompatActivity {
    private ArrayList<Integer> mImageID;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar toolbar = getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);

        addImgID();
        bindData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void bindData(){
        int position;
        String titleresep;
        String bahan [] = getResources().getStringArray(R.array.detail_resep);
        //String steps [] = getResources().getStringArray(R.array.step_resep);
        Intent  intent = getIntent();

        titleresep = intent.getStringExtra(Intent.EXTRA_TEXT);
        position = intent.getIntExtra(MainActivity.POSITION, 0);

        TextView tv_titleresep = (TextView) findViewById(R.id.titleresep);
        tv_titleresep.setText(titleresep);

        TextView tv_bahan = (TextView) findViewById(R.id.bahan);
        tv_bahan.setText(bahan[position]);

        //TextView tv_langkah = (TextView) findViewById(R.id.langkah);
        //tv_langkah.setText(steps[position]);

        ImageView image = (ImageView) findViewById(R.id.gambar);
        image.setImageResource(mImageID.get(position));

    }
    private void addImgID(){
        mImageID = new ArrayList<>();
        mImageID.add(R.mipmap.a);
        mImageID.add(R.mipmap.b);
        mImageID.add(R.mipmap.c);
        mImageID.add(R.mipmap.d);
        mImageID.add(R.mipmap.e);
        mImageID.add(R.mipmap.f);
        mImageID.add(R.mipmap.g);
        mImageID.add(R.mipmap.h);
        mImageID.add(R.mipmap.i);
        mImageID.add(R.mipmap.j);
        mImageID.add(R.mipmap.k);
        mImageID.add(R.mipmap.l);
        mImageID.add(R.mipmap.m);
        mImageID.add(R.mipmap.n);
        mImageID.add(R.mipmap.o);
        mImageID.add(R.mipmap.p);
        mImageID.add(R.mipmap.q);
        mImageID.add(R.mipmap.r);
        mImageID.add(R.mipmap.s);
        mImageID.add(R.mipmap.t);
        mImageID.add(R.mipmap.u);
        mImageID.add(R.mipmap.v);
        mImageID.add(R.mipmap.w);
        mImageID.add(R.mipmap.x);
        mImageID.add(R.mipmap.y);
        mImageID.add(R.mipmap.z);
        mImageID.add(R.mipmap.aa);
        mImageID.add(R.mipmap.bb);
        mImageID.add(R.mipmap.cc);
        mImageID.add(R.mipmap.dd);
        mImageID.add(R.mipmap.ee);
        mImageID.add(R.mipmap.ff);
        mImageID.add(R.mipmap.gg);
        mImageID.add(R.mipmap.hh);
        mImageID.add(R.mipmap.ii);
        mImageID.add(R.mipmap.jj);
        mImageID.add(R.mipmap.kk);
        mImageID.add(R.mipmap.ll);
        mImageID.add(R.mipmap.mm);
        mImageID.add(R.mipmap.nn);
        mImageID.add(R.mipmap.oo);
        mImageID.add(R.mipmap.pp);
        mImageID.add(R.mipmap.qq);
        mImageID.add(R.mipmap.ss);
        mImageID.add(R.mipmap.tt);
        mImageID.add(R.mipmap.uu);
        mImageID.add(R.mipmap.vv);
        mImageID.add(R.mipmap.ww);
        mImageID.add(R.mipmap.xx);
        mImageID.add(R.mipmap.yy);

    }
}
