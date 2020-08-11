# Search Service

## Elastic DB
Run *docker-compose up -d* to bring up Elastic Search image

## Data Loader
hitting POST /createData will trigger 100 records to be added to the DB

## Querying Elastic
To get data back out of elastic, hit the elastic api directly.

Sample Queries:
```$xslt
curl --location --request GET 'localhost:9200/something/_search?pretty' \
--header 'Content-Type: application/json' \
--data-raw '{
    "query": {
        "match": {
            "order": 1
        }
    }
}'
```
```$xslt
curl --location --request GET 'localhost:9200/something/_search?pretty' \
--header 'Content-Type: application/json' \
--data-raw '{
    "query": {
        "wildcard": {
            "name": "Ca*"
        }
    }
}'
```