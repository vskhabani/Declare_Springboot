package com.SpringDemo.Spring1stExample.Models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

// CRUD refers Create, Read, Update, Delete

public interface TestTableRepository extends CrudRepository<TestTable, Integer> {

}