package com.example.implementasiapi_10pplg1;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.implementasiapi_10pplg1.adapter.TeamAdapter;
import com.example.implementasiapi_10pplg1.api.ApiClient;
import com.example.implementasiapi_10pplg1.api.ApiService;
import com.example.implementasiapi_10pplg1.model.Team;
import com.example.implementasiapi_10pplg1.model.TeamResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TeamAdapter teamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        getTeams();
    }

    private void getTeams() {
        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<TeamResponse> call = apiService.getTeams("English Premier League");

        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Team> teams = response.body().getTeams();
                    teamAdapter = new TeamAdapter(MainActivity.this, teams);
                    recyclerView.setAdapter(teamAdapter);
                } else {
                    Toast.makeText(MainActivity.this, "Gagal ambil data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
