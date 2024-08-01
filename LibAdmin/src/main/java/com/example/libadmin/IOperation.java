package com.example.libadmin;


import java.util.List;

public interface IOperation<T> {
    void add(T t);
    void update(T t);
    void delete(int id) throws Exception;
    T search(int id);
    List<T> getList();
}

