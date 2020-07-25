package com.SpringDemo.Spring1stExample.Models;

import org.springframework.data.repository.CrudRepository;

// CRUD refers Create, Read, Update, Delete

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    Player findByUsernameAndPassword(String username, String password);
    Player findByPlayerId(int playerId);
}