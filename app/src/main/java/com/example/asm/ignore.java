package com.example.asm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

    /**
     * 添加到方法中 忽略doubleclick
     * created by dongliang
     * 2020/4/24    17:18
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface ignore{

    }

