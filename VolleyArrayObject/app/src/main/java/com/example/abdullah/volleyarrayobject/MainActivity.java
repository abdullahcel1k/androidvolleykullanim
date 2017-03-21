package com.example.abdullah.volleyarrayobject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public static final String TAG ="MainActivity";
    String url = "http://abdullahcelik.com.tr/survivorlist/survivorlist.php";
    private final String EXTRA_JSON_OBJECT = "mobileObject";
    List<Yarsimaci> yarsimaciList = new ArrayList<Yarsimaci>();

    MyAdapter myadapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listeyiDoldur(url);
        listView = (ListView) findViewById(R.id.list_item);
        myadapter= new MyAdapter(MainActivity.this, yarsimaciList,getApplicationContext());
        listView.setOnItemClickListener(this);
        //listView.setAdapter(myAdapter);

    }

    void listeyiDoldur(String url) {
        Log.i("Giriş yaptımı","Evet");
        JsonArrayRequest jsonArrayReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        Log.d(TAG,response.toString());
                        Log.d(TAG,"Len "+response.length());
                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Yarsimaci yarsimaci = new Yarsimaci();
                                yarsimaci.setYarismaciName(obj.getString("name"));
                                Log.d("Yarsimaci name :", yarsimaci.getYarismaciName());
                                yarsimaci.setYarismaciGrupName(obj.getString("groups"));
                                Log.d("Yarsimaci grupname :", yarsimaci.getYarismaciGrupName());
                                yarsimaci.setYarismaciImageUrl(obj.getString("images"));
                                Log.d("Yarsimaci image :", yarsimaci.getYarismaciImageUrl());
                                // yarsimaci nesneleri ArrayList'e ekleniyor.

                                yarsimaciList.add(yarsimaci);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        listView.setAdapter(myadapter);


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                // hide the progress dialog
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(jsonArrayReq);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l ) {
        String dataPosition = String.valueOf(position);
        Log.d("dataposition ",dataPosition);
        Intent i = new Intent(getApplication(), ParseJSONArrayObject.class);
        i.putExtra("dataposition", yarsimaciList.get(position));
        startActivity(i);
    }
}
