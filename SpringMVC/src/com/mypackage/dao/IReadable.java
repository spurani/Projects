package com.mypackage.dao;

import java.util.List;

import com.mypackage.model.IStorable;



public interface IReadable<T extends IStorable> {

	T readById(int id);

	List<T> readAll();

}
