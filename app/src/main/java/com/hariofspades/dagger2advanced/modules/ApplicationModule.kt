package com.hariofspades.dagger2advanced.modules

import dagger.Module

@Module(includes = [ServicesModule::class, RandomUsersApiModule::class, PicassoModule::class])
public class ApplicationModule