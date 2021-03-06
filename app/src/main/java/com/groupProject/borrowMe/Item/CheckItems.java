package com.groupProject.borrowMe.Item;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.groupProject.borrowMe.R;
import com.groupProject.borrowMe.adaptors.AdaptorAdminCheckItem;
import com.groupProject.borrowMe.models.ItemCheck;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class CheckItems extends AppCompatActivity {


    RecyclerView recyclerView;


    List<ItemCheck> items;



    private static final String request_url = "https://myxstyle120.000webhostapp.com/uncheckedItems.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_items);


        recyclerView = (RecyclerView) findViewById(R.id.CheckItemsAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        items = new ArrayList<>();


        sendRequest();

    }


    public void sendRequest(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, request_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject item = array.getJSONObject(i);

                                //adding the product to product list
                                items.add(new ItemCheck(
                                        item.getString("item_id"),
                                        item.getString("email"),
                                        item.getString("name"),
                                        item.getString("price"),
                                        item.getString("Description"),
                                        item.getString("Department")

                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            AdaptorAdminCheckItem adapter = new AdaptorAdminCheckItem(CheckItems.this, items);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
}