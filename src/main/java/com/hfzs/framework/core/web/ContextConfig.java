package com.hfzs.framework.core.web;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.hfzs.framework.core.web.orm.MyJpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EntityScan({"com.hfzs.biz.sys.domain"})
@EnableJpaRepositories(basePackages = {"com.hfzs.biz.sys.repository"}, repositoryFactoryBeanClass = MyJpaRepositoryFactoryBean.class)
@ComponentScan({"com.hfzs.biz.sys.service.impl", "com.hfzs.biz.sys.controller"})
class ContextConfig extends AbstractProcessEngineAutoConfiguration{
    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(
            @Qualifier(NAME + "DataSource") DataSource dataSource,
            @Qualifier(NAME + "TransactionManager") PlatformTransactionManager transactionManager,
            SpringAsyncExecutor springAsyncExecutor) throws IOException {
        return this.baseSpringProcessEngineConfiguration(dataSource, transactionManager, springAsyncExecutor);
    }

//    作者：会灰的大飞狼
//    链接：http://www.jianshu.com/p/6c9882693f35
//    來源：简书
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。非商业转载请注明出处
}
