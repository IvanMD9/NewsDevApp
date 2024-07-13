package com.example.network.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent : NetworkApi