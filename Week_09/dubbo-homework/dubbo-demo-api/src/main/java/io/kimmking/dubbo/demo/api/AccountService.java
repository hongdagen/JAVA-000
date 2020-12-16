package io.kimmking.dubbo.demo.api;

import org.dromara.hmily.annotation.Hmily;

/**
 * @Author: hyhy
 * @Date: 2020/12/16 10:14
 */
public interface AccountService {


    @Hmily
    boolean exchange(AccountDTO accountDTO);
}
