package com.zsl.cn.util;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * jackson工具类 常见转换方法
 *
 * @author wlz
 * @date 2021-06-09 10:02:48
 */
public class JacksonUtil {

    /**
     * jackson过滤接口
     */
    @JsonFilter("jacksonFilter")
    public interface JacksonFilter {
    }

    public final static ObjectMapper mapper = initMapper();

    private static ObjectMapper initMapper() {
        ObjectMapper initMapper = new ObjectMapper();

        // 忽略json中在对象不存在对应属性
        initMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 忽略空bean转json错误
        initMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        // 忽略所有引号
        initMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        // 忽略单引号
        initMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

        // 序列化忽略空值属性
        initMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        //大小写脱敏
        initMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        //允许出现特殊字符和转义符
//        initMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) ;

//        initMapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);

        return initMapper;
    }

    /**
     * object 转java bean
     * 入参和转换对象不能是 String等基础数据类型及其包装类。
     * 主要用于将实体A转化为实体B
     *
     * @param obj   待转化对象
     * @param clazz 目标对象类型
     * @return 转化后的对象
     */
    public static <T> T obj2pojo(Object obj, Class<T> clazz) {
        return mapper.convertValue(obj, clazz);
    }

    /**
     * 将json串转换为指定类型对象
     * 主要用于将json串转换为实体对象
     *
     * @param jsonStr 待转化json串
     * @param clazz   目标对象类型
     * @return 转化后的对象
     */
    public static <T> T str2pojo(String jsonStr, Class<T> clazz) throws Exception {

        return mapper.readValue(jsonStr, clazz);
    }

    /**
     * 将json串转换为指定泛型的对象-用于泛型对象转换
     * str2Obj("{\"ss\":123}", new TypeReference<HashMap<String, Object>>() {});
     *
     * @param jsonStr       带转换json串
     * @param typeReference 指定泛型反射类型
     * @return 转换后指定泛型的对象
     */
    public static <T> T str2Obj(String jsonStr, TypeReference<T> typeReference) throws Exception {
        return mapper.readValue(jsonStr, typeReference);
    }

    /**
     * 把一个泛型对象转换为指定的泛型类型对象-用于泛型对象转换
     * obj2Obj(Collections.singletonList(new UserBean()), new TypeReference<List<SmallUserBean>>() {});
     * 不可以将list<String>转为 List<pojo>、List<map> 等
     *
     * @param obj           待转换对象 pojo、set、map、list
     * @param typeReference 指定泛型反射类型
     * @return 转换后指定泛型类型对象
     */
    public static <T> T obj2Obj(Object obj, TypeReference<T> typeReference) {
        return mapper.convertValue(obj, typeReference);
    }

    /**
     * 将对象转json串
     *
     * @param obj 带转换对象
     * @return json串
     */
    public static String obj2JsonStr(Object obj) throws Exception {
        return mapper.writeValueAsString(obj);
    }

    /**
     * @param jsonStr json串
     * @param kType   key的类型
     * @param vType   value的类型
     * @param <k>     key的类型
     * @param <v>     value类型
     * @return 转化后的map
     * @throws Exception 抛出异常
     */
    public static <k, v> Map<k, v> strToMap(String jsonStr, Class<k> kType, Class<v> vType) throws Exception {
        return mapper.readValue(jsonStr, mapper.getTypeFactory().constructMapType(Map.class, kType, vType));
    }

    /**
     * 数组的json串转list
     *
     * @param json   json串
     * @param tClass 列表泛型的类型
     * @param <T>    泛型
     * @return 转换结果
     * @throws Exception 抛出异常
     */
    public static <T> List<T> str2List(String json, Class<T> tClass) throws Exception {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, tClass);
        return mapper.readValue(json, javaType);
    }

    /**
     * 将json串列表转换成指定的bean对象
     *
     * @param list   字符串列表
     * @param tClass java对象类型
     * @param <T>    泛型java对象类型
     * @return 指定类型列表
     * @throws Exception 抛出异常
     */
    public static <T> List<T> listJson2PojoList(List<String> list, Class<T> tClass) throws Exception {
        List<T> newList = new ArrayList<>();
        for (String json : list) {
            newList.add(mapper.readValue(json, tClass));
        }
        return newList;
    }

    /**
     * 将json串列表转换成指定的map对象
     *
     * @param list  json串列表
     * @param kType key的类型
     * @param vType value的类型
     * @param <k>   key的类型
     * @param <v>   value类型
     * @return 转化后的map
     * @throws Exception 抛出异常
     */
    public static <k, v> List<Map<k, v>> listJson2MapList(List<String> list, Class<k> kType,
            Class<v> vType) throws Exception {
        List<Map<k, v>> newList = new ArrayList<>();
        for (String json : list) {
            newList.add(mapper.readValue(json, mapper.getTypeFactory().constructMapType(Map.class, kType, vType)));
        }
        return newList;
    }

    /**
     * @param jsonStr json串
     * @return 格式化后的json串
     * @throws Exception 异常
     */
    public static String formatJson(String jsonStr) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Object obj = mapper.readValue(jsonStr, Object.class);
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }

    /**
     * 将对象转json串 可指定过滤的key
     *
     * @param obj 带转换对象
     * @return json串 得到filterKey之外的属性
     */
    public static String obj2JsonStrFilter(Object obj,  String... filterKey) throws Exception {
        ObjectMapper filterMapper = getFilterMapper(filterKey);
        return filterMapper.writeValueAsString(obj);
    }

    /**
     * 将对象转json串 可指定需要key
     * 得到
     *
     * @param obj 带转换对象
     * @return json串 得到filterKey中的属性
     */
    public static String obj2JsonStrOutFilter(Object obj,  String... filterKey) throws Exception {
        ObjectMapper filterMapper = getOutFilterMapper(filterKey);
        return filterMapper.writeValueAsString(obj);
    }

    /**
     * json串转JsonNode
     *
     * @param json json串
     * @return JsonNode
     * @throws Exception 抛出异常
     */
    public static JsonNode str2JsonNode(String json) throws Exception {
        return mapper.readTree(json);
    }

    /**
     * 判断字符串是否为json
     *
     * @param json 验证串
     * @return 验证结果
     */
    public static boolean isJson(String json) {
        boolean isJson = true;
        try {
            mapper.readTree(json);
        } catch (JsonProcessingException e) {
            isJson = false;
        }
        return isJson;
    }

    /**
     * 生成过滤规则
     *
     * @param filterKey 需要过滤的key
     * @return 含有过滤规则的mapper
     */
    private static ObjectMapper getFilterMapper(String... filterKey) {
        ObjectMapper filterMapper = initMapper();
        SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        filterProvider.addFilter("jacksonFilter", SimpleBeanPropertyFilter.serializeAllExcept(filterKey));
        filterMapper.setFilterProvider(filterProvider);

        //添加动态json属性注解
        filterMapper.addMixIn(Object.class, JacksonFilter.class);
        return filterMapper;
    }

    /**
     * 生成过滤规则
     *
     * @param filterKey 需要过滤的key
     * @return 含有过滤规则的mapper
     */
    private static ObjectMapper getOutFilterMapper(String... filterKey) {
        ObjectMapper filterMapper = initMapper();
        SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        filterProvider.addFilter("jacksonFilter", SimpleBeanPropertyFilter.filterOutAllExcept(filterKey));
        filterMapper.setFilterProvider(filterProvider);

        //添加动态json属性注解
        filterMapper.addMixIn(Object.class, JacksonFilter.class);
        return filterMapper;
    }

    /**
     * new 一个ObjectNode
     *
     * @return ObjectNode对象
     */
    public static ObjectNode newObjectNode() {
        return mapper.createObjectNode();
    }

    /**
     * new 一个ArrayNode
     *
     * @return ArrayNode对象
     */
    public static ArrayNode newArrayNode() {
        return mapper.createArrayNode();
    }
}
