package com.sundaydavid989.aad440assignment

import android.app.Application
import com.sundaydavid989.aad440assignment.data.db.LearnersDatabase
import com.sundaydavid989.aad440assignment.data.network.*
import com.sundaydavid989.aad440assignment.data.repository.LearnersRepository
import com.sundaydavid989.aad440assignment.data.repository.LearnersRepositoryImpl
import com.sundaydavid989.aad440assignment.ui.hours.HoursViewModelFactory
import com.sundaydavid989.aad440assignment.ui.skill.SkillViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class LearnersApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@LearnersApplication))

        bind() from singleton { LearnersDatabase(instance()) }
        bind() from singleton { instance<LearnersDatabase>().learnersDao() }
        bind<ConnectivityInterceptor>() with singleton {ConnectivityInterceptorImpl(instance())}
        bind() from singleton { LearnersApiService(instance()) }
        bind<LearnersNetworkDataSource>() with singleton { LearnersNetworkDataSourceImpl(instance()) }
        bind<LearnersRepository>() with singleton { LearnersRepositoryImpl(instance(), instance()) }
        bind() from provider { HoursViewModelFactory(instance()) }
        bind() from provider { SkillViewModelFactory(instance()) }
    }
}