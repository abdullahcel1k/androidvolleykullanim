package com.example.abdullah.volleyarrayobject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by abdullah on 3/20/17.
 */

public class MyAdapter extends BaseAdapter {
    private static final String TAG = "myAdapter";
    LayoutInflater layoutInflater;
    List<Yarsimaci> yarsimaciList;
    private ImageView cihazResim;
    private String resimUrl;
    private final Context context;

    public MyAdapter(Context c){
        context = c;
    }
    public MyAdapter(Activity activity, List<Yarsimaci> yarsimacis, Context context ){
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        yarsimaciList = yarsimacis;
        this.context = context;
    }

    @Override
    public int getCount() {
        return yarsimaciList.size();
    }

    @Override
    public Object getItem(int position) {
        return yarsimaciList.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        View satirView;

        satirView = layoutInflater.inflate(R.layout.my_list, null);
        TextView yarismaciGrupName = (TextView) satirView.findViewById(R.id.yarismaciGrupName);
        TextView yarismaciName = (TextView) satirView.findViewById(R.id.yarismaciName);
        cihazResim= (ImageView) satirView.findViewById(R.id.yarismaciImage);


        Yarsimaci yarsimaci = yarsimaciList.get(position);

        resimUrl = (yarsimaci.getYarismaciImageUrl());
        yarismaciGrupName.setText(yarsimaci.getYarismaciGrupName());
        yarismaciName.setText(yarsimaci.getYarismaciName());

        Picasso.with(context).load(resimUrl).into(cihazResim);


        //Picasso.with(context).load(resimUrl).into(cihazResim);

        //burada picasso kütüphanesi ile yaptığımız işlemleri aşağıda kısa bi parça olarak varki oda daha AppCntroller sınıfına gidip cacheleme işslemine uğruyor
        //Picasso kütüphanesi ile doğrduan resmin url sini vererek bütün bu aşaamaları tek satırda halletmiş olduk

/*
        ImageLoader imageLoader = new ImageLoader(Volley.newRequestQueue(context),new LruBitmapCache());
        imageLoader.get(resimUrl, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                if (response.getBitmap() != null){
                    cihazResim.setImageBitmap(response.getBitmap());
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Image Load Error:"+error.getMessage());
            }
        });
        */
        return satirView;
    }

}
