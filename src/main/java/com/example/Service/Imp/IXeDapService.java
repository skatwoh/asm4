package com.example.Service.Imp;

import com.example.Entity.XeDap;
import com.example.Repository.XeDapRepo;
import com.example.Service.XeDapService;

import java.util.List;

public class IXeDapService implements XeDapService {

    private XeDapRepo xeDapRepo = new XeDapRepo();
    @Override
    public List<XeDap> hienThi() {
        return xeDapRepo.getALl();
    }

    @Override
    public String add(XeDap xeDap) {
        return xeDapRepo.add(xeDap);
    }

    @Override
    public XeDap getById(Long id) {
        return xeDapRepo.getById(id);
    }

}
