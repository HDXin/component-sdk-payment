package top.atstudy.component.sdk.payment.wxpay.mini.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.atstudy.component.sdk.payment.wxpay.mini.config.PayConfig;

import java.lang.reflect.Field;
import java.util.*;

public abstract class BasicPaymentService {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    private PayConfig payConfig;
    protected static PaymentService instance = null;

    protected String getUnifiedorderSign(Object object) throws IllegalAccessException {
        Map<String, Object> resultMap = this.getMap(object);
        StringBuilder stringBuilder = new StringBuilder("");
        List<String> keys = new ArrayList(resultMap.keySet());
        Collections.sort(keys, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        Iterator var5 = keys.iterator();

        while(var5.hasNext()) {
            String key = (String)var5.next();
            stringBuilder.append("&").append(key).append("=").append(resultMap.get(key));
        }

        String params = stringBuilder.append("&key=").append(this.payConfig.getKey()).toString();
        params = params.substring(1, params.length());
        return DigestUtils.md5Hex(params);
    }

    protected String getPaySign(Map<String, Object> paySignMap) {
        StringBuilder stringBuilder = new StringBuilder("");
        List<String> keys = new ArrayList(paySignMap.keySet());
        Collections.sort(keys, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        Iterator var4 = keys.iterator();

        while(var4.hasNext()) {
            String key = (String)var4.next();
            stringBuilder.append("&").append(key).append("=").append(paySignMap.get(key));
        }

        String params = stringBuilder.append("&key=").append(this.payConfig.getKey()).toString();
        params = params.substring(1, params.length());
        return DigestUtils.md5Hex(params);
    }

    private Map<String, Object> getMap(Object object) throws IllegalAccessException {
        Map<String, Object> resultMap = new HashMap();

        for(Class clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                Field[] fields = clazz.getDeclaredFields();
                Field[] var5 = fields;
                int var6 = fields.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    Field field = var5[var7];
                    field.setAccessible(true);
                    Object obj = field.get(object);
                    if (obj != null) {
                        resultMap.put(field.getName(), obj);
                    }
                }
            } catch (Exception var10) {
                ;
            }
        }

        return resultMap;
    }

    public PayConfig getPayConfig() {
        return this.payConfig;
    }

    public void setPayConfig(PayConfig payConfig) {
        this.payConfig = payConfig;
    }
}
