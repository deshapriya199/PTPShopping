package com.san4n.ptpshopping.util;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.InvocationTargetException;

public class EntityUtil {

    private EntityUtil(){}

    public static <T, R extends JpaRepository<T, Long>> T newEntity(Long id, Class<T> tClass, R repository) {
        T t;
        try {
            t = tClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        T dbData = repository.getReferenceById(id);
        BeanUtils.copyProperties(dbData, t);
        return t;
    }

}
