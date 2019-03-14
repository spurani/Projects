package com.mypackage.dao;

import com.mypackage.model.IStorable;

public interface IDeletable<T extends IStorable> {
	boolean delete(T t);

}
