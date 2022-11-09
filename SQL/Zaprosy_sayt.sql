-- 1

Select model, speed, hd
From PC
Where price<500

-- 2

Select DISTINCT maker
from Product
where type='Printer'

-- 3

Select model, ram, screen
from Laptop
where price > 1000

-- 4

Select *
from Printer
where color = 'y'

-- 5

Select model, speed, hd
from PC
where price < 600
and (CD = '12x' OR CD = '24x')

-- 6

Select DISTINCT product.maker, laptop.speed
from Product
JOIN
Laptop
ON product.model = laptop.model
where hd >= 10

-- 7

Select PC.model, PC.price
FROM PC
JOIN PRODUCT ON PC.model=product.model
WHERE Product.maker='B'
UNION
SELECT Laptop.model, Laptop.price
FROM Laptop
JOIN PRODUCT ON Laptop.model=product.model
WHERE Product.maker='B'
UNION
SELECT Printer.model, Printer.price
FROM Printer
JOIN PRODUCT ON Printer.model=product.model
WHERE Product.maker='B'

-- 8

SELECT DISTINCT maker  FROM Product  WHERE type = 'PC'
EXCEPT
SELECT DISTINCT maker  FROM Product  WHERE type = 'Laptop'

-- 9

Select DISTINCT maker
From Product
Where model IN (
Select model
From PC
Where speed >= 450)

-- 10

SELECT model, price
FROM Printer
WHERE price = (SELECT max(price) FROM Printer)

-- 11

Select avg(speed)
from pc

-- 12

Select avg(speed)
from laptop
where price > 1000

-- 13

Select avg(speed)
from pc
where model IN(
SELECT model
from Product
Where maker = 'A')

-- 14

Select s.class, name, country
from ships s
join classes c on s.class = c.class
where numGuns >= 10

-- 15

Select hd
From pc
group by hd
having count(hd) >=2

-- 16

SELECT P.model, L.model, P.speed, P.ram
FROM PC P JOIN 
     (SELECT speed, ram
      FROM PC
      GROUP BY speed, ram
      HAVING SUM(speed)/speed = 2 AND 
             SUM(ram)/ram = 2 
      ) S ON P.speed = S.speed AND 
             P.ram = S.ram JOIN 
      PC L ON L.speed = S.speed AND 
              L.ram = S.ram AND 
              L.model < P.model;

-- 17

Select DISTINCT type, p.model, speed
from laptop l
JOIN Product p ON p.model = l.model
where speed < (Select MIN(speed) From PC)

-- 18
Select p.maker, pr.price
From Product p
Join Printer pr on p.model = pr.model
where pr.price =
(Select min(price)
From printer
where color = 'y')
AND color = 'y'

--19

Select p.maker, AVG(l.screen)
From Laptop l
JOIN Product p on l.model = p.model
GROUP BY p.maker

--20

Select  p.maker, count(DISTINCT pc.model)
from product p 
JOIN PC pc on p.model = pc.model
GROUP BY p.maker
HAVING count(DISTINCT pc.model)>=3

--21

Select p.maker, max(pc.price)
from product p
JOIN PC pc On p.model = pc.model
GROUP BY p.maker
