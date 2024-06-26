package com.morozov.navigation.di.annotations

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatchers: AppDispatchers)

enum class AppDispatchers {
    IO,
    MAIN,
    DEFAULT,
}
