package com.prenetics.common.utility;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;


public class DataStructure {

	// TODO Refactor this logic in usages of project

	private final static Logger logger = Logger.getLogger(DataStructure.class);

	/**
	 * Get all field names of a class in a collection of String
	 *
	 * @param fromClass Class to get field names
	 * @return Collection of String representing all field names of the class in question
	 */
	private static Collection<String> getFieldNames(Class<?> fromClass) {
		ArrayList<String> returnList = new ArrayList<String>();
		Field[] fields = fromClass.getFields();
		for (Field field : fields) {
			returnList.add(field.getName());
		}
		return returnList;
	}

	/**
	 * Get field value of a class
	 *
	 * @param fromClass
	 * @param fieldName
	 * @return field value
	 */
	public static String getFieldValue(Class<?> fromClass, String fieldName) {
		Field field;
		String value = null;
		try {
			field = fromClass.getField(fieldName);
			value = field.get(fromClass).toString();
		} catch (NoSuchFieldException | IllegalAccessException e) {
			logger.error("getFieldValue :: " + e.getMessage());
		}
		return value;
	}

	/**
	 * Get all field names of a class in a collection of String
	 *
	 * @param fromClass Class to get field values
	 * @return Collection of String representing all field values of the class in question
	 */
	public static Collection<String> getFieldValues(Class<?> fromClass) {
		Collection<String> fieldNames = getFieldNames(fromClass);
		Collection<String> fieldValues = new ArrayList<>();
		String fieldValue;
		for (String fieldName : fieldNames) {
			if ((fieldValue = getFieldValue(fromClass, fieldName)) != null) {
				fieldValues.add(fieldValue);
			}
		}
		return fieldValues;
	}
}
