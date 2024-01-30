package com.genericUtility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
 

public class IAnnotationTrans implements org.testng.internal.annotations.IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod,
			Class<?> occurringClazz) {
		 annotation.setRetryAnalyzer(com.genericUtility.RetryImplementations.class);
	}

  
		
		
	 

	 
	 

}
