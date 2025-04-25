create type demo.group(
                          name        text,
                          description text,
                          level       int,
                      );

create table if not exists demo.user_new
(
    id         uuid,
    firstname  text,
    lastname   text,
    role       text,
    created_at timestamp,
    salaries   list<int>,
    group      frozen<demo.group>,
    primary key ( (id), created_at)
) with clustering order by (created_at desc);