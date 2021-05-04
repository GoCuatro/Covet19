package com.javeriana.web.four.covet19.Usuarios.User.Infrastructure.Hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.ValueObjects.CarritoUsuario;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;
import java.util.stream.Collectors;

public class CarritoCustomDetail implements UserType {
    @Override
    public int[] sqlTypes() { return new int[] {Types.LONGNVARCHAR}; }

    @Override
    public Class returnedClass() { return List.class; }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x,y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        List<CarritoUsuario> response = null;
        try {
            Optional<String> value = Optional.ofNullable(rs.getString(names[0]));
            if(value.isPresent()) {
                List<HashMap<String, Object>> objects = new ObjectMapper().readValue(value.get(), List.class);
                response = objects.stream().map(carrito ->
                        new CarritoUsuario(Long.valueOf((int) carrito.get("cantidad")),
                                (String) carrito.get("idProducto"))).collect(Collectors.toList());
            }
        }
        catch (Exception e){
            throw new HibernateException("Error at reading map", e);
        }
        return Optional.ofNullable(response);
        }


    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        Optional<List<CarritoUsuario>> carritos = (value == null) ? Optional.empty() : (Optional<List<CarritoUsuario>>) value;
        try {
            if(carritos.isEmpty()) {
                st.setNull(index, Types.VARCHAR);
            }
            else {
                ObjectMapper mapper = new ObjectMapper();
                List<HashMap<String, Object>> objects = carritos.get().stream().map(carrito -> carrito.data()).collect(Collectors.toList());
                String serializedList = mapper.writeValueAsString(objects).replace("\\", "");
                st.setString(index, serializedList);
            }
        }
        catch (Exception e) {
            throw new HibernateException("Exception serializing value " + value, e);
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() { return false; }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return null;
    }
}
