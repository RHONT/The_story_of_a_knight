<h1 align="left">Описание</h1> 

Суть игры в том, что персонаж идет по сюжету и сражается с монстрами.  
Реализовано: 
- повышение уровня
- покупка предметов
- Возможность битвы с множеством противников
- есть броня на каждой части тела(указано в квадратных скобках)
- выбор куда ударить
- Магазины
- Привал, после боя

С каждым подходом я стараюсь сделать так, чтобы расширение игры не предоставляло сложностей. Реализую принципы SOLID к этому продукту.

<h3 align="center">Игровой процесс</h3>
Механика смерти достаточно просто. Если одна из частей тела убивается полностью, то засчитывается смерть.  Шанс попасть по каждой части тела разнится. Если бросить в противника коктейль Молотова, то у него резко снизится шанс попасть по вам.

![1](https://user-images.githubusercontent.com/96048104/190129002-97e93afe-80ee-4290-9f29-414f56a743be.jpg)

![2](https://user-images.githubusercontent.com/96048104/190133905-6ca66eac-03d9-4055-8067-7ab3b8b3fe89.jpg)

По дороге встречается магазин, где можно пополнить запасы
![Shop](https://user-images.githubusercontent.com/96048104/190132936-0075d62e-c90f-42b8-99ff-57b96ce05b9b.jpg)

После боя герой устраивает привал, где может подготовиться к следующей битве
![Halt](https://user-images.githubusercontent.com/96048104/190132717-6a4693ac-4d1d-43b1-b215-cef3791272d4.jpg)

Повышение уровня носит литературный характер. Читая текст можно догадаться, какая из характеристик повысится.<br>
![Shop](https://user-images.githubusercontent.com/96048104/190132936-0075d62e-c90f-42b8-99ff-57b96ce05b9b.jpg)

P.S.<br>
Для теста я ввел магию. Введите символ "w" и мощный ветер будет проноситься через всех врагов нанося мощный урон.

Запуск игры:
В корне лежит game.jar
кодировка cp-1251
