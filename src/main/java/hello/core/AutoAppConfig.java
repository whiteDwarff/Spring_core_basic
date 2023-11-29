package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;


/*
* 컴포넌트 스캔 ? @ComponentScan이 붙은 클래스를 찾아서 자동으로 스프링 빈으로
  등록해준다.
* @ComponentScan 을 설정 정보에 붙여주면 된다.
* 기존 AppConfig와 다르게 @Bean으로 등록한 클래스가 없다.
*
* */
@Configuration
@ComponentScan(
        // 패키지를 스캔하는 위치를 지정
        basePackages = "hello.core",
        // 지정한 클래스의 패키지를 탐색 시작 위치로 지정
        // 지정하지 않을 시 @ComponentScan이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.
        basePackageClasses = AutoAppConfig.class,
        // ComponentScan에서 제외하는 목록 설정
        // Configuration가 붙은 클래스는 제외
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
