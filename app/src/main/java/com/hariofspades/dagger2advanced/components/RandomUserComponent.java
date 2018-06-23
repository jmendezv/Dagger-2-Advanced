package com.hariofspades.dagger2advanced.components;

import com.hariofspades.dagger2advanced.interfaces.annotations.RandomUserApplicationScopeAnnotation;
import com.hariofspades.dagger2advanced.interfaces.RandomUsersApi;
import com.hariofspades.dagger2advanced.modules.PicassoModule;
import com.hariofspades.dagger2advanced.modules.RandomUsersModule;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by Hari on 23/11/17.
 */
@RandomUserApplicationScopeAnnotation
@Component(modules = {RandomUsersModule.class, PicassoModule.class})
public interface RandomUserComponent {

    RandomUsersApi getRandomUserService();

    Picasso getPicasso();
}