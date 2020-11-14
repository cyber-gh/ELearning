package dev.skyit.elearning

import android.app.Application
import dev.skyit.elearning.student.di.generalModule
import dev.skyit.elearning.student.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@BaseApp)

            modules(
                listOf(
                    generalModule,
                    viewModelsModule
                )
            )
        }
    }
}