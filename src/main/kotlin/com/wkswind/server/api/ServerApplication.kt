package com.wkswind.server.api

import com.wkswind.server.api.interceptors.TestInterceptor
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.actuate.autoconfigure.info.ConditionalOnEnabledInfoContributor
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@SpringBootApplication
@MapperScan("com.wkswind.server.api.mappers")
class ServerApplication

fun main(args: Array<String>) {
	runApplication<ServerApplication>(*args)
}

@Configuration
class WebMvcConfiguration : WebMvcConfigurerAdapter() {
	override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
		super.configureMessageConverters(converters)
		//添加对application/x-protobuf支持，用于请求参数中包含proto字节数组的请求
		converters.add(ProtobufHttpMessageConverter())
	}
	override fun addInterceptors(registry: InterceptorRegistry) {
		super.addInterceptors(registry)
		registry.addInterceptor(TestInterceptor).addPathPatterns("/*")
	}
}

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
	@Bean
	fun encoder(): PasswordEncoder = BCryptPasswordEncoder()
	
	override fun configure(auth: AuthenticationManagerBuilder?) {
		super.configure(auth)
//		auth?.also {
//			it.inMemoryAuthentication()
//				.withUser("admin").password("admin").roles("ADMIN")
//				.and()
//				.withUser("user").password("user").roles("USER")
//		}
	}
	
	override fun configure(web: WebSecurity?) {
		super.configure(web)
		web?.also {
			it.ignoring().anyRequest()
		}
	}
	override fun configure(http: HttpSecurity?) {
		super.configure(http)
//		http?.also {
//			it.csrf().disable()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//				.and()
//				.authorizeRequests().antMatchers("/api/diary/*").authenticated().anyRequest().permitAll()
//		}
	}
}