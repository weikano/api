package com.wkswind.server.api.filters

import org.springframework.stereotype.Component
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.annotation.WebFilter

@Component
@WebFilter(urlPatterns = ["/*"], filterName = "rootFilter")
class TestFilter : Filter {
	override fun doFilter(p0: ServletRequest?, p1: ServletResponse?, p2: FilterChain?) {
		println("过滤器")
		p2?.doFilter(p0, p1)
	}
}