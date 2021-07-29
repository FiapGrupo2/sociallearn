package br.com.fiap.sociallearn.main

import android.app.Application
import br.com.fiap.sociallearn.main.di.DataModules
import br.com.fiap.sociallearn.main.di.ViewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)

            modules(
                DataModules.modules + ViewModelModules.modules
            )
        }
    }
}