create database DrinkManagement;
go 

use DrinkManagement;
go

create table Brand(
	BrandID int identity primary key,
	[Name] Nvarchar(100) not null
);

create table Category(
	CategoryID int identity primary key,
	[Name] Nvarchar(100) not null
);

create table Drink(
	DrinkID int identity primary key,
	[Name] Nvarchar(100) not null,
	Quantity int not null,
	Price int not null,
	CategoryID int,
	BrandID int,
	constraint FK_Brand foreign key (BrandID) references Brand(BrandID),
	constraint FK_Category foreign key (CategoryID) references Category(CategoryID)
);

create table Size(
	SizeID int identity primary key,
	[Name] Nvarchar(20) not null
);

create table Drink_Size(
	DrinkID int,
	SizeID int,
	constraint PK_Drink_Size primary key (DrinkID, SizeID),
	constraint FK_Drink foreign key (DrinkID) references Drink(DrinkID),
	constraint FK_Size foreign key (SizeID) references Size(SizeID)
);

