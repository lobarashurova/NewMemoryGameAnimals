package uz.mlsoft.newmemorygameanimals.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.mlsoft.newmemorygameanimals.domain.GameRepository
import uz.mlsoft.newmemorygameanimals.domain.impl.GameRepositoryImpl
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @[Binds Singleton]
    fun bindRepository(impl: GameRepositoryImpl): GameRepository
}