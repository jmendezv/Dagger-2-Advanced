package com.hariofspades.dagger2advanced.interfaces.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Hari on 23/11/17.
 */
@Scope
@Retention(RetentionPolicy.CLASS)
public @interface RandomUserApplicationScopeAnnotation {

}
