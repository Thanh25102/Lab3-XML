package com.bmt.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.HandlerCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bmt.lab3.adapter.RecyclerAdapter;
import com.bmt.lab3.const2.URL;
import com.bmt.lab3.dto.Category;
import com.bmt.lab3.dto.Result;
import com.bmt.lab3.dto.Vitamin;
import com.bmt.lab3.repository.VitaminRepository;
import com.bmt.lab3.util.LoadData;
import com.bmt.lab3.util.VitaminParser;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CategoryFragments extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    Handler mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private RecyclerAdapter<Category> recyclerAdapter;

    public CategoryFragments(){}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoryFragments newInstance(String param1, String param2) {
        CategoryFragments fragment = new CategoryFragments();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment, container, false);
        LoadData loadData = LoadData.getInstance();
        List<Category> datas = loadData.getCategories();
        recyclerView = view.findViewById(R.id.recyclerView);


        ExecutorService executor = Executors.newFixedThreadPool(4);
        Handler mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());
        VitaminParser vitaminParser = VitaminParser.getInstance();

        recyclerAdapter = new RecyclerAdapter<>(category->{
            if(category.getParserDTO().equals(Vitamin.class)){
                VitaminRepository vitaminRepository = new VitaminRepository(vitaminParser,executor,mainThreadHandler);
                Intent loading = new Intent(getContext(),LoadingActivity.class);
                startActivity(loading);
                vitaminRepository.makeVitaminRequest(URL.VITAMIN_ALL,(callBack)->{
                    if(callBack instanceof Result.Success){
                        List<Vitamin> data = ((Result.Success<Vitamin>) callBack).datas;
                        Intent intent = new Intent(getContext(),SubActivity.class);
                        intent.putExtra("data",(Serializable) data);
                        startActivity(intent);
                    } else {
                        Exception exception = ((Result.Error<Vitamin>) callBack).exception;
                        Log.i("vitamin", "Failer");
                    }
                });
            }
        });
        recyclerAdapter.setData(datas);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}
