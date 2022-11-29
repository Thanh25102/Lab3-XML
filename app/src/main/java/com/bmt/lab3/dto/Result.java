package com.bmt.lab3.dto;

import java.util.List;

public class Result<T> {
    private Result() {
    }

    public static final class Success<T> extends Result<T> {
        public T data;
        public List<T> datas;

        public Success(T data) {
            this.data = data;
        }

        public Success(List<T> datas) {
            this.datas = datas;
        }
    }

    public static final class Error<T> extends Result<T> {
        public Exception exception;

        public Error(Exception exception) {
            this.exception = exception;
        }
    }
}
