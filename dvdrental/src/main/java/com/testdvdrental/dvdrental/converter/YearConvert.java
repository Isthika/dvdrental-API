package com.testdvdrental.dvdrental.converter;

import javax.persistence.AttributeConverter;
import java.time.Year;

public class YearConvert implements AttributeConverter<Year, Short> {

    @Override
    public Short convertToDatabaseColumn(Year attribute) {
        // TODO Auto-generated method stub
        if (attribute != null) {
            return (short) attribute.getValue();
        }
        return null;
    }

    @Override
    public Year convertToEntityAttribute(Short dbData) {
        // TODO Auto-generated method stub
        if (dbData != null) {
            return Year.of(dbData);
        }
        return null;
    }}
