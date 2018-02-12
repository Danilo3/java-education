SELECT * FROM testdb.Student where testdb.Student.STUD_ID iN(select STUD_ID from testdb.Mark where Mark=5 AND SUB_ID = (SELECT SUB_ID from testdb.Subject WHERE SUB_NAME ="Math"));

select * From Student left join Mark on Student.STUD_ID = Mark.STUD_ID  right join testdb.Subject on Mark.SUB_ID = Subject.idSubject where Mark=5 and SUB_NAME="Math"; 

select STUD_NAME FROM Student inner join Mark on Student.STUD_ID = Mark.STUD_ID Group by Student.STUD_NAME HAVING SUM(Mark)>0;