package com.yuan.Dao;

import com.yuan.Tool.Data;

import java.util.List;

public interface LiDao {
    List<Data> SelectLi();

    int insertData(Data data);
}
