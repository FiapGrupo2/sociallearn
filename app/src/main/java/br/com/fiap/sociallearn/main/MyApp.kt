package br.com.example.sociallearn.main

import android.app.Application
import br.com.example.sociallearn.main.di.DataModules
import br.com.example.sociallearn.main.di.ViewModelModules
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                DataModules.modules + ViewModelModules.modules
            )
        }
    }
}