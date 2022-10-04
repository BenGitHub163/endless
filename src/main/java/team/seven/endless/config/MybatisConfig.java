package team.seven.endless.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/2 16:13
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"team.seven.endless.mapper", "team.seven.endless.entity"})
public class MybatisConfig {
}
