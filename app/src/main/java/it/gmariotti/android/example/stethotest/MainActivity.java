package it.gmariotti.android.example.stethotest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.stetho.okhttp.StethoInterceptor;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        OkHttpClient client = new OkHttpClient();
        client.networkInterceptors().add(new StethoInterceptor());

        Request request = new Request.Builder()
                .url("https://google.com")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                //do something
            }

            @Override
            public void onResponse(Response response) throws IOException {
                //do something
            }
        });

        //Just an example...
        SharedPreferences.Editor editor = getSharedPreferences("TEST", MODE_PRIVATE).edit();
        editor.putString("name", "Paolo");
        editor.putInt("idName", 12);
        editor.commit();


        //Just for test..
        DBHelper oh = new DBHelper(MainActivity.this);
        oh.getWritableDatabase();
        oh.close();

    }


}