package com.example.converters;

import org.springframework.core.convert.converter.Converter;

import com.example.beans.Gender;

public class StringToEnumConverter implements Converter<String, Gender>{

	@Override
	public Gender convert(String source) {
		// TODO Auto-generated method stub
		if(source.equals("Male"))
		{
			return Gender.MALE;
		}
		else if(source.equals("Female"))
		{
			return Gender.FEMALE;
		}else
		{
			return Gender.OTHER ;
		}
		
	}

}
