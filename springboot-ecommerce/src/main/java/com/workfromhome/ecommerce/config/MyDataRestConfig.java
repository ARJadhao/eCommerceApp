package com.workfromhome.ecommerce.config;

import org.hibernate.boot.Metadata;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.HttpMethods;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.workfromhome.ecommerce.entity.Product;
import com.workfromhome.ecommerce.entity.ProductCategory;


@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		// TODO Auto-generated method stub
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config);
		
		HttpMethod [] theUnsupportedActions = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};
		
		// disable put, post and delete meaning.. allow read only access for Product and ProductCategory
		
		config.getExposureConfiguration()
				.forDomainType(Product.class)
				.withItemExposure((Metadata, HttpMethods) -> HttpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((Metadata, HttpMethods) -> HttpMethods.disable(theUnsupportedActions));
		
		config.getExposureConfiguration()
		.forDomainType(ProductCategory.class)
		.withItemExposure((Metadata, HttpMethods) -> HttpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((Metadata, HttpMethods) -> HttpMethods.disable(theUnsupportedActions));
	}

	
}
