package io.kimmking.dubbo.demo.test;

import io.kimmking.dubbo.demo.account.AccountApplication;
import io.kimmking.dubbo.demo.account.service.AccountServiceImpl;
import io.kimmking.dubbo.demo.api.AccountDTO;
import io.kimmking.dubbo.demo.api.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @Author: hyhy
 * @Date: 2020/12/16 10:46
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AccountApplication.class})
public class AccountTest {

    @Autowired
    private AccountServiceImpl accountService;

    @Test
    public void testPayment(){
        AccountDTO dto = new AccountDTO();
        dto.setUserId("20000");
        dto.setAmount(new BigDecimal(10000));
//        accountService.payment(dto);


    }
}
