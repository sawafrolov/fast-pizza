# Fast Pizza

CRUD API для пицц.

## Технологии

В проекте использованы технологии:
1. Kotlin.
2. Exposed (ORM framework for Kotlin).
3. Ktor.
4. PostgreSQL.
5. Kafka.
6. Gradle.
7. Docker.

## Описание MVP

В качестве MVP предполагается реализовать CRUD API для пицц:
1. Создания пиццы.
2. Получения списка пицц.
3. Получения пиццы по id.
4. Редактирования данных пиццы.
5. Удаления пиццы.

## Описание сущности пиццы

|    Поле     |  Тип данных  |          Описание          |
|:-----------:|:------------:|:--------------------------:|
|    uuid     |     UUID     |  Уникальный идентификатор  |
|    name     |    String    |          Название          |
| description |   String?    |          Описание          |
|   weight    |     Int      |      Масса в граммах       |
|    price    |  BigDecimal  |       Цена в рублях        |
| ingredients | List[String] |    Список ингридиентов     |
