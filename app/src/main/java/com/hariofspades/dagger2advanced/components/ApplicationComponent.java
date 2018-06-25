package com.hariofspades.dagger2advanced.components;

import com.hariofspades.dagger2advanced.interfaces.RandomUsersApi;
import com.hariofspades.dagger2advanced.modules.PicassoModule;
import com.hariofspades.dagger2advanced.modules.RandomUsersApiModule;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by Hari on 23/11/17.
 *
 * A component will act as a public interface for your entire dependency
 * graph.
 *
 * The best practice of using a component is to expose only the top level
 * dependency and keep other inner dependency under the hood.
 */
@Component(modules = {RandomUsersApiModule.class, PicassoModule.class})
public interface ApplicationComponent {

    RandomUsersApi getRandomUsersApi();

    Picasso getPicasso();
}
