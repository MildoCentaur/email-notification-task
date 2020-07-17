#Docker

##Postgres
In order to have a postgre database running in docker to have a logging/auditing information of every execution of the task. 
first run:
 
```docker run --name postgres-docker -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres```

access postgre thru command line 
```
docker exec -it postgres-docker bash
      psql -U postgres
      CREATE TABLE public.persons (id int PRIMARY KEY, 
                                   lastName varchar(255), 
                                   firstName varchar(255)
                                   );
```