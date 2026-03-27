package ru.kosterina.myfirstappp.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import ru.kosterina.myfirstappp.db.PostContract.Columns

class DbHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "myfirstapp.db"
        private const val DATABASE_VERSION = 1

        // SQL для создания таблицы
        private  val SQL_CREATE_POSTS =
            "CREATE TABLE ${PostContract.TABLE_NAME} (" +
                    "${Columns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "${Columns.AUTHOR} TEXT NOT NULL," +
                    "${Columns.AUTHOR_ID} INTEGER NOT NULL," +
                    "${Columns.CONTENT} TEXT NOT NULL," +
                    "${Columns.PUBLISHED} TEXT NOT NULL," +
                    "${Columns.LIKED_BY_ME} INTEGER NOT NULL DEFAULT 0," +
                    "${Columns.LIKES} INTEGER NOT NULL DEFAULT 0," +
                    "${Columns.SHARES} INTEGER NOT NULL DEFAULT 0," +
                    "${Columns.VIEWS} INTEGER NOT NULL DEFAULT 0," +
                    "${Columns.VIDEO} TEXT" +
                    ")"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Создаем таблицу при первом запуске
        db.execSQL(SQL_CREATE_POSTS)

        // Здесь можно добавить начальные данные
        insertInitialData(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // При обновлении версии удаляем старую таблицу и создаем новую
        // В реальном проекте здесь должна быть миграция данных
        db.execSQL("DROP TABLE IF EXISTS ${PostContract.TABLE_NAME}")
        onCreate(db)
    }

    private fun insertInitialData(db: SQLiteDatabase) {
        // Вставляем начальные посты для демонстрации
        val contentValues = android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Авто-магазин")
            put(Columns.AUTHOR_ID, 2)
            put(Columns.CONTENT, "Dodge Challenger — культовый американский маслкар с мощным двигателем V8.Главные особенности:Двигатель: 6.2-литровый Hemi V8Мощность: до 1025 л.с.Динамика: разгон до 100 км/ч за 1.6 секундыМаксимальная скорость: 346 км/чГабариты: длина 5 метровАвтомобиль сочетает классический американский дизайн с современными технологиями. Оснащён 8-ступенчатой АКПП и задним приводом.Challenger остаётся верным традициям мускул-каров, предлагая впечатляющую мощность в стильном купе.")
            put(Columns.PUBLISHED, "21 мая в 18:36")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 999)
            put(Columns.SHARES, 25)
            put(Columns.VIEWS, 5700)
            putNull(Columns.VIDEO)
        }
        db.insert(PostContract.TABLE_NAME, null, contentValues)

        // Второй пост с видео
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Тюнинг Авто")
            put(Columns.AUTHOR_ID, 3)
            put(Columns.CONTENT, "Автотюнинг: новые горизонты возможностей»Ваш автомобиль заслуживает лучшего! Узнайте о последних трендах в мире тюнинга и модернизации..")
            put(Columns.PUBLISHED, "22 мая в 10:15")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 342)
            put(Columns.SHARES, 89)
            put(Columns.VIEWS, 2300)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Формула скорости: Lamborghini Aventador SVJ")
            put(Columns.AUTHOR_ID, 4)
            put(Columns.CONTENT, "Абсолютный рекорд Нюрбургринга среди серийных автомобилей! Aventador SVJ демонстрирует, что значит настоящая мощность и контроль на пределе возможностей.")
            put(Columns.PUBLISHED, "23 мая в 09:42")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 1050)
            put(Columns.SHARES, 420)
            put(Columns.VIEWS, 8900)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Легенды ралли: Subaru Impreza WRC")
            put(Columns.AUTHOR_ID, 5)
            put(Columns.CONTENT, "Неукротимая Impreza возвращается в историю! Как японский седан стал королём гравия и покорил сердца фанатов ралли.")
            put(Columns.PUBLISHED, "26 мая в 13:40")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 5078)
            put(Columns.SHARES, 1234)
            put(Columns.VIEWS, 45000)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Классика автоспорта: Ford GT40")
            put(Columns.AUTHOR_ID, 6)
            put(Columns.CONTENT, "Легенда Ле-Мана возвращается! История победы GT40 над Ferrari и возрождения культового суперкара.")
            put(Columns.PUBLISHED, "29 мая в 10:00")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 100)
            put(Columns.SHARES, 1000)
            put(Columns.VIEWS, 10000)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Дрифт-культура: Nissan Skyline GT-R")
            put(Columns.AUTHOR_ID, 7)
            put(Columns.CONTENT, "Король дрифта в новом обличии! Skyline GT-R продолжает традиции легендарного R34 на современных трассах.")
            put(Columns.PUBLISHED, "25 мая в 23:50")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 40)
            put(Columns.SHARES, 20000)
            put(Columns.VIEWS, 30000)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Porsche 911: эволюция легенды")
            put(Columns.AUTHOR_ID, 8)
            put(Columns.CONTENT, "В 1960‑х Ford бросил вызов Ferrari в Ле‑Мане. После провалов 1964–1965 годов инженеры переработали GT40 — и в 1966‑м он финишировал первым, вторым и третьим, положив конец господству итальянцев. Легенда родилась!")
            put(Columns.PUBLISHED, "1 мая в 11:00")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 2000)
            put(Columns.SHARES, 1000)
            put(Columns.VIEWS, 3000)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Aston Martin Valhalla: гибрид мечты")
            put(Columns.AUTHOR_ID, 9)
            put(Columns.CONTENT, "Aston Martin Valhalla сочетает V6 с двойным турбонаддувом и электромотор — суммарно 950 л. с. Разгон до 100 км/ч — за 2,5 с, максимальная скорость — 330 км/ч. Футуристичный дизайн и гоночные технологии делают его одним из самых желанных гиперкаров 2024 года.")
            put(Columns.PUBLISHED, "2 мая в 23:59")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 900)
            put(Columns.SHARES, 300)
            put(Columns.VIEWS, 2000)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Mitsubishi Lancer Evolution: икона ралли")
            put(Columns.AUTHOR_ID, 10)
            put(Columns.CONTENT, "Mitsubishi Lancer Evolution — легенда ралли 90‑х и 2000‑х. Его секрет — в турбированном моторе 4G63T, системе полного привода S‑AWC и жёстком кузове.")
            put(Columns.PUBLISHED, "6 мая в 19:00")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 758)
            put(Columns.SHARES, 400)
            put(Columns.VIEWS, 2000)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "УАЗ‑452: друг бездорожья")
            put(Columns.AUTHOR_ID, 11)
            put(Columns.CONTENT, "Моя «Буханка» (УАЗ‑452) — не про комфорт, а про свободу. Жёстко, шумно, тряско — зато не подведёт там, где нет дорог.")
            put(Columns.PUBLISHED, "29 мая в 10:00")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 678)
            put(Columns.SHARES, 500)
            put(Columns.VIEWS, 1000)
            put(Columns.VIDEO, "https://yandex.ru/video/preview/1371008358255402968")
            db.insert(PostContract.TABLE_NAME, null, this)
        }
    }
}