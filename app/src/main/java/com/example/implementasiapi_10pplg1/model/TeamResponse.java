package com.example.implementasiapi_10pplg1.model;

    import com.google.gson.annotations.SerializedName;
    import java.util.List;

    public class TeamResponse {
        @SerializedName("teams")
        private List<Team> teams;

        public List<Team> getTeams() {
            return teams;
        }
    }