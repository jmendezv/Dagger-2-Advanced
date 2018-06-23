package com.hariofspades.dagger2advanced.interfaces.annotations;

import javax.inject.Scope;

/**
 * Created by Hari on 20/12/17.
 *
 * @Target(value=ANNOTATION_TYPE)
 *
 * A scope annotation applies to a class containing an injectable
 * constructor and governs how the injector reuses instances of the type.
 *
 * By default, if no Scope annotation is present, the injector creates an
 * instance (by injecting the type's constructor), uses the instance for
 * one injection, and then forgets it.
 *
 * If a scope annotation is present, the injector may retain the instance
 * for possible reuse in a later injection.
 *
 */
@Scope
public @interface MainActivityScopeAnnotation {
}
