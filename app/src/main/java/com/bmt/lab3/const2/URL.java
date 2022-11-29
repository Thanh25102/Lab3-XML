package com.bmt.lab3.const2;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.os.HandlerCompat;
import com.bmt.lab3.ErrorActivity;
import com.bmt.lab3.LoadingActivity;
import com.bmt.lab3.SubActivity;
import com.bmt.lab3.dto.*;
import com.bmt.lab3.repository.BaseModelRepository;
import com.bmt.lab3.util.BaseModelParser;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class URL {
    public static ExecutorService executor = Executors.newFixedThreadPool(4);
    public static Handler mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());
    public static BaseModelParser baseModelParser = BaseModelParser.getInstance();

    public static <T extends TopBar & Serializable> void handleRecyclerView(T model, Context context) {
        BaseModelRepository baseModelRepository = new BaseModelRepository(baseModelParser, executor, mainThreadHandler);
        String url = null;
        if (model instanceof Category) {
            url = ((Category) model).getURL();
        } else if (model instanceof TopPick) {
            url = ((TopPick) model).getURL();
        } else if (model instanceof OnSale) {
            url = ((OnSale) model).getURL();
        }
        baseModelRepository.makeRequest(url, (callBack) -> {
            if (callBack instanceof Result.Success) {
                List<BaseModel> data = ((Result.Success<BaseModel>) callBack).datas;
                Intent intent = new Intent(context, SubActivity.class);
                intent.putExtra("data", (Serializable) data);
                context.startActivity(intent);
            } else {
                Exception exception = ((Result.Error<BaseModel>) callBack).exception;
                Log.e("FETCH API", exception.getMessage());
                Intent intent = new Intent(context, ErrorActivity.class);
                context.startActivity(intent);
            }
        });
        Intent loading = new Intent(context, LoadingActivity.class);
        context.startActivity(loading);
    }
}
