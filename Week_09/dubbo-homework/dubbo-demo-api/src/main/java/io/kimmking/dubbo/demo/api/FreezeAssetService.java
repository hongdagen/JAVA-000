package io.kimmking.dubbo.demo.api;

import org.dromara.hmily.annotation.Hmily;

/**
 * @Author: hyhy
 * @Date: 2020/12/16 13:01
 */

public interface FreezeAssetService {

    @Hmily
    boolean updateTempConfirm(FreezeAssetDTO freezeAssetDTO);

    @Hmily
    boolean updateTempRollback(FreezeAssetDTO freezeAssetDTO);
}
