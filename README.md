#run main class using following command on terminal
gradle run
curl --location --request POST 'http://localhost:8083/customers' \
--header 'Content-Type: application/json' \
--data-raw '{   
"addressRequest" :{
"city": "pune"
}

}'

curl --location --request POST 'http://localhost:8083/accounts' \
--header 'Content-Type: application/json' \
--data-raw '{
"addressRequest": {
"city": "pune"
},
"customerId": "ce3e3cdb-5650-421d-8748-b390508beb6c"
}'


curl --location --request PUT 'http://localhost:8083/customers/ce3e3cdb-5650-421d-8748-b390508beb6c/address' \
--header 'Content-Type: application/json' \
--data-raw '{
"city": "mumbai"
}'


