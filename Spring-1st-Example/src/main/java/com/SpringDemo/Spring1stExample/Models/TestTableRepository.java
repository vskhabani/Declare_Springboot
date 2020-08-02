package com.SpringDemo.Spring1stExample.Models;

import org.springframework.data.repository.CrudRepository;

// CRUD refers Create, Read, Update, Delete

public interface TestTableRepository extends CrudRepository<TestTable, Integer> {

}