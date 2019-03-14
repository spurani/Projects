package com.mypackage.dao;

import com.mypackage.model.IStorable;

public interface IUpdatable<T extends IStorable> {
	boolean update(T t);

}
