package com.bbcnewschallenge.core.database.di

import com.bbcnewschallenge.core.domain.usecases.GetSqliteSecretKeyUseCase
import com.bbcnewschallenge.core.security.providers.SqliteCipherProvider
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    private const val DATABASE_NAME = "bbc_news_challenge_database"

//    @Provides
//    @Singleton
//    fun database(
//        @ApplicationContext context: Context,
//        buildConfigProvider: BuildConfigProvider,
//        sqliteCipherProvider: SqliteCipherProvider,
//        getSqliteSecretKeyUseCase: GetSqliteSecretKeyUseCase
//    ): Database = Room.databaseBuilder(
//        context,
//        Database::class.java,
//        DATABASE_NAME
//    )
//        .openHelperFactory(getSecretKey(getSqliteSecretKeyUseCase, sqliteCipherProvider))
//        .addTypeConverter(LocalDateTimeConverter())
//        .apply {
//            if (!buildConfigProvider.get.isRelease) {
//                setQueryCallback({ sqlQuery, bindArgs ->
//                    Log.i("SQLite", "SQL Query: $sqlQuery")
//                    if (bindArgs.isNotEmpty()) Log.i("SQLite", "SQL Args: $bindArgs")
//                }, Executors.newSingleThreadExecutor())
//            }
//        }
//        .build()

    private fun getSecretKey(
        getSqliteSecretKeyUseCase: GetSqliteSecretKeyUseCase,
        sqliteCipherProvider: SqliteCipherProvider
    ) = runBlocking {
        getSqliteSecretKeyUseCase()?.let { sqliteCipherProvider.getFactory(it) }
    }
}