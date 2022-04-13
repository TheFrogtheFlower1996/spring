
查找有重复email中id最小的数据 



删除 除了最小id 的其他重复数据

~~~sql
delete from Person 
where id not in (
    select id from (
        select min(id) id from Person group by email having count(*) > 1)
)



~~~




