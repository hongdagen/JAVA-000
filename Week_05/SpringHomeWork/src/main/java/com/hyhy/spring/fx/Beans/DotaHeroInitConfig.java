package com.hyhy.spring.fx.Beans;

import com.hyhy.spring.fx.POJO.DotaHeroInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DotaHeroInitConfig {

    @Bean("initDotaHeroBean")
    public DotaHeroInfo initDotaHero(){
        return new DotaHeroInfo();
    }


}
