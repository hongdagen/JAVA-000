package io.kimmking.dubbo.demo.asset.service;

import io.kimmking.dubbo.demo.api.AccountDTO;
import io.kimmking.dubbo.demo.api.FreezeAssetDTO;
import io.kimmking.dubbo.demo.api.FreezeAssetService;
import io.kimmking.dubbo.demo.asset.repository.FreezeAmountMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: hyhy
 * @Date: 2020/12/16 13:00
 */

@Service
@DubboService(version = "1.0.0")
public class FreezeAmountServiceImpl implements FreezeAssetService {

    @Autowired
    private FreezeAmountMapper mapper;


    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean updateTempConfirm(FreezeAssetDTO freezeAssetDTO) {
        return mapper.updateTempConfirm(freezeAssetDTO) > 0;
    }

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean updateTempRollback(FreezeAssetDTO freezeAssetDTO) {
        return mapper.updateTempRollBack(freezeAssetDTO) > 0;
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean confirm(FreezeAssetDTO freezeAssetDTO) {
        System.out.println("============dubbo tcc 执行冻结===============");
        mapper.confirm(freezeAssetDTO);
        return Boolean.TRUE;
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean cancel(FreezeAssetDTO freezeAssetDTO) {
        System.out.println("============ dubbo tcc 执行取消冻结===============");
        mapper.cancel(freezeAssetDTO);
        return Boolean.TRUE;
    }

}
