package com.bank.payments.domain.model;

import java.util.HashMap;
import java.util.Map;

public class PaymentMetadata {

    private Map<String, String> data = new HashMap<>();

    public void add(String key, String value) {
        data.put(key, value);
    }

    public String get(String key) {
        return data.get(key);
    }

    public Map<String, String> getAll() {
        return data;
    }
}