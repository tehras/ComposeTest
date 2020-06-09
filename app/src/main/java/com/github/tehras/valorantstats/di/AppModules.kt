package com.github.tehras.valorantstats.di

import com.github.tehras.player.di.playerModule

// Main Koin Module.
val appModule = listOf(homeModule, playerModule)
