package com.sandrew.boot;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by summer on 2020/2/5.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.or(
                       PathSelectors.ant("/login"),
                       PathSelectors.ant("/userInfo"),
                       PathSelectors.ant("/getMenuByRole"),
                       PathSelectors.ant("/logout"),
                       PathSelectors.ant("/usermanager/*"),
                       PathSelectors.ant("/rolemanager/*"))
                )
                .build()
                .apiInfo(apiInfo())
                .globalOperationParameters(customHeader());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("模版项目API文档")
                .description("前后端分离模版项目API文档")
                .version("V.0.0.1")
                .build();
    }

    /**
     *  添加自定义header
     * @return
     */
    private List<Parameter> customHeader()
    {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> paramList = new ArrayList<>();
        ticketPar.name("sid").description("User token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的sid参数非必填，传空也可以
        paramList.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数
        return paramList;
    }
}
