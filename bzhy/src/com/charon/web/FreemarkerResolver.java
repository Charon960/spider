package com.charon.web;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

public class FreemarkerResolver extends AbstractTemplateViewResolver{

	public FreemarkerResolver() {
		setViewClass(FreemarkerResolver.class);
	}
	
	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		return super.buildView(viewName);
	}

}
