package com.wfuhui.modules.market.service.impl;

import com.wfuhui.modules.market.dao.MassDao;
import com.wfuhui.modules.market.entity.MassEntity;
import com.wfuhui.modules.market.service.MassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("massService")
public class MassServiceImpl implements MassService {
    @Autowired
    private MassDao massDao;

    @Override
    public MassEntity queryObject(Integer id){
        return massDao.queryObject(id);
    }

    @Override
    public List<MassEntity> queryList(Map<String, Object> map){
        return massDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map){
        return massDao.queryTotal(map);
    }

    @Override
    public void save(MassEntity mass){
        massDao.save(mass);
    }

    @Override
    public void update(MassEntity mass){
        massDao.update(mass);
    }

    @Override
    public void delete(Integer id){
        massDao.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids){
        massDao.deleteBatch(ids);
    }

}

