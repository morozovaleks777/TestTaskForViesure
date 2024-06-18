package com.morozov.testtaskforviesure.di


import com.morozov.testtaskforviesure.di.annotations.AppDispatchers
import com.morozov.testtaskforviesure.di.annotations.Dispatcher
import com.morozov.testtaskforviesure.navigation.NavigationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.ActivityRetainedLifecycle
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

@Module
@InstallIn(ActivityRetainedComponent::class)
object LifecycleModule {

    @ActivityRetainedScoped
    @Provides
    fun provideCoroutineScope(
        activityRetainedLifecycle: ActivityRetainedLifecycle,
    ): CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Default).also {
        activityRetainedLifecycle.addOnClearedListener { it.cancel() }
    }


    @ActivityRetainedScoped
    @Provides
    fun provideNavigationManager(
        @ActivityRetainedScoped coroutineScope: CoroutineScope,
        @Dispatcher(AppDispatchers.DEFAULT) dispatcher: CoroutineDispatcher,
    ): NavigationManager = NavigationManager(
        coroutineScope = coroutineScope,
        dispatcher = dispatcher
    )

}