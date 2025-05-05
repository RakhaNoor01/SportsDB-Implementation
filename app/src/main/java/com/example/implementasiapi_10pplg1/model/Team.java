package com.example.implementasiapi_10pplg1.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("idTeam")
    private String id;

    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strBadge")
    private String strBadge;

    public String getId() { return id; }
    public String getStrTeam() { return strTeam; }
    public String getStrBadge() { return strBadge; }
}