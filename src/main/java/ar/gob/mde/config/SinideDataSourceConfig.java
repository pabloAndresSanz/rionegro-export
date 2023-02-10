package ar.gob.mde.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
//@MapperScan(basePackages = "mybatis/Sinide", sqlSessionFactoryRef = "SinideSessionFactory", sqlSessionTemplateRef  = "SinideSessionTemplate")
public class SinideDataSourceConfig {

    @Bean(name = "SinideDataSource") //As a bean object and named
    @ConfigurationProperties(prefix = "spring.datasource.sinide") //In the configuration file, the prefix of the data source
    public DataSource SinideDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "SinideSessionFactory")
    //@Primary
    public SqlSessionFactory SinideSessionFactory(@Qualifier("SinideDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/sinide/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "SinideTransactionManager")
    //@Primary
    public DataSourceTransactionManager SinideTransactionManager(@Qualifier("SinideDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "SinideSessionTemplate")
    //@Primary
    public SqlSessionTemplate SinideSessionTemplate(@Qualifier("SinideSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
