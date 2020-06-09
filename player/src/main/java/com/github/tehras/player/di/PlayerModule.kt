package com.github.tehras.player.di

import com.github.tehras.player.search.PlayerSearchWorkflow
import org.koin.dsl.module

val playerModule = module {
    factory { PlayerSearchWorkflow() }
}