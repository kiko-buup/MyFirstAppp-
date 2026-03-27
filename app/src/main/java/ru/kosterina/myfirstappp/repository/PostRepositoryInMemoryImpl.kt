package ru.kosterina.myfirstappp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.kosterina.myfirstappp.dto.Post
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class PostRepositoryInMemoryImpl : PostRepository {

    // Счетчик для генерации ID
    private var nextId = 5L

    // Текущий пользователь (для демонстрации)
    private val currentUserId = 1L
    private val currentUserName = "Я"

    // Теперь это список, а не один пост
    private var posts = listOf(
        Post(
            id = 1,
            author = "Авто-магазин",
            authorId = 2,
            content = "Dodge Challenger — культовый американский маслкар с мощным двигателем V8.Главные особенности:Двигатель: 6.2-литровый Hemi V8Мощность: до 1025 л.с.Динамика: разгон до 100 км/ч за 1.6 секундыМаксимальная скорость: 346 км/чГабариты: длина 5 метровАвтомобиль сочетает классический американский дизайн с современными технологиями. Оснащён 8-ступенчатой АКПП и задним приводом.Challenger остаётся верным традициям мускул-каров, предлагая впечатляющую мощность в стильном купе.",
            published = "21 мая в 18:36",
            likedByMe = false,
            likes = 999,
            shares = 25,
            views = 5700,
            video = null
        ),
        Post(
            id = 2,
            author = "Тюнинг Авто",
            authorId = 3,
            content = "«Автотюнинг: новые горизонты возможностей»Ваш автомобиль заслуживает лучшего! Узнайте о последних трендах в мире тюнинга и модернизации..",
            published = "22 мая в 10:15",
            likedByMe = false,
            likes = 342,
            shares = 89,
            views = 2300,
            video = null
        ),
        Post(
            id = 3,
            author = "Формула скорости: Lamborghini Aventador SVJ",
            authorId = 4,
            content = "Абсолютный рекорд Нюрбургринга среди серийных автомобилей! Aventador SVJ демонстрирует, что значит настоящая мощность и контроль на пределе возможностей.",
            published = "23 мая в 09:42",
            likedByMe = true,
            likes = 1050,
            shares = 420,
            views = 8900,
            video = null
        ),
        Post(
            id = 4,
            author = "Легенды ралли: Subaru Impreza WRC",
            authorId = 5,
            content = "Неукротимая Impreza возвращается в историю! Как японский седан стал королём гравия и покорил сердца фанатов ралли",
            published = "26 мая в 13:40",
            likedByMe = false,
            likes = 5078,
            shares = 1234,
            views = 45000,
            video = null

        ) ,
        Post(
            id = 5,
            author = "Классика автоспорта: Ford GT40",
            authorId = 6,
            content = "Легенда Ле-Мана возвращается! История победы GT40 над Ferrari и возрождения культового суперкара",
            published = "29 мая в 10:00",
            likedByMe = false,
            likes = 100,
            shares = 1000,
            views = 10000,
            video = null

        ),
        Post(
            id = 6,
            author = "Дрифт-культура: Nissan Skyline GT-R",
            authorId = 7,
            content = "Король дрифта в новом обличии! Skyline GT-R продолжает традиции легендарного R34 на современных трассах",
            published = "25 мая в 23:50",
            likedByMe = false,
            likes = 40,
            shares = 20000,
            views = 30000,
            video = null

        ),
        Post(
            id = 7,
            author = "Porsche 911: эволюция легенды",
            authorId = 8,
            content = "В 1960‑х Ford бросил вызов Ferrari в Ле‑Мане. После провалов 1964–1965 годов инженеры переработали GT40 — и в 1966‑м он финишировал первым, вторым и третьим, положив конец господству итальянцев. Легенда родилась!",
            published = "1 мая в 11:00",
            likedByMe = false,
            likes = 2000,
            shares = 1000,
            views = 3000,
            video = null

        ),
        Post(
            id = 8,
            author = "Aston Martin Valhalla: гибрид мечты",
            authorId = 9,
            content = "Aston Martin Valhalla сочетает V6 с двойным турбонаддувом и электромотор — суммарно 950 л. с. Разгон до 100 км/ч — за 2,5 с, максимальная скорость — 330 км/ч. Футуристичный дизайн и гоночные технологии делают его одним из самых желанных гиперкаров 2024 года",
            published = "2 мая в 23:59",
            likedByMe = false,
            likes = 900,
            shares = 300,
            views = 2000,
            video = null

        ),
        Post(
            id = 9,
            author = "Mitsubishi Lancer Evolution: икона ралли",
            authorId = 10,
            content = "Mitsubishi Lancer Evolution — легенда ралли 90‑х и 2000‑х. Его секрет — в турбированном моторе 4G63T, системе полного привода S‑AWC и жёстком кузове.",
            published = "6 мая в 19:00",
            likedByMe = false,
            likes = 758,
            shares = 400,
            views = 2000,
            video = null

        ),
        Post(
            id = 10,
            author = "УАЗ‑452: друг бездорожья",
            authorId = 11,
            content = "Моя «Буханка» (УАЗ‑452) — не про комфорт, а про свободу. Жёстко, шумно, тряско — зато не подведёт там, где нет дорог.",
            published = "29 мая в 10:00",
            likedByMe = false,
            likes = 678,
            shares = 500,
            views = 1000,
            video ="https://yandex.ru/video/preview/1371008358255402968"

        ),
    )

    private val _data = MutableLiveData(posts)

    override fun getAll(): LiveData<List<Post>> = _data

    override fun likeById(id: Long) {
        posts = posts.map { post ->
            if (post.id == id) {
                post.copy(
                    likedByMe = !post.likedByMe,
                    likes = if (post.likedByMe) post.likes - 1 else post.likes + 1
                )
            } else {
                post
            }
        }
        _data.value = posts
    }

    override fun shareById(id: Long) {
        posts = posts.map { post ->
            if (post.id == id) {
                post.copy(shares = post.shares + 1)
            } else {
                post
            }
        }
        _data.value = posts
    }

    override fun increaseViews(id: Long) {
        posts = posts.map { post ->
            if (post.id == id) {
                post.copy(views = post.views + 1)
            } else {
                post
            }
        }
        _data.value = posts
    }
    override fun save(post: Post): Post {
        if (post.id == 0L) {
            // Создание нового поста
            val newPost = post.copy(
                id = nextId++,
                author = currentUserName,
                authorId = currentUserId,
                published = formatDate(Date()),
                likedByMe = false,
                likes = 0,
                shares = 0,
                views = 0
            )
            posts = listOf(newPost) + posts
        } else {
            // Обновление существующего поста
            posts = posts.map { existingPost ->
                if (existingPost.id == post.id) {
                    // Сохраняем автора, дату и счетчики, обновляем только контент
                    existingPost.copy(content = post.content)
                } else {
                    existingPost
                }
            }
        }
        _data.value = posts
        return TODO("Provide the return value")
    }

    override fun removeById(id: Long) {
        posts = posts.filter { it.id != id }
        _data.value = posts
    }

    private fun formatDate(date: Date): String {
        val format = SimpleDateFormat("d MMM в HH:mm", Locale("ru"))
        return format.format(date)
    }

}