package com.jetpack.compose.practice.motivation.domain

import android.os.Build
import androidx.annotation.RequiresApi
import com.jetpack.compose.practice.motivation.core.QuotesDb
import com.jetpack.compose.practice.motivation.core.QuotesViewModel
import com.jetpack.compose.practice.motivation.core.utils.Preferences
import com.jetpack.compose.practice.motivation.core.utils.alarmManager.AlarmSchedulerImpl
import com.jetpack.compose.practice.motivation.data.local.entities.QuotesEntity
import com.jetpack.compose.practice.motivation.data.mappers.EntityModelMapper
import com.jetpack.compose.practice.motivation.data.mappers.QuotesEntityModelMapper
import com.jetpack.compose.practice.motivation.data.repo.QuotesRepositoryImpl
import com.jetpack.compose.practice.motivation.di.models.QuotesModel
import com.jetpack.compose.practice.motivation.di.usecase.QuoteAuthorUseCase
import com.jetpack.compose.practice.motivation.di.usecase.QuoteCategoriesUseCase
import com.jetpack.compose.practice.motivation.di.usecase.QuotesUseCase
import com.jetpack.compose.practice.motivation.presentation.author_screen.viewmodel.AuthorViewModel
import com.jetpack.compose.practice.motivation.presentation.categories_screen.viewmodel.CategoriesViewModel
import com.jetpack.compose.practice.motivation.presentation.explore_screen.viewmodel.ExploreViewModel
import com.jetpack.compose.practice.motivation.presentation.quote_of_day_screen.viewmodel.QuoteDayViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


@RequiresApi(Build.VERSION_CODES.O)
val appModules = module {
    single { QuotesDb.getDatabase(get()) }
    single { get<QuotesDb>().quotesDao() }
    single<EntityModelMapper<QuotesEntity, QuotesModel>> { QuotesEntityModelMapper() }
    single { QuotesRepositoryImpl(get(), get(), get()) }
    single { QuotesUseCase(get()) }
    single { QuoteAuthorUseCase(get()) }
    single { QuoteCategoriesUseCase(get()) }
    single { Preferences(get())}
    single { AlarmSchedulerImpl(get()) }
    viewModel { QuotesViewModel(get(), get(), get()) }
    viewModel { AuthorViewModel(get()) }
    viewModel { CategoriesViewModel(get()) }
    viewModel { QuoteDayViewModel(get()) }
    viewModel { ExploreViewModel() }
}

