package com.testdvdrental.dvdrental.converter;


import com.testdvdrental.dvdrental.entity.Rating;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.hibernate.type.EnumType;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

@Converter
public class EnumTypePostgreSql extends EnumType implements AttributeConverter<Rating,String> {
/**
 *
 */
private static final long serialVersionUID = 1L;

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

@Override
public void nullSafeSet(PreparedStatement st, Object value, int index,
                        SharedSessionContractImplementor session)
        throws HibernateException, SQLException {
        if(value == null) {
        st.setNull( index, Types.OTHER );
        }
        else {
        st.setObject( index, value.toString(), Types.OTHER );
        }
        }
        }
