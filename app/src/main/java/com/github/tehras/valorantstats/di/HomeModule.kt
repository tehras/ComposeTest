package com.github.tehras.valorantstats.di

import com.github.tehras.valorantstats.home.HomeWorkflow
import org.koin.dsl.module

val homeModule = module {
    factory { HomeWorkflow(get()) }
}