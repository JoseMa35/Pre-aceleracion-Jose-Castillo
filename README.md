# disney_challenge
Disney Challenge Alkemy


#Para levantar la app:

1.Usar DB Mysql creando esquema "disney"
2.Definir los usuarios de conexio en application.properties



#Ejemplo de crear personarje

curl --location --request POST 'http://localhost:8080/personajes/' \
--header 'Content-Type: application/json' \
--data-raw '{   
"nombre":"Mickey Mouse",
"edad":56,
"peso":125,
"historia":"El mejor raton"
}'