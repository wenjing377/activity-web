package com.wfuhui.modules.market.service;

import com.wfuhui.modules.market.entity.MassEntity;

import java.util.List;
import java.util.Map;

public interface MassService {

    MassEntity queryObject(Integer id);

    List<MassEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(MassEntity mass);

    void update(MassEntity mass);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}

