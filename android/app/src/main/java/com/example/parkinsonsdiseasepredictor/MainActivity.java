package com.example.parkinsonsdiseasepredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText et0,et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12,et13,et14,et15,et16,et17,et18,et19,et20,et21;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et0=findViewById(R.id.mdvp_fo);
        et1=findViewById(R.id.mdvp_fhi);
        et2=findViewById(R.id.mdvp_flo);
        et3=findViewById(R.id.mdvp_jitter_percent);
        et4=findViewById(R.id.mdvp_jitter_abs);
        et5=findViewById(R.id.mdvp_rap);
        et6=findViewById(R.id.mdvp_ppq);
        et7=findViewById(R.id.jitter_ddp);
        et8=findViewById(R.id.mdvp_shimmer);
        et9=findViewById(R.id.mdvp_shimmer_db);
        et10=findViewById(R.id.shimmer_apq3);
        et11=findViewById(R.id.shimmer_apq5);
        et12=findViewById(R.id.mdvp_apq);
        et13=findViewById(R.id.shimmer_dda);
        et14=findViewById(R.id.nhr);
        et15=findViewById(R.id.hnr);
        et16=findViewById(R.id.rpde);
        et17=findViewById(R.id.dfa);
        et18=findViewById(R.id.spread1);
        et19=findViewById(R.id.spread2);
        et20=findViewById(R.id.d2);
        et21=findViewById(R.id.ppe);

        bt=findViewById(R.id.submit);

        et0.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 260.105 )}) ;
        et1.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 592.03 )}) ;
        et2.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 239.17 )}) ;
        et3.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 0.03316 )}) ;
        et4.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 0.0026)}) ;
        et5.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 0.02144)}) ;
        et6.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 0.01958)}) ;
        et7.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 0.06433 )}) ;
        et8.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 0.11908)}) ;
        et9.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 1.302 )}) ;
        et10.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 0.05647)}) ;
        et11.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 0.0794)}) ;
        et12.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 0.13778)}) ;
        et13.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 0.16942)}) ;
        et14.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 0.31482)}) ;
        et15.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 33.047)}) ;
        et16.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 0.685151)}) ;
        et17.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 0.825288)}) ;
        et18.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 2.434031)}) ;
        et19.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 0.450493)}) ;
        et20.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 3.671155)}) ;
        et21.setFilters( new InputFilter[]{ new MinMaxFilter( this,0, 0.527367)}) ;

    }

    public void post(View view) {
        if(!(TextUtils.isEmpty(et0.getText().toString())) && !(TextUtils.isEmpty(et1.getText().toString()))&& !(TextUtils.isEmpty(et2.getText().toString()))&& !(TextUtils.isEmpty(et3.getText().toString()))&& !(TextUtils.isEmpty(et4.getText().toString()))&& !(TextUtils.isEmpty(et5.getText().toString()))&& !(TextUtils.isEmpty(et6.getText().toString()))&& !(TextUtils.isEmpty(et7.getText().toString()))&& !(TextUtils.isEmpty(et8.getText().toString()))&& !(TextUtils.isEmpty(et9.getText().toString()))&& !(TextUtils.isEmpty(et10.getText().toString()))&& !(TextUtils.isEmpty(et11.getText().toString()))&& !(TextUtils.isEmpty(et12.getText().toString()))&& !(TextUtils.isEmpty(et13.getText().toString()))&& !(TextUtils.isEmpty(et14.getText().toString()))&& !(TextUtils.isEmpty(et15.getText().toString()))&& !(TextUtils.isEmpty(et16.getText().toString()))&& !(TextUtils.isEmpty(et17.getText().toString()))&& !(TextUtils.isEmpty(et18.getText().toString()))&& !(TextUtils.isEmpty(et19.getText().toString()))&& !(TextUtils.isEmpty(et20.getText().toString()))&& !(TextUtils.isEmpty(et21.getText().toString())))
        {
            //using Volley for POST Method

            RequestQueue queue = Volley.newRequestQueue(this);
            final String url = "";
            JSONObject postparams = new JSONObject();
            try {
                // inserting post params into JSONObject
                postparams.put("MDVP:Fo(Hz)",et0.getText().toString());
                postparams.put("MDVP:Fhi(Hz)",et1.getText().toString());
                postparams.put("MDVP:Flo(Hz)",et2.getText().toString());
                postparams.put("MDVP:Jitter(%)",et3.getText().toString());
                postparams.put("MDVP:Jitter(Abs)",et4.getText().toString());
                postparams.put("MDVP:RAP",et5.getText().toString());
                postparams.put("MDVP:PPQ",et6.getText().toString());
                postparams.put("Jitter:DDP",et7.getText().toString());
                postparams.put("MDVP:Shimmer",et8.getText().toString());
                postparams.put("MDVP:Shimmer(dB)",et9.getText().toString());
                postparams.put("Shimmer:APQ3",et10.getText().toString());
                postparams.put("Shimmer:APQ5",et11.getText().toString());
                postparams.put("MDVP:APQ",et12.getText().toString());
                postparams.put("Shimmer:DDA",et13.getText().toString());
                postparams.put("NHR",et14.getText().toString());
                postparams.put("HNR",et15.getText().toString());
                postparams.put("RPDE",et16.getText().toString());
                postparams.put("DFA",et17.getText().toString());
                postparams.put("spread1",et18.getText().toString());
                postparams.put("spread2",et19.getText().toString());
                postparams.put("D2",et20.getText().toString());
                postparams.put("PPE",et21.getText().toString());
                // insert all the remaining params into json object
            }
            catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.POST, url, postparams, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.i("On Response", "onResponse: "+response.toString());

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();

                }
            });
            queue.add(jsonObjectRequest);

        }
        else{
            Toast.makeText(this,"All fields are required",Toast.LENGTH_SHORT).show();
        }
    }
    }

