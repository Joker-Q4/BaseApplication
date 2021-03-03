package com.joker.fake.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @author Joker
 * @since 2021/03/03
 */
public class ValidationUtil {

    /**
     * Collection 是否为空或者size为0
     * @param obj Collection
     * @return 是否为空
     */
    public static boolean isEmpty(Collection<?> obj){
        return obj == null || obj.isEmpty();
    }

    /**
     * String 是否为空或者""
     * @param obj String
     * @return 是否为空
     */
    public static boolean isEmpty(String obj){
        return obj == null || "".equals(obj);
    }

    /**
     * Array 是否为空或者size为0
     * @param obj Object[]
     * @return 是否为空
     */
    public static boolean isEmpty(Object[] obj){
        return obj == null || obj.length==0;
    }

    /**
     * Map是否为空或者size为0
     * @param obj Map
     * @return 是否为空
     */
    public static boolean isEmpty(Map<?, ?> obj){
        return obj == null || obj.isEmpty();
    }
}
