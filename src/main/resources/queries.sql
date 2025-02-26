CREATE TABLE movies (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    actor VARCHAR(100),
    actress VARCHAR(100),
    director VARCHAR(100),
    release_date DATE,
    rate_point DECIMAL(2,1)
);

INSERT INTO movies (name, actor, actress, director, release_date, rate_point) VALUES
    ('Inception', 'Leonardo DiCaprio', 'Ellen Page', 'Christopher Nolan', '2010-07-16', 9.0),
    ('Titanic', 'Leonardo DiCaprio', 'Kate Winslet', 'James Cameron', '1997-12-19', 8.5),
    ('The Dark Knight', 'Christian Bale', 'Maggie Gyllenhaal', 'Christopher Nolan', '2008-07-18', 9.1),
    ('Avatar', 'Sam Worthington', 'Zoe Saldana', 'James Cameron', '2009-12-18', 8.3),
    ('Interstellar', 'Matthew McConaughey', 'Anne Hathaway', 'Christopher Nolan', '2014-11-07', 8.7),
    ('The Matrix', 'Keanu Reeves', 'Carrie-Anne Moss', 'Lana Wachowski', '1999-03-31', 8.7),
    ('Joker', 'Joaquin Phoenix', NULL, 'Todd Phillips', '2019-10-04', 8.4),
    ('Forrest Gump', 'Tom Hanks', 'Robin Wright', 'Robert Zemeckis', '1994-07-06', 8.8),
    ('The Godfather', 'Marlon Brando', 'Diane Keaton', 'Francis Ford Coppola', '1972-03-24', 9.2),
    ('Pulp Fiction', 'John Travolta', 'Uma Thurman', 'Quentin Tarantino', '1994-10-14', 8.9);

