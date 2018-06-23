package com.hariofspades.dagger2advanced.components;

import com.hariofspades.dagger2advanced.MainActivity;
import com.hariofspades.dagger2advanced.interfaces.annotations.MainActivityScopeAnnotation;
import com.hariofspades.dagger2advanced.modules.MainActivityModule;

import dagger.Component;

/**
 * Created by Hari on 20/12/17.
 */
@Component(modules = MainActivityModule.class, dependencies = RandomUserComponent.class)
@MainActivityScopeAnnotation
public interface MainActivityComponent {

    void injectMainActivity(MainActivity mainActivity);

}
