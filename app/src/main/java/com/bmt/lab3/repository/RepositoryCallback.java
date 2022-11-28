package com.bmt.lab3.repository;

import com.bmt.lab3.dto.Result;

public interface RepositoryCallback<T> {
    void onComplete(Result<T> result);
}
