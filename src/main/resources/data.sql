INSERT INTO tb_user (name, email, password) VALUES ('Bob', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Ana', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('VISITOR'); 
INSERT INTO tb_role (authority) VALUES ('MEMBER');

INSERT INTO tb_genre (id, name) VALUES (1, 'Action');
INSERT INTO tb_genre (id, name) VALUES (2, 'Aventura');
INSERT INTO tb_genre (id, name) VALUES (3, 'Art cinema');
INSERT INTO tb_genre (id, name) VALUES (4, 'Comedy');

INSERT INTO tb_movies (id, title, sub_Title, year, img_Url, synopsis, genre_id) VALUES (1, 'Star Wars', 'The Force Awakens.', '2015', 'https://i.imgur.com/hJlRfym.png', 'An exciting adventure that resumes the narrative thirty years after the events of Return of the Jedi. The battle scenes are impressively immersive and joyful, bringing a mix of fiction and reality.', 1);
INSERT INTO tb_movies (id, title, sub_Title, year, img_Url, synopsis, genre_id) VALUES (2, 'Spider-Man', 'No Way Home.', '2021', 'https://upload.wikimedia.org/wikipedia/en/0/00/Spider-Man_No_Way_Home_poster.jpg', 'No Way Home turns out to be a way to honor all Spider-Man movies - from the simplest times of Sam Raimi’s trilogy to the giant Marvel universe.', 2);
INSERT INTO tb_movies (id, title, sub_Title, year, img_Url, synopsis, genre_id) VALUES (3, 'The Godfather','The history of the familha coleone.', '1972', 'https://d32qys9a6wm9no.cloudfront.net/images/movies/poster/60/6081594975a764c8e3a691fa2b3a321d_300x442.jpg?t=1636102095', 'An American crime film, directed by Francis Ford Coppola and released in 1972. It is one of the most famous and influential works in the world of cinema, becoming a classic acclaimed by audiences and critics.', 3); 
INSERT INTO tb_movies (id, title, sub_Title, year, img_Url, synopsis, genre_id) VALUES (4, 'Barbie', 'barbie while she navigates the real world.', '2023', 'https://thumbs.dreamstime.com/z/logotipo-de-filme-barbie-na-ilustra%C3%A7%C3%A3o-do-vetor-fundo-branco-%C3%A9-uma-boneca-moda-criada-por-empres%C3%A1ria-americana-em-pela-norte-285706355.jpg', 'live-action comedy that features Margot Robbie as Barbie. The film presents the universe of plastic and pink with the gaze of American director Greta Gerwig.', 4);  

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_reviews (text, id, user_id, movie_id) VALUES ('The battle scenes are impressively immersive and joyful, bringing a mix of fiction and reality.', 1, 2, 1);
INSERT INTO tb_reviews (text, id, user_id, movie_id) VALUES ('The various action scenes make the almost two and a half hours of Spider-Man: No Way Home very well balanced, without becoming tiresome a second time watching.', 2, 2, 2);
INSERT INTO tb_reviews (text, id, user_id, movie_id) VALUES ('An engaging narrative, complex characters and cultural influence make it one of the most revered films in history.', 3, 2, 3);
INSERT INTO tb_reviews (text, id, user_id, movie_id) VALUES ('A cinematic experience full of powerful messages that resonate with all ages.', 4, 2, 4);

