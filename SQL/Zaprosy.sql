-- 1.Вывести список самолетов с кодами 320, 321, 733

SELECT *
FROM AIRCRAFTS_DATA ad
WHERE ad.AIRCRAFT_CODE IN ('320', '321', '733')

-- 2.Вывести список самолетов с кодом не на 3

SELECT *
FROM AIRCRAFTS_DATA ad
WHERE ad.AIRCRAFT_CODE NOT LIKE ('3%')

-- 3.Найти билеты оформленные на имя «OLGA», с емайлом «OLGA» или без емайла

SELECT *
FROM TICKETS tf
WHERE PASSENGER_NAME LIKE ('OLGA%')
AND (EMAIL LIKE ('olga%') OR EMAIL IS NULL)

-- 4.Найти самолеты с дальностью полета 5600, 5700. Отсортировать список по убыванию дальности полета

SELECT *
FROM AIRCRAFTS_DATA ad 
WHERE ad.RANGE IN ('5600', '5700')
ORDER BY RANGE DESC

-- 5.Найти аэропорты в Moscow. Вывести название аэропорта вместе с городом. Отсортировать по полученному названию

SELECT AIRPORT_NAME, CITY
FROM AIRPORTS_DATA ad
WHERE ad.CITY = 'Moscow'
ORDER BY AIRPORT_NAME

-- 6.Вывести список всех городов без повторов в зоне «Europe»

SELECT DISTINCT CITY, TIMEZONE 
FROM AIRPORTS_DATA ad
WHERE TIMEZONE LIKE 'Europe%'

-- 7.Найти бронирование с кодом на «3A4» и вывести сумму брони со скидкой 10%

SELECT BOOK_REF, (TOTAL_AMOUNT * 0.9) 
FROM BOOKINGS b 
WHERE BOOK_REF LIKE '3A4%'

-- 8.Вывести все данные по местам в самолете с кодом 320 и классом «Business» строками вида «Данные по месту: номер места 1», «Данные по месту: номер места 2» … и тд

SELECT 'Location data ' || SEAT_NO || ': ' || FARE_CONDITIONS AS Info
FROM SEATS s
WHERE AIRCRAFT_CODE = '320' 
AND FARE_CONDITIONS = 'Business'

-- 9.Найти максимальную и минимальную сумму бронирования в 2017 году

SELECT MIN(TOTAL_AMOUNT), MAX(TOTAL_AMOUNT) 
FROM BOOKINGS b 
WHERE TO_CHAR(BOOK_DATE, 'yyyy') = 2017

-- 10.Найти количество мест во всех самолетах, вывести в разрезе самолетов

SELECT AIRCRAFT_CODE , COUNT(SEAT_NO)
FROM SEATS s 
GROUP BY AIRCRAFT_CODE

--  11.Найти количество мест во всех самолетах с учетом типа места, вывести в разрезе самолетов и типа мест

SELECT AIRCRAFT_CODE, COUNT(FARE_CONDITIONS), FARE_CONDITIONS  
FROM SEATS s 
GROUP BY AIRCRAFT_CODE, FARE_CONDITIONS
ORDER BY AIRCRAFT_CODE

-- 12.Найти количество билетов пассажира ALEKSANDR STEPANOV, телефон которого заканчивается на 11
-- В запросе решил указать уникальным идентификатором человека номер телефона. Таким образом получилось 23 разных человека с одинаковыми ФИО.
-- Можно в запросе указать COUNT(PASSENGER_NAME) для получения человека с 23 билетами.

SELECT PASSENGER_NAME, PHONE, count(PHONE) 
FROM TICKETS
WHERE PASSENGER_NAME = 'ALEKSANDR STEPANOV'
AND PHONE LIKE '%11'
GROUP BY PASSENGER_NAME, PHONE 



-- 13.Вывести всех пассажиров с именем ALEKSANDR, у которых количество билетов больше 2000. Отсортировать по убыванию количества билетов

SELECT PASSENGER_NAME, count(PASSENGER_NAME) AS COUNT
FROM TICKETS
WHERE PASSENGER_NAME LIKE 'ALEKSANDR %'
HAVING count(PASSENGER_NAME) > 2000
GROUP BY PASSENGER_NAME
ORDER BY COUNT DESC 

-- 14.Вывести дни в сентябре 2017 с количеством рейсов больше 500

SELECT TRUNC(SCHEDULED_DEPARTURE, 'DD')
FROM LANIT.FLIGHTS f 
WHERE TO_CHAR(f.SCHEDULED_DEPARTURE, 'yyyy-mm') = '2017-09'
GROUP BY TRUNC(SCHEDULED_DEPARTURE, 'DD')
HAVING COUNT(SCHEDULED_DEPARTURE) > '500'
ORDER BY TRUNC(SCHEDULED_DEPARTURE, 'DD')

-- 15.Вывести список городов, в которых несколько аэропортов

SELECT CITY, COUNT(AIRPORT_NAME)
FROM AIRPORTS_DATA ad
GROUP BY CITY
HAVING COUNT(AIRPORT_NAME) > 1

--  16.Вывести модель самолета и список мест в нем, т.е. на самолет одна строка результата

SELECT ad.MODEL, COUNT(SEAT_NO)
FROM SEATS s
JOIN AIRCRAFTS_DATA ad ON s.AIRCRAFT_CODE = ad.AIRCRAFT_CODE 
GROUP BY ad.MODEL  

-- 17.Вывести информацию по всем рейсам из аэропортов в г.Москва за сентябрь 2017

SELECT f.FLIGHT_ID, f.SCHEDULED_DEPARTURE, f.DEPARTURE_AIRPORT, ad.AIRPORT_NAME, ad.CITY
FROM FLIGHTS f
JOIN AIRPORTS_DATA ad ON f.DEPARTURE_AIRPORT = ad.AIRPORT_CODE 
WHERE SCHEDULED_DEPARTURE BETWEEN TO_DATE('2017-09-01', 'yyyy-mm-dd') AND  TO_DATE('2017-09-30', 'yyyy-mm-dd')
AND ad.CITY = 'Moscow'

-- 18.Вывести кол-во рейсов по каждому аэропорту в г.Москва за 2017

SELECT f.DEPARTURE_AIRPORT,ad.AIRPORT_NAME, COUNT(f.DEPARTURE_AIRPORT)
FROM LANIT.FLIGHTS f
JOIN LANIT.AIRPORTS_DATA ad ON f.DEPARTURE_AIRPORT = ad.AIRPORT_CODE 
WHERE SCHEDULED_DEPARTURE BETWEEN TO_DATE('2017-01-01', 'yyyy-mm-dd') AND TO_DATE('2017-12-31', 'yyyy-mm-dd')
AND ad.CITY = 'Moscow'
GROUP BY f.DEPARTURE_AIRPORT, ad.AIRPORT_NAME

-- 19.Вывести кол-во рейсов по каждому аэропорту, месяцу в г.Москва за 2017

SELECT DEPARTURE_AIRPORT, TO_CHAR(SCHEDULED_DEPARTURE, 'yyyy-mm'), COUNT(FLIGHT_NO)
FROM LANIT.FLIGHTS f JOIN LANIT.AIRPORTS_DATA ad ON f.DEPARTURE_AIRPORT = ad.AIRPORT_CODE
WHERE CITY = 'Moscow'
AND TO_CHAR(SCHEDULED_DEPARTURE, 'yyyy') = '2017'
GROUP BY DEPARTURE_AIRPORT, TO_CHAR(SCHEDULED_DEPARTURE, 'yyyy-mm')
ORDER BY TO_CHAR(SCHEDULED_DEPARTURE, 'yyyy-mm')

-- 20.Найти все билеты по бронированию на «3A4B»

SELECT BOOK_REF 
FROM TICKETS t 
WHERE BOOK_REF LIKE '3A4B%'

--  21.Найти все перелеты по бронированию на «3A4B»

SELECT * 
FROM TICKET_FLIGHTS tf
JOIN TICKETS t ON tf.TICKET_NO = t.TICKET_NO 
JOIN FLIGHTS f ON tf.FLIGHT_ID = f.FLIGHT_ID
WHERE t.BOOK_REF LIKE '3A4B%'
