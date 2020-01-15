package com.xiaobangbang.pcdemo.config;

import com.xiaobangbang.pcdemo.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author peyazhuo
 * @date 2020/1/13
 */
@Configuration
public class UserConfig {
    @Bean
    public Student student(){
        return new Student(100);
    }


}
