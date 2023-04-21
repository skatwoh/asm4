package com.example.Service;

import com.example.Entity.XeDap;

import java.util.List;

public interface XeDapService {
    List<XeDap> hienThi();

     String add(XeDap xeDap);

     XeDap getById(Long id);

}
