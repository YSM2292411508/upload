package com.yuan.Service.lmpl;

import com.yuan.Dao.LiDao;
import com.yuan.Service.AllService;
import com.yuan.Tool.Data;

import java.util.List;

public class AllServiceImpl implements AllService {
    private LiDao liDao;

    public void setLiDao(LiDao liDao) {
        this.liDao = liDao;
    }

    @Override
    public List<Data> data() {
        List<Data> SelectLi=liDao.SelectLi();
        return SelectLi;
    }

    @Override
    public int insertData(Data data) {
        int row=liDao.insertData(data);
        return row;
    }
}
