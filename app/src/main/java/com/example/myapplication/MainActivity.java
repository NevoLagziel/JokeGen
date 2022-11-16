package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import com.android.volley.*;
import com.android.volley.toolbox.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {

    private Button searchButton;
    private TextView theJoke;
    private RequestQueue myQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchButton = findViewById(R.id.button2);
        theJoke = findViewById(R.id.textView);
        myQueue = Volley.newRequestQueue(this);
    }

    public void request(View v){
        getRequest();
    }
    private void getRequest() {
        String url = "https://api.chucknorris.io/jokes/random";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String myJoke = response.getString("value");


                            theJoke.setText(myJoke);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        myQueue.add(request);
    }
}











