INSERT INTO `disney`.`pelicula_serie`
(
`clasificacion`,
`imagen`,
`inactivate`,
`titulo`)
VALUES
(
5,
"Infinitive.png",
false,
"Infinitive War");

INSERT INTO `disney`.`personaje`
(
`edad`,
`imagen`,
`nombre`,
`peso`)
VALUES
(
23,
"IronMan.png",
"IronMan",
123);


INSERT INTO `disney`.`pelicula_serie_personaje`
(`pelicula_serie_id`,
`personaje_id`)
VALUES
(1,
1);



