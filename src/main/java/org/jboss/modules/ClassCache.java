/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2014 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.modules;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jdenise
 */
public abstract class ClassCache {
    public static final ClassCache DEFAULT = new DefaultClassCache();

    static class DefaultClassCache extends ClassCache {

        @Override
        public void addClassToCache(String className, Class<?>... parameterTypes) throws Exception {
        }
        @Override
        public void addClassToCache(String className) throws Exception {
        }

        @Override
        public Constructor getConstructorFromCache(Class<?> clazz, Class<?>... parameterTypes) {
            return null;
        }

        @Override
        public Set<String> addServiceToCache(String className) throws Exception {
            return Collections.emptySet();
        }

        @Override
        public List<Object> getServicesFromCache(Class<?> type) {
            return Collections.emptyList();
        }

        @Override
        public Class<?> getClassFromCache(String className) {
            return null;
        }

        @Override
        public Annotation getAnnotation(Class<?> clazz, Class<? extends Annotation> type) {
            return clazz.getAnnotation(type);
        }

        @Override
        public Annotation getAnnotation(Class<?> clazz, Method m, Class<? extends Annotation> type) {
            return m.getAnnotation(type);
        }

        @Override
        public Annotation[][] getParameterAnnotations(Class<?> clazz, Method m) {
            return m.getParameterAnnotations();
        }

        @Override
        public Method[] getDeclaredMethods(Class<?> clazz) {
            return clazz.getDeclaredMethods();
        }
        
        @Override
        public Constructor[] getConstructors(Class<?> clazz) {
            return clazz.getConstructors();
        }
        @Override
        public Constructor[] getDeclaredConstructors(Class<?> clazz) {
            return clazz.getDeclaredConstructors();
        }

        @Override
        public Method getMethod(Class<?> clazz, String name, Class<?>[] params) throws NoSuchMethodException {
            return clazz.getMethod(name, params);
        }
    }
    private Module module;

    void setModule(Module module) {
        this.module = module;
    }

    protected Module getModule() {
        return module;
    }

    public abstract void addClassToCache(String className, Class<?>... parameterTypes) throws Exception;
    
    public abstract void addClassToCache(String className) throws Exception;

    public abstract Constructor getConstructorFromCache(Class<?> clazz, Class<?>... parameterTypes);

    public abstract Set<String> addServiceToCache(String className) throws Exception;

    public abstract List<Object> getServicesFromCache(Class<?> type);
    public abstract Constructor[] getConstructors(Class<?> type);
    public abstract Constructor[] getDeclaredConstructors(Class<?> type);

    public abstract Class<?> getClassFromCache(String className);

    public abstract Annotation getAnnotation(Class<?> clazz, Class<? extends Annotation> type);

    public abstract Annotation getAnnotation(Class<?> clazz, Method m, Class<? extends Annotation> type);

    public abstract Annotation[][] getParameterAnnotations(Class<?> clazz, Method m);

    public abstract Method[] getDeclaredMethods(Class<?> clazz);
    
    public abstract Method getMethod(Class<?> clazz, String name, Class<?>[] params) throws NoSuchMethodException;
}
