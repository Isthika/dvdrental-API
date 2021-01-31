package com.testdvdrental.dvdrental.entity;

import javax.persistence.AttributeConverter;

public class RatingConvert implements AttributeConverter<Rating, String> {

    @Override
    public String convertToDatabaseColumn(Rating attribute) {
        // TODO Auto-generated method stub
        if (attribute == null)
            return null;

        switch (attribute) {
            case G:
                return "G";
            case PG:
                return "PG";
            case PG13:
                return "PG-13";
            case R:
                return "R";
            case NC17:
                return "NC-17";
            default:
                throw new IllegalArgumentException(attribute + " not supported.");
        }
    }
    @Override
    public Rating convertToEntityAttribute(String dbData) {
        // TODO Auto-generated method stub
        if (dbData == null)
            return null;
        switch (dbData) {
            case "G":
                return Rating.G;
            case "PG":
                return Rating.PG;
            case "PG-13":
                return Rating.PG13;
            case "R":
                return Rating.R;
            case "NC-17":
                return Rating.NC17;
            default:
                throw new IllegalArgumentException(dbData + " not supported.");
        }
    }

}
