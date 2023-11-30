package com.sandrew.bootsec.core.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.time.DateTimeZone;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public class JsonUtil
{

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.registerModule(new JodaModule());
//        mapper.registerModule(BaseWriteOperationDeserializer.getModule());
        mapper.setTimeZone(DateTimeZone.getDefault().toTimeZone());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static void registerModule(SimpleModule module)
    {
        mapper.registerModule(module);
    }

    /**
     *  java对象转json字符串
     * @param obj
     * @return
     */
    public static String javaObject2String(Object obj)
    {
        String result = null;
        try
        {
            result = mapper.writeValueAsString(obj);
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public static byte[] javaObject2Byte(Object obj)
    {
        byte[] result = null;
        try
        {
            result = mapper.writeValueAsBytes(obj);
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *  json字符串转Java对象
     * @param jsonStr
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T string2JavaObject(String jsonStr, Class<T> clz)
    {
        T result = null;
        try
        {
            result = mapper.readValue(jsonStr, clz);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *  json字符串转JSON对象
     * @param jsonStr
     * @return
     */
    public static JsonNode string2JsonObject(String jsonStr)
    {
        JsonNode jsonNode = null;
        try
        {
            jsonNode = mapper.readTree(jsonStr);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return jsonNode;
    }

    /**
     *  java对象转JSON对象
     * @param javaObject
     * @return
     */
    public static JsonNode javaObject2JsonObject(Object javaObject)
    {
        JsonNode jsonNode = null;
        try
        {
            jsonNode = mapper.readTree(javaObject2String(javaObject));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return jsonNode;
    }
    /**
     * @Author summer
     * @Description jsonArray对象转java集合
     * @Date 13:33 2021/10/13
     * @Param [jsonNode]
     * @return java.util.List<T>
     **/
    public static <T> List<T> jsonArray2List(JsonNode jsonNode, Supplier<TypeReference> supplier)
    {
        List<T> list = null;
        try
        {
            ObjectReader reader = mapper.readerFor(supplier.get());
            list = reader.readValue(jsonNode);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @Author summer
     * @Description json对象转java对象
     * @Date 10:50 2021/10/13
     * @Param [jsonNode, clz]
     * @return T
     **/
    public static <T> T jsonObject2JavaObject(JsonNode jsonNode, Class<T> clz)
    {
        T t = null;
        try
        {
            t = mapper.treeToValue(jsonNode, clz);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return t;
    }

}