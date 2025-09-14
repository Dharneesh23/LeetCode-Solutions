# Write your MySQL query statement below
Select c.name AS Customers from Customers c left join Orders o on c.id = o.customerId where o.id is null;