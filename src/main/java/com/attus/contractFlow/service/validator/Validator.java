package com.attus.contractFlow.service.validator;

public interface Validator<T> {
    void validate(T res);
}

