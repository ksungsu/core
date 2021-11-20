package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * ComponentScan을 이용한 springBean 자동생성
 */

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member", //탐색 시작 지점, member package만 실행.
        //예제를 위해 선언, 실무에선 거의 사용 x
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {


}
