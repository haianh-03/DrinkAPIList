insert into Category(CategoryName) values
(N'Trà sữa'),
(N'Trà Trái Cây'),
(N'Cà phê');

insert into Drink(DrinkName, [Description], CategoryID) values
(N'Oolong Sữa Hạnh Nhân',
N'Oolong Tứ Quý đượm hương sánh đôi cùng sữa hạnh nhân béo bùi, thơm ngon gấp bội. Mùa hội, HẠNH phúc NHÂN đôi khi thưởng thức bên người thương bạn nhé!',
1),
(N'Oolong Sữa Hạnh Nhân Trân Châu Hoàng Kim',
N'Oolong Tứ Quý sữa hạnh nhân đượm hương sánh đôi cùng Trân Châu Hoàng Kim dẻo mềm, hấp dẫn gấp bội. Mùa hội, HẠNH phúc NHÂN đôi khi thưởng thức bên người thương bạn nhé!',
1),
(N'Trà Sữa Oolong Tứ Quý Sương Sáo',
N'Trà Oolong Tứ Quý ngạt ngào hoa cỏ mùa xuân, hòa quyện cùng sữa thơm mịn màng, sương sáo thanh mát. Đó là Lộc Yêu Yêu ngọt ngào mà Nhà gửi gắm đến bạn.',
1),
(N'Oolong Tứ Quý Dâu Trân Châu',
N'Sảng khoái với vị dâu chín mọng chua thanh. Nền trà Oolong Tứ Quý đậm hương, ngọt thanh hậu vị. Thêm tận hưởng với trân châu trắng giòn dai.',
2),
(N'Oolong Tứ Quý Kim Quất Trân Châu',
N'Đậm hương trà, sảng khoái du xuân cùng Oolong Tứ Quý Kim Quất Trân Châu. Vị nước cốt kim quất tươi chua ngọt, thêm trân châu giòn dai.',
2),
(N'Trà Đào Cam Sả',
N'Vị thanh ngọt của đào, vị chua dịu của Cam Vàng nguyên vỏ, vị chát của trà đen tươi được ủ mới mỗi 4 tiếng, cùng hương thơm nồng đặc trưng của sả chính là điểm sáng làm nên sức hấp dẫn của thức uống này.',
2),
(N'Bạc Sỉu',
N'Bạc sỉu chính là "Ly sữa trắng kèm một chút cà phê". Thức uống này rất phù hợp những ai vừa muốn trải nghiệm chút vị đắng của cà phê vừa muốn thưởng thức vị ngọt béo ngậy từ sữa.',
3),
(N'Cà Phê Đen Đá',
N'Không ngọt ngào như Bạc sỉu hay Cà phê sữa, Cà phê đen mang trong mình phong vị trầm lắng, thi vị hơn. Người ta thường phải ngồi rất lâu mới cảm nhận được hết hương thơm ngào ngạt, phảng phất mùi cacao và cái đắng mượt mà trôi tuột xuống vòm họng.',
3),
(N'Cà Phê Sữa Đá',
N'Cà phê Đắk Lắk nguyên chất được pha phin truyền thống kết hợp với sữa đặc tạo nên hương vị đậm đà, hài hòa giữa vị ngọt đầu lưỡi và vị đắng thanh thoát nơi hậu vị.',
3);

insert into Size(SizeName) values
(N'Nhỏ'),
(N'Vừa'),
(N'Lớn');

insert into Drink_Size(DrinkID, SizeID, Price) values
(1, 2, 55000),
(2, 2, 59000),
(3, 2, 55000),
(3, 3, 59000),
(4, 1, 49000),
(4, 2, 59000),
(4, 3, 65000),
(5, 1, 49000),
(5, 2, 59000),
(5, 3, 65000),
(6, 1, 49000),
(6, 2, 59000),
(6, 3, 65000),
(7, 1, 29000),
(7, 2, 39000),
(7, 3, 45000),
(8, 1, 29000),
(8, 2, 39000),
(8, 3, 45000),
(9, 1, 29000),
(9, 2, 39000),
(9, 3, 45000);

insert into Topping(ToppingName, ToppingPrice) values
(N'Trân Châu',10000),
(N'Trân Châu Hoàng Kim',10000),
(N'Sương Sáo',10000),
(N'Đào',10000);

insert into Drink_Topping(DrinkID, ToppingID) values
(2,2),
(3,3),
(4,1),
(5,1),
(6,4);

select * from Drink;
select * from Drink_Size;
select * from Drink_Topping;

select Drink.DrinkID, Drink.DrinkName, Drink_Size.Price
from Drink
inner join Drink_Size
on Drink.DrinkID = Drink_Size.DrinkID;

select Drink.DrinkID, Drink.DrinkName, Drink.[Description], Size.SizeName, Topping.ToppingName, Drink_Size.Price
from Drink 
left join Drink_Topping
on Drink.DrinkID = Drink_Topping.DrinkID
inner join Drink_Size
on Drink.DrinkID = Drink_Size.DrinkID
inner join Size
on Drink_Size.SizeID = Size.SizeID
left join Topping
on Drink_Topping.ToppingID = Topping.ToppingID

select Drink.DrinkID, Drink.DrinkName, Drink.[Description], Size.SizeName, Topping.ToppingName, Drink_Size.Price
from Drink 
left join Drink_Topping
on Drink.DrinkID = Drink_Topping.DrinkID
inner join Drink_Size
on Drink.DrinkID = Drink_Size.DrinkID
inner join Size
on Drink_Size.SizeID = Size.SizeID
left join Topping
on Drink_Topping.ToppingID = Topping.ToppingID
where Drink.DrinkID = 9;
