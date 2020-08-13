package com.prenetics.excel;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ java.lang.annotation.ElementType.METHOD })
public @interface ReadExcelSheet {
	String filePath() default "/automation/src/test/resources/excel";
	String fileName();
	String sheetName();
}