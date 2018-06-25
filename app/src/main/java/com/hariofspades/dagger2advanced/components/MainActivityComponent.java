package com.hariofspades.dagger2advanced.components;

import com.hariofspades.dagger2advanced.MainActivity;
import com.hariofspades.dagger2advanced.modules.ContextModule;

import dagger.Component;

/**
 * Created by Hari on 20/12/17.
 * <p>
 * Annotates an interface or abstract class for which a fully-formed,
 * dependency-injected implementation is to be generated from a set of modules().
 * <p>
 * The generated class will have the name of the type annotated with @Component
 * prepended with Dagger.
 * <p>
 * eg. interface MainActivityComponent -> class DaggerMainActivityComponent
 * <p>
 * Each Dagger component can be associated with a scope by annotating it with the scope annotation.
 * <p>
 * The component implementation ensures that there is only one provision of each scoped binding per
 * instance of the component.
 * <p>
 * Components can use bindings only from another component interface by declaring a component
 * dependency.
 */
@Component(modules = {ContextModule.class}, dependencies = {ApplicationComponent.class})
public interface MainActivityComponent {

   void inject(MainActivity mainActivity);

}
