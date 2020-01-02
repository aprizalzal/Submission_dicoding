package com.aprizal.submission;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aprizal.submission.adapter.ListWisataAdapter;
import com.aprizal.submission.from.DataWisata;
import com.aprizal.submission.from.Wisata;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_IMAGE = "imgPhoto";
    public static final String EXTRA_TEXT_NAME = "tvName";
    public static final String EXTRA_TEXT_DETAIL = "tvDetail";

    private RecyclerView rvCategory;
    private ArrayList<Wisata> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);
        list.addAll(DataWisata.getListData());
	    showRecyclerList();
    }
    private void showSelectedWisata(Wisata wisata, int position){
        Toast.makeText(this,wisata.getName(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,Main2Activity.class);
        Wisata clickedItem = list.get(position);
        intent.putExtra(EXTRA_IMAGE,clickedItem.getPhoto());
        intent.putExtra(EXTRA_TEXT_NAME,clickedItem.getName());
        intent.putExtra(EXTRA_TEXT_DETAIL,clickedItem.getDetail());
        startActivity(intent);
    }
    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListWisataAdapter listWisataAdapter = new ListWisataAdapter(list);
        rvCategory.setAdapter(listWisataAdapter);
        listWisataAdapter.setOnItemClickCallback(new ListWisataAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Wisata wisata , int position) {
                showSelectedWisata(wisata, position);
            }
        });
    }
}