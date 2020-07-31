package com.goth4m.tiki.di.module

import com.goth4m.tiki.repo.HomeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { HomeRepository(get()) }
}