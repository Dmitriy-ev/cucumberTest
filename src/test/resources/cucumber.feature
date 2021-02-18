#language: ru

@all
#noinspection NonAsciiCharacters
Функционал: Ипотека

  @smoke
  @checkMortgage
  Сценарий: Заявка на оформление ипотеки
    * Загружена стартовая страница
    * Переход в главное меню 'Ипотека'
    * Выбираем подменю 'Ипотека на готовое жильё'
    * Заполняем форму поле/значение
      | Стоимость недвижимости | 5180000 |
      | Первоначальный взнос   | 3058000 |
      | Срок кредита           | 30      |
    * Выбираем дополнительные опции
      | Скидка 0,3% при покупке квартиры на ДомКлик | false |
      | Страхование жизни и здоровья                | false |
      | Молодая семья                               | true  |
      | Электронная регистрация сделки              | false |
    * Проверяем поля и их значения
      | Сумма кредита      | 2122000 |
      | Ежемесячный платеж | 16922   |
      | Необходимый доход  | 21784   |
      | Процентная ставка  | 11      |
	  