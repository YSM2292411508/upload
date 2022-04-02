package com.yuan.Service;

import com.yuan.Tool.Data;

import java.util.List;

public interface AllService {
    List<Data> data();

    int insertData(Data data);
}
