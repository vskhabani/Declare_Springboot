insert into player (player_id, email, first_name, last_name, username, password, signup_date, active_ind, deactivation_date ) values (1, 'email@email.com', 'test', 'er', 'testuser1', 'testpassword1', '2020-08-07', 1, null);
insert into player (player_id, email, first_name, last_name, username, password, signup_date, active_ind, deactivation_date ) values (2, 'user2@email.com', 'second', 'test user', 'testuser2', 'testpassword2', '2020-08-07', 1, null);
insert into player (player_id, email, first_name, last_name, username, password, signup_date, active_ind, deactivation_date ) values (3, 'user3@email.com', 'third', 'test user', 'testuser3', 'testpassword3', '2020-08-07', 1, null);
insert into player (player_id, email, first_name, last_name, username, password, signup_date, active_ind, deactivation_date ) values (4, 'user4@email.com', 'fourth', 'test user', 'testuser4', 'testpassword4', '2020-08-07', 1, null);

insert into auth (auth_id, hash, last_login_date, last_password_change_date, player_id, salted_password, token, active_ind ) values (10001, 'hash', '2020-08-07', '2020-08-07', 1, 'password', 'some token', 1);


insert into status (status_id, name, active_ind) values (1, 'Draft', 1), (2, 'Aborted', 1), (3, 'In Progress', 1), (4, 'Completed', 1), (5, 'Cancelled', 1);

/* Game #1 - In Progress with 4 Players and 2 rounds */
insert into game (game_id, end_date, num_players, start_date, status_id, active_ind) values (1, null, 4, '2020-08-07 01:01:00.00', 3, 1);

/* Game #1 Players */
insert into game_players (game_player_id, num_rounds, points, game_id, player_id, status_id, active_ind) values (1, 2, 0, 1, 1, 3 , 1), (2, 2, 0, 1, 2, 3, 1), (3, 2, 25, 1, 3, 3, 1), (4, 2, 300, 1, 4, 5, 1);

/* Game #1 Rounds */
insert into game_rounds (game_round_id, start_date, end_date, game_id, status_id, active_ind) values (1, '2020-08-07 01:01:01.01', '2020-08-07 01:01:02.01', 1, 4, 1),  (2, '2020-08-07 01:02:02.02', null,  1, 3, 1);

/* Game #1 Game Player Rounds */
insert into game_player_rounds (game_player_round_id, player_id, game_round_id, points, declare_ind, active_ind) values (1, 1, 1, 40, 0, 1), (2, 1, 2, 50, 0, 1), (3, 2, 1, 0, 1, 1),  (4, 2, 2, 60, 0, 1),  (5, 3, 1, 30,  0, 1),  (6, 3, 2, 50, 0, 1), (7, 4, 1, 60, 0, 1),  (8, 4, 2, 70, 0, 1);

/* Game #2, Draft with 1 Player and 0 rounds */
insert into game (game_id, num_players, start_date, end_date, status_id, active_ind) values (2, 1, '2020-08-07', null, 1, 1);

/* Game #2 Players */
insert into game_players (game_player_id, num_rounds, points, game_id, player_id, status_id, active_ind) values (5, 0, 0, 2, 1, 1 , 1);

/* Game #3 */
insert into game (game_id,num_players, start_date, end_date, status_id, active_ind) values (3, 2, '2020-08-08', '2020-08-07', 4, 1);

/* Game #3 Rounds */
insert into game_rounds (game_round_id, start_date, end_date, game_id, status_id, active_ind) values (3, '2020-08-07 00:01:01.01', '2020-08-07 00:01:59.1', 2, 4, 1),  (4, '2020-08-07 00:02:01.50', '2020-08-07 00:03:01.50', 1, 4, 1);

/* Game #3 Players */
insert into game_players (game_player_id, num_rounds, points, game_id, player_id, status_id, active_ind) values (6, 2, 50, 3, 1, 4 , 1), (7, 2, 60, 3, 2, 4, 1);

/* Game #3 Game Player Rounds */
insert into game_player_rounds (game_player_round_id, player_id, game_round_id, points, declare_ind, active_ind) values (9, 1, 3, 20, 0, 1);
insert into game_player_rounds (game_player_round_id, player_id, game_round_id, points, declare_ind, active_ind) values (10, 1, 4, 0, 1, 1);
insert into game_player_rounds (game_player_round_id, player_id, game_round_id, points, declare_ind, active_ind) values (11, 2, 3, 0,  1, 1);
insert into game_player_rounds (game_player_round_id, player_id, game_round_id, points, declare_ind, active_ind) values (12, 2, 4, 40, 0, 1);
