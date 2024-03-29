package com.ef_java_backend.service.Impl;
import com.ef_java_backend.exception.ModelNotFoundException;
import com.ef_java_backend.repo.IGenericRepo;
import  com.ef_java_backend.service.ICRUD;

import java.lang.reflect.Method;
import java.util.List;
public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {

    protected abstract IGenericRepo<T,ID> getRepo();
    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        Class<?> clazz = t.getClass();
        String className = clazz.getSimpleName();
        String methodName = "setId" + className;

        Method setIdMethod = clazz.getMethod(methodName,id.getClass());
        setIdMethod.invoke(t,id);

        getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID: " + id + " NOT FOUND."));
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID: " + id + " NOT FOUND."));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID: " + id + " NOT FOUND."));
        getRepo().deleteById(id);
    }
}
