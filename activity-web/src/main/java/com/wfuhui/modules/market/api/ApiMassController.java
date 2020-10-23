package com.wfuhui.modules.market.api;

import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.api.annotation.AuthIgnore;
import com.wfuhui.modules.market.entity.MassEntity;
import com.wfuhui.modules.market.service.MassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mass/")
public class ApiMassController {

    @Autowired
    private MassService massService;

    @AuthIgnore
    @GetMapping("list")
    public R list(@RequestParam Map<String, Object> params){
        params.put("status", 1);
        Query query = new Query(params);
        List<MassEntity> massList = massService.queryList(query);
        Integer total = massService.queryTotal(params);
        return R.ok().put("massList", massList).put("total", total);
    }

}
