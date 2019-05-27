package org.tensorflow.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.tensorflow.demo.env.BorderedText;
import org.tensorflow.demo.env.DataAdapter;

import java.util.ArrayList;
import java.util.List;

public class DataActivity extends Activity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager linearLayoutManager;
    DataAdapter dataAdapter;
    List<String> newList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        newList = new ArrayList<>();

        recyclerView = findViewById(R.id.rcList);
        Button btn = findViewById(R.id.reset);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BorderedText.textnya.clear();
                populateData();
            }
        });
        linearLayoutManager = new LinearLayoutManager(this);
//        checkList();
        populateData();
    }
//
//    private void checkList(){
//        boolean inserted = false;
//        System.out.println(BorderedText.textnya.size() + " size");
//        int size = BorderedText.textnya.size();
//        for (int i=0; i<size; i++){
//            for (int j = i+1; j<size; j++){
//                if (!inserted){
//                    newList.add(BorderedText.textnya.get(i));
//                    inserted = true;
//                } else {
//                    System.out.println(i + " ");
//                    if (BorderedText.textnya.get(i).equalsIgnoreCase(BorderedText.textnya.get(j))){
//                        System.out.println("Data sama");
//                    } else {
//                        newList.add(BorderedText.textnya.get(i));
//                    }
//                }
//            }
//        }
//    }

    public static <T> List<T> removeDuplicates(List<T>  list) {
        List<T> newList = new ArrayList<T>();
        for (T element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }

        return newList;
    }

    private void populateData(){
        System.out.println(newList.toString());
        newList = removeDuplicates(BorderedText.textnya);
        for (int i=0; i<BorderedText.textnya.size(); i++){
            dataAdapter = new DataAdapter(this, newList);
            recyclerView.setAdapter(dataAdapter);
            recyclerView.setLayoutManager(linearLayoutManager);
        }
//        realm.executeTransactionAsync(realm1 -> listAturan = realm1.copyFromRealm(realm1.where(AturanRealm.class).equalTo("kategori", "1").findAll()), () -> {
//            if (!listAturan.isEmpty()) {
//                aturanAdapter = new AturanAdapter(this, listAturan, this);
//                scaleInAnimationAdapter = new ScaleInAnimationAdapter(aturanAdapter);
//                rcList.setAdapter(scaleInAnimationAdapter);
//                rcList.setLayoutManager(linearLayoutManager);
//                setSearchFunction();
//            }
//        });
    }
}
