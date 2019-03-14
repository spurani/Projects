package com.mypackage.dao;

import com.mypackage.model.IStorable;

public interface ICreatable<T extends IStorable> {

	boolean create(T t);


}