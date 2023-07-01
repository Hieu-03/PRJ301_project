
Create table Book 
		(bookId int identity(1,1) primary key, bookName varchar(50) not null, price money not null, image varchar(30) not null)

Create table Account 
		(userId int identity(1,1) primary key, userName nvarchar(20) not null, userPassword varchar(20) not null, email varchar(254) not null unique, phoneNumber varchar(10))

CREATE TABLE Cart
		(cartId int identity(1,1) PRIMARY KEY, userId int FOREIGN KEY REFERENCES Account(userId) not null, bookId int FOREIGN KEY REFERENCES Book (bookId) not null, quantity int not null)

select * from Account

insert into Book (bookName, price, image)
values	('Java Servlet', 150000, './Image/servlet.jpg'),
		('Tomcat', 120000, './Image/tomcat.jpg'),
		('JSP', 200000, './Image/jsp.jpg'),
		('MVC Project', 180000, './Image/mvc.jpg'),
		('JavaEE 7', 140000, './Image/javaee7.jpg'),
		('C# (C sharp)', 230000, './Image/Csharp.jpg'),
		('EJB 2', 195000, './Image/EJB2.jpg'),
		('EJB 3', 150000, './Image/EJB3.jpg'),
		('JBoss at Work', 170000, './Image/Jboss.jpg'),
		('Python', 185000, './Image/Python.jpg');

		Select * From Cart where userId = 3 and bookId = 1
		Update Cart set quantity = 2 where userId = 1 and bookId = 2