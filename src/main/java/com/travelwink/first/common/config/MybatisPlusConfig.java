package com.travelwink.first.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chris
 */
@Configuration
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        PaginationInnerInterceptor pageInnerInterceptor = new PaginationInnerInterceptor();
        pageInnerInterceptor.setOptimizeJoin(true);
        pageInnerInterceptor.setDbType(DbType.MYSQL);
        OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor = new OptimisticLockerInnerInterceptor();

        interceptor.addInnerInterceptor(pageInnerInterceptor);
        interceptor.addInnerInterceptor(optimisticLockerInnerInterceptor);
        return interceptor;
    }
}
