package com.wfuhui.modules.market.controller;

import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.market.entity.MassEntity;
import com.wfuhui.modules.market.service.MassService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("mass")
public class MassController {
    @Autowired
    private MassService massService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("mass:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        List<MassEntity> massList = massService.queryList(query);
        int total = massService.queryTotal(query);

        return R.ok().put("rows", massList).put("total", total);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("mass:info")
    public R info(@PathVariable("id") Integer id){
        MassEntity mass = massService.queryObject(id);

        return R.ok().put("mass", mass);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("mass:save")
    public R save(@RequestBody MassEntity mass){
        mass.setCreateTime(new Date());
        massService.save(mass);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("mass:update")
    public R update(@RequestBody MassEntity mass){
        massService.update(mass);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("mass:delete")
    public R delete(@RequestBody Integer[] ids){
        massService.deleteBatch(ids);

        return R.ok();
    }

}
