create index IX_32FFC8AE on STD_Courses_Teachers (companyId);
create index IX_B43A1D93 on STD_Courses_Teachers (teacherId);

create index IX_955E62F5 on STD_Students_Courses (companyId);
create index IX_400099B3 on STD_Students_Courses (studentId);

create index IX_8EF0E544 on STD_Students_Parents (companyId);
create index IX_39931C02 on STD_Students_Parents (studentId);

create index IX_180A1C6 on STD_Students_Teachers (companyId);
create index IX_82BAF6AB on STD_Students_Teachers (teacherId);

create index IX_2C6A188C on ST_Courses_Teachers (companyId);
create index IX_ADA46D71 on ST_Courses_Teachers (teacherId);

create index IX_8EC8B2D3 on ST_Students_Courses (companyId);
create index IX_396AE991 on ST_Students_Courses (studentId);

create index IX_885B3522 on ST_Students_Parents (companyId);
create index IX_32FD6BE0 on ST_Students_Parents (studentId);

create index IX_35604DA8 on ST_Students_Teachers (companyId);
create index IX_B69AA28D on ST_Students_Teachers (teacherId);