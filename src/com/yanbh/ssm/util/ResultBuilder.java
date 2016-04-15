package com.yanbh.ssm.util;

import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ResultBuilder {
    private String resultCode;
    private String resultMesg;
    Map<String, Object> resultObjectMap = new HashMap<String, Object>();

    public ResultBuilder(ResultType resultType) {
        this.resultCode = resultType.getResultCode();
        this.resultMesg = resultType.getResultMesg();
    }

    public ResultBuilder(ResultType resultType, String resultMesg) {
        this.resultCode = resultType.getResultCode();
        this.resultMesg = resultMesg;
    }

    public ResultBuilder putJson(String key, Object value) {
        Object jsonObject = JSONObject.toJSON(value);
        resultObjectMap.put(key, jsonObject);
        return this;
    }

    public ResultBuilder putObject(String key, Object value) {
        resultObjectMap.put(key, value);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> Map<String, T> toMap(Class<T> clazz) {
        Map<String, T> resultMap = new HashMap<String, T>();
        resultMap.put("resultCode", (T) this.resultCode);
        resultMap.put("resultMesg", (T) this.resultMesg);
        for (Entry<String, Object> entry : resultObjectMap.entrySet()) {
            resultMap.put(entry.getKey(), (T) entry.getValue());
        }
        return resultMap;
    }

    public Map<String, Object> toMap() {
        return toMap(Object.class);
    }
}