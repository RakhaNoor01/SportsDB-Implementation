package com.example.implementasiapi_10pplg1.api;

import com.example.implementasiapi_10pplg1.model.TeamResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("search_all_teams.php")
    Call<TeamResponse> getTeams(@Query("l") String league);
}
