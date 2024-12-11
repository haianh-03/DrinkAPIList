use DrinkManagement;
go

insert into Brand([Name]) values 
(N'Pepsi'),
(N'Coca Cola'),
(N'Sting'),
(N'7up'),
(N'RedBull')
(N'Aquafina');

insert into Category([Name]) values
(N'Soda'),
(N'Trà sữa'),
(N'Cà phê'),
(N'Nước ngọt');

insert into Drink([Name], Quantity, Price, CategoryID, BrandID) values
(N'Pepsi', 10, 15000, 4, 1),
(N'Pepsi vị chanh không calo', 10, 15000, 4, 1),
(N'Pepsi không calo', 10, 15000, 4, 1),
(N'Pepsi Light', 10, 15000, 4, 1),
(N'Coca Cola plus', 20, 15000, 4, 2),
(N'Coca Cola không đường', 30, 15000, 4, 2),
(N'Coca Cola', 5, 15000, 4, 2),
(N'Sting đỏ', 25, 15000, 4, 3),
(N'Sting vàng', 50, 15000, 4, 3),
(N'7up', 12, 15000, 4, 4),
(N'RedBull', 100, 15000, 4, 5),
(N'Nước suối', 100, 15000, 4, 6),
(N'Soda bạc hà', 50, 25000, 1, null),
(N'Soda việt quất', 50, 25000, 1, null),
(N'Soda Chanh', 50, 25000, 1, null),
(N'Trà sữa trân châu', 50, 30000, 2, null),
(N'Sữa tươi trân châu đường đen', 30, 30000, 2, null),
(N'Trà sữa lài', 20, 30000, 2, null),
(N'Cà phê đá', 60, 20000, 3, null),
(N'Cà phê sữa đá', 40, 20000, 3, null),
(N'Cà phê đen', 35, 20000, 3, null);

insert into Size([Name]) values
('Vừa'),
('Lớn'),
('Đại');

