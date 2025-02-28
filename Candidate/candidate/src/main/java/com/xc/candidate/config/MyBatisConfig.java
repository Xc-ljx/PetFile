package com.xc.candidate.config;//
//package com.xc.candidate.config;
//
//import com.xc.candidate.model.CandidateStatus;
//import com.xc.candidate.utils.CandidateStatusTypeHandler;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.type.TypeHandlerRegistry;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class MyBatisConfig {
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource);
//
//        // 获取TypeHandlerRegistry并注册自定义TypeHandler
//        SqlSessionFactory sqlSessionFactory = factoryBean.getObject();
//        TypeHandlerRegistry typeHandlerRegistry = sqlSessionFactory.getConfiguration().getTypeHandlerRegistry();
//        typeHandlerRegistry.register(CandidateStatus.class, CandidateStatusTypeHandler.class);
//
//        return sqlSessionFactory;
//    }
//}
