package com.pt2.fd;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Pytania> pytania;
    private TextView trescPytania;
    private RadioButton rba, rbb, rbc;
    private String odp;
    private int poprawna;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/BigWorm7/retrofit_pytania/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Pytania>> call = jsonPlaceHolderApi.getPytania();
        trescPytania = findViewById(R.id.pyt1);
        rba = findViewById(R.id.odpa);
        rbb = findViewById(R.id.odpb);
        rbc = findViewById(R.id.odpc);
        button = findViewById(R.id.buttons);
        call.enqueue(
                new Callback<List<Pytania>>() {
                    @Override
                    public void onResponse(Call<List<Pytania>> call, Response<List<Pytania>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(MainActivity.this, ""+response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }

                            pytania = response.body();

                            rba.setText(pytania.get(0).getOdpa());
                            rbb.setText(pytania.get(0).getOdpb());
                            rbc.setText(pytania.get(0).getOdpc());
                    }

                    @Override
                    public void onFailure(Call<List<Pytania>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}