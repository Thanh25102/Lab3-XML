package com.bmt.lab3.repository;

import android.os.Handler;
import com.bmt.lab3.dto.BaseModel;
import com.bmt.lab3.dto.Result;
import com.bmt.lab3.util.BaseModelParser;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Executor;

public class BaseModelRepository {
    private final BaseModelParser baseModelParser;
    private final Executor executor;
    private final Handler resultHandler;

    public BaseModelRepository(BaseModelParser baseModelParser, Executor executor, Handler resultHandler) {
        this.baseModelParser = baseModelParser;
        this.executor = executor;
        this.resultHandler = resultHandler;
    }

    public void makeRequest(String urlStr, RepositoryCallback<BaseModel> callback) {
        executor.execute(() -> {
            try {
                Result<BaseModel> result = makeSynchronousRequest(urlStr);
                notifyResult(result, callback);
            } catch (Exception e) {
                Result<BaseModel> result = new Result.Error<>(e);
                ;
                notifyResult(result, callback);
            }
        });
    }

    private void notifyResult(
            final Result<BaseModel> result,
            final RepositoryCallback<BaseModel> callback
    ) {
        resultHandler.post(() -> {
            // callback UI work
            callback.onComplete(result);
        });
    }

    private Result<BaseModel> makeSynchronousRequest(String urlStr) {
        try {
            URL url = new URL(urlStr);
            InputStream inputStream = url.openConnection().getInputStream();
            Thread.sleep(5000);
            List<BaseModel> baseModels = baseModelParser.parseVitamin(inputStream);
            return new Result.Success<>(baseModels);
        } catch (Exception e) {
            return new Result.Error<>(e);
        }
    }
}