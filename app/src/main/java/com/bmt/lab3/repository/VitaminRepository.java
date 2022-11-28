package com.bmt.lab3.repository;

import android.os.Handler;
import com.bmt.lab3.dto.Result;
import com.bmt.lab3.dto.Vitamin;
import com.bmt.lab3.util.VitaminParser;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Executor;

public class VitaminRepository {
    private final VitaminParser vitaminParser;
    private final Executor executor;
    private final Handler resultHandler;

    public VitaminRepository(VitaminParser vitaminParser, Executor executor, Handler resultHandler) {
        this.vitaminParser = vitaminParser;
        this.executor = executor;
        this.resultHandler = resultHandler;
    }

    public void makeVitaminRequest(String urlStr, RepositoryCallback<Vitamin> callback) {
        executor.execute(() -> {
            try {
                Result<Vitamin> result = makeSynchronousVitaminRequest(urlStr);
                notifyResult(result,callback);
            }catch (Exception e){
                Result<Vitamin> result = new Result.Error<>(e);;
                notifyResult(result,callback);
            }
        });
    }

    private void notifyResult(
        final Result<Vitamin> result,
        final RepositoryCallback<Vitamin> callback
    ){
        resultHandler.post(()->{
            // callback UI work
            callback.onComplete(result);
        });
    }
    private Result<Vitamin> makeSynchronousVitaminRequest(String urlStr) {
        try {
            URL url = new URL(urlStr);
            InputStream inputStream = url.openConnection().getInputStream();
            Thread.sleep(5000);
            List<Vitamin> vitamins = vitaminParser.parseVitamin(inputStream);
            return new Result.Success<>(vitamins);
        } catch (Exception e) {
            return new Result.Error<>(e);
        }
    }
}