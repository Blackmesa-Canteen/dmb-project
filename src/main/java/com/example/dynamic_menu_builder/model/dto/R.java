package com.example.dynamic_menu_builder.model.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * response object
 *
 * @since 2020-05-15 10:46
 */

@ApiModel(description = "Response object")
public class R extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;
    public static final String MSG = "msg";
    public static final String CODE = "code";
    public static final String DATA = "data";

    @ApiModelProperty(value = "Response code", example = "200")
    public Integer code;
    @ApiModelProperty(value = "Response message", example = "ok")
    public String msg;
    @ApiModelProperty(value = "Response data", example = "{...} or [...]")
    public Object data;

    public R() {
        // default is 200 - ok
        put(CODE, HttpStatus.OK.value());
        put(MSG, HttpStatus.OK.getReasonPhrase());
    }

    public static R error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    public static R error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put(CODE, code);
        r.put(MSG, msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put(MSG, msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public Integer getCode() {

        return (Integer) this.get(CODE);
    }

    public R setData(Object data) {
        put(DATA, data);
        return this;
    }

    /**
     * parse the `data` key from the R map with designated type.
     * e.g. if you put("data", new Person()), use this method like getData(new TypeReference<MemberAddressVo>(Person) {});
     */
    public <T> T getData(TypeReference<T> typeReference) {
        Object data = get(DATA);
        String jsonString = JSON.toJSONString(data);
        return JSON.parseObject(jsonString, typeReference);
    }

    /**
     * parse the any key from the R map with designated type.
     * e.g. if you put("person", new Person()), use this method like getData("person",new TypeReference<Person>() {});
     */
    public <T> T getData(String key, TypeReference<T> typeReference) {
        Object data = get(key);
        String jsonString = JSON.toJSONString(data);
        return JSON.parseObject(jsonString, typeReference);
    }
}
