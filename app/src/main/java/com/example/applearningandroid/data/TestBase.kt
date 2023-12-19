package com.example.applearningandroid.data

import com.example.applearningandroid.data.model.Category
import com.example.applearningandroid.data.model.Topic
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class TestBase {


    val categoryNames = listOf("Kotlin", "Android_fundamentals", "UI", "OOP", "Architecture",
        "Background_work", "Navigation", "Git", "Data", "Network", "Multitasking", "Debugging",)

    val categoriesRef = Firebase.database.getReference("Categories")

    val categoryRefs = categoryNames.map { categoriesRef.child(it) }

    fun test() {
        val kotlinRef = categoryRefs[0]
        val androidFundamentalsRef = categoryRefs[1]
        val uiRef = categoryRefs[2]
        val oopRef = categoryRefs[3]
        val architectureRef = categoryRefs[4]
        val backgroundWorkRef = categoryRefs[5]
        val navigationRef = categoryRefs[6]
        val dataRef = categoryRefs[7]
        val networkRef = categoryRefs[8]
        val gitRef = categoryRefs[9]
        val multitaskingRef = categoryRefs[10]
        val debuggingRef = categoryRefs[11]

        kotlinRef.child("list_of_topics").child("Kotlin_tutorials_1").setValue(Topic(1,"История Kotlin", "about kotlin.."))
        kotlinRef.child("list_of_topics").child("Kotlin_tutorials_2").setValue(Topic(2,"Переменные в Kotlin", "about kotlin.."))
        kotlinRef.child("list_of_topics").child("Kotlin_tutorials_3").setValue(Topic(3,"Операторы if и when", "about kotlin.."))
        kotlinRef.child("list_of_topics").child("Kotlin_tutorials_4").setValue(Topic(4,"Циклы", "about kotlin.."))
        kotlinRef.child("list_of_topics").child("Kotlin_tutorials_5").setValue(Topic(5,"Классы", "about kotlin.."))
        kotlinRef.child("list_of_topics").child("Kotlin_tutorials_6").setValue(Topic(6,"Наследование и переопределение", "about kotlin.."))
        kotlinRef.child("list_of_topics").child("Kotlin_tutorials_7").setValue(Topic(7,"Массивы, списки, итераторы", "about kotlin.."))
        kotlinRef.child("list_of_topics").child("Kotlin_tutorials_8").setValue(Topic(8,"Top-level функции", "about kotlin.."))
        /*
        kotlinRef.child("Kotlin_tutorials_1").setValue(Topic("История Kotlin", "about kotlin.."))
        kotlinRef.child("Kotlin_tutorials_2").setValue(Topic("Переменные в Kotlin", "about kotlin.."))
        kotlinRef.child("Kotlin_tutorials_3").setValue(Topic("Операторы if и when", "about kotlin.."))
        kotlinRef.child("Kotlin_tutorials_4").setValue(Topic("Циклы", "about kotlin.."))
        kotlinRef.child("Kotlin_tutorials_5").setValue(Topic("Классы", "about kotlin.."))
        kotlinRef.child("Kotlin_tutorials_6").setValue(Topic("Наследование и переопределение", "about kotlin.."))
        kotlinRef.child("Kotlin_tutorials_7").setValue(Topic("Массивы, списки, итераторы", "about kotlin.."))
        kotlinRef.child("Kotlin_tutorials_8").setValue(Topic("Top-level функции", "about kotlin.."))


        androidFundamentalsRef.child("Kotlin_tutorials_1").setValue(Topic("История Kotlin", "about kotlin.."))
        uiRef.child("Kotlin_tutorials_1").setValue(Topic("История Kotlin", "about kotlin.."))
        oopRef.child("Kotlin_tutorials_1").setValue(Topic("История Kotlin", "about kotlin.."))
        architectureRef.child("Kotlin_tutorials_1").setValue(Topic("История Kotlin", "about kotlin.."))
        backgroundWorkRef.child("Kotlin_tutorials_1").setValue(Topic("История Kotlin", "about kotlin.."))
        navigationRef.child("Kotlin_tutorials_1").setValue(Topic("История Kotlin", "about kotlin.."))
        dataRef.child("Kotlin_tutorials_1").setValue(Topic("История Kotlin", "about kotlin.."))
        networkRef.child("Kotlin_tutorials_1").setValue(Topic("История Kotlin", "about kotlin.."))
        gitRef.child("Kotlin_tutorials_1").setValue(Topic("История Kotlin", "about kotlin.."))
        multitaskingRef.child("Kotlin_tutorials_1").setValue(Topic("История Kotlin", "about kotlin.."))
        debuggingRef.child("Kotlin_tutorials_1").setValue(Topic("История Kotlin", "about kotlin.."))

         */
    }
}


/*
Уроки по Kotlin:
Основы языка Kotlin.
Операторы и выражения.
Коллекции и структуры данных.

Основы Android-разработки:
Создание нового проекта.
Работа с макетами и интерфейсом.
Жизненный цикл активити и фрагментов.

Взаимодействие с пользователем:
Работа с кнопками и полями ввода.
Обработка событий касания.
Уведомления и Toast.


Работа с данными:
Работа с базой данных SQLite.
Использование SharedPreferences.
Загрузка данных из Интернета.

Многозадачность и фоновые задачи:
Использование AsyncTask.
Работа с потоками и обработка задач в фоне

Отладка и профилирование:
Использование Android Studio для отладки.
Профилирование производительности.

Продвинутые темы:
Архитектурные паттерны (например, MVVM).
Dagger и зависимости.
Работа с сенсорами и камерой устройства.
Примеры проектов:

Несколько простых проектов, которые пользователь может создать, следуя вашим урокам.
Ресурсы и дополнительные материалы:

Ссылки на официальную документацию Android и Kotlin.
Рекомендуемые учебники и статьи.
Форум или чат для общения:

Место, где пользователи могут задавать вопросы и обсуждать проблемы.
 */