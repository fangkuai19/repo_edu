package com.lagou.service;

import com.lagou.domain.Test;

import java.util.List;

public interface TestService {

    /**
     * 查询所有对象的所有的信息
     */
    public List<Test> findAllTest();

}
