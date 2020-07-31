package com.goth4m.tiki.di.module

import com.goth4m.tiki.ui.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        HomeViewModel(get())
    }
}
