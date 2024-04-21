package com.example.sportsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    RecyclerView recyclerView;
    TextView about;
    TextView comment;
    List<Sports> sportsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        about=findViewById(R.id.about);
        comment=findViewById(R.id.comment);
        sportsList=new ArrayList<>();

        Sports sports1=new Sports(R.drawable.basketball,"Basketball","It is a team sport that involves two teams of five active players each trying to score points against one another by throwing a ball through a 300 cm (10 feet) high hoop (the 'basket') under organised rules. It is played on both indoor and outdoor courts.");
        Sports sports2=new Sports(R.drawable.football,"Football","Football, game in which two teams of 11 players, using any part of their bodies except their hands and arms, try to maneuver the ball into the opposing team's goal. Only the goalkeeper is permitted to handle the ball and may do so only within the penalty area surrounding the goal.");
        Sports sports3=new Sports(R.drawable.tennis,"Tennis","Tennis is a game played on a rectangular-shaped court, which can be one of many surfaces. It is either played with two players (singles match), or four players (doubles match). Players stand on opposite sides of the net and use a stringed racquet to hit the ball back and forth to each other.");
        Sports sports4=new Sports(R.drawable.volley,"Volleyball","Volleyball is a non-invasive sports game of a net type where there are two competing teams of six members who control the ball with parts of their body. There are both offensive and defensive tasks and one game event may result in both winning and losing points.");
        Sports sports5=new Sports(R.drawable.ping,"Ping","Table tennis (also known as ping-pong or whiff-whaff) is a racket sport derived from tennis but distinguished by its playing surface being atop a stationary table, rather than the court on which players stand.");

        sportsList.add(sports1);
        sportsList.add(sports2);
        sportsList.add(sports3);
        sportsList.add(sports4);
        sportsList.add(sports5);

        MyAdapter myAdapter=new MyAdapter(sportsList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapter);

        myAdapter.onItemClickListener(this);
    }

    @Override
    public void OnCLick(View v, int pos) {
        comment.setVisibility(View.GONE);
        about.setVisibility(View.VISIBLE);
        String aboutSport=sportsList.get(pos).getAbout();
        about.setText(aboutSport);
    }
}