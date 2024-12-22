create database DrinkOrder;
go

use DrinkOrder;
go

create table Category(
	CategoryID int identity primary key,
	CategoryName Nvarchar(100) not null
);

create table Drink(
	DrinkID int identity primary key,
	DrinkName Nvarchar(100) not null,
	[Description] Nvarchar(300),
	CategoryID int,
	constraint FK_Category foreign key (CategoryID) references Category(CategoryID)
);

create table Size(
	SizeID int identity primary key,
	SizeName Nvarchar(30) not null
);

create table Drink_Size(
	DrinkID int,
	SizeID int,
	Price int,
	constraint PK_Drink_Size primary key (DrinkID, SizeID),
	constraint FK_DrinkS foreign key (DrinkID) references Drink(DrinkID),
	constraint FK_Size foreign key (SizeID) references Size(SizeID)
);

create table Topping(
	ToppingID int identity primary key,
	ToppingName Nvarchar(100) not null,
	ToppingPrice int
);

create table Drink_Topping(
	DrinkID int,
	ToppingID int,
	constraint PK_Drink_Topping primary key (DrinkID, ToppingID),
	constraint FK_DrinkT foreign key (DrinkID) references Drink(DrinkID),
	constraint FK_Topping foreign key (ToppingID) references Topping(ToppingID)
);