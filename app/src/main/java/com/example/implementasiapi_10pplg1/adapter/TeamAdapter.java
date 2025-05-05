package com.example.implementasiapi_10pplg1.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.implementasiapi_10pplg1.R;
import com.example.implementasiapi_10pplg1.model.Team;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private Context context;
    private List<Team> teams;
    private Map<String, String> teamColors;

    public TeamAdapter(Context context, List<Team> teams) {
        this.context = context;
        this.teams = teams;
        setupTeamColors();
    }

    private void setupTeamColors() {
        teamColors = new HashMap<>();
        teamColors.put("Arsenal", "#EF0107");
        teamColors.put("Aston Villa", "#95BFE5");
        teamColors.put("AFC Bournemouth", "#DA291C");
        teamColors.put("Bournemouth", "#DA291C");
        teamColors.put("Brentford", "#E30613");
        teamColors.put("Brighton & Hove Albion", "#0057B8");
        teamColors.put("Brighton", "#0057B8");
        teamColors.put("Chelsea", "#034694");
        teamColors.put("Crystal Palace", "#1B458F");
        teamColors.put("Everton", "#003399");
        teamColors.put("Fulham", "#000000");
        teamColors.put("Ipswich Town", "#0055B8");
        teamColors.put("Ipswich", "#0055B8");
        teamColors.put("Leicester City", "#003090");
        teamColors.put("Leicester", "#003090");
        teamColors.put("Liverpool", "#C8102E");
        teamColors.put("Manchester City", "#6CABDD");
        teamColors.put("Man City", "#6CABDD");
        teamColors.put("Manchester United", "#DA291C");
        teamColors.put("Man United", "#DA291C");
        teamColors.put("Newcastle United", "#241F20");
        teamColors.put("Newcastle", "#241F20");
        teamColors.put("Nottingham Forest", "#DD0000");
        teamColors.put("Nottingham", "#DD0000");
        teamColors.put("Southampton", "#D71920");
        teamColors.put("Tottenham Hotspur", "#132257");
        teamColors.put("Tottenham", "#132257");
        teamColors.put("West Ham United", "#7A263A");
        teamColors.put("West Ham", "#7A263A");
        teamColors.put("Wolverhampton Wanderers", "#FDB913");
        teamColors.put("Wolverhampton", "#FDB913");
        teamColors.put("Wolves", "#FDB913");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_team, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.tvTeamName.setText(team.getStrTeam());
        String badgeUrl = team.getStrBadge();

        Glide.with(context)
                .load(badgeUrl)
                .into(holder.ivTeamBadge);

        Log.d("TeamAdapter", "Badge URL: " + badgeUrl);

        String teamName = team.getStrTeam();
        String colorCode = teamColors.get(teamName);

        if (colorCode != null) {
            holder.colorBar.setBackgroundColor(Color.parseColor(colorCode));
        } else {
            holder.colorBar.setBackgroundColor(Color.BLACK);
        }
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivTeamBadge;
        TextView tvTeamName;
        View colorBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivTeamBadge = itemView.findViewById(R.id.ivTeamBadge);
            tvTeamName = itemView.findViewById(R.id.tvTeamName);
            colorBar = itemView.findViewById(R.id.colorBar);
        }
    }
}
