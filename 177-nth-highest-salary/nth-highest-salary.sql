CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
set n = n -1 ;
  RETURN (
      # Write your MySQL query statement below.
    select distinct salary from employee order by salary desc limit 1 offset n 
  );
END

#offset ..If you want to find the $3^{rd}$ person in a queue, you tell the first 2 ($N-1$) people to step aside (OFFSET) and then talk to the very next person (LIMIT 1).

#-- We must adjust N because OFFSET is 0-indexed.
  -- To get the 1st highest, we OFFSET 0. To get the 2nd, we OFFSET 1.