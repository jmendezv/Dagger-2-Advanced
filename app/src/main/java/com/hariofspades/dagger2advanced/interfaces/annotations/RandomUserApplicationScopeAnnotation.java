package com.hariofspades.dagger2advanced.interfaces.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Hari on 23/11/17.
 *
 * RUNTIME: Annotations are to be recorded in the class file by the
 * compiler and retained by the VM at run time, so they may be read
 * reflectively.
 *
 * CLASS: Annotations are to be recorded in the class file by the
 * compiler but need not be retained by the VM at run time. It is
 * the default behaviour.
 *
 * @Scope annotation has RetentionPolicy.RUNTIME
 *
 */
@Scope
//@Retention(RetentionPolicy.CLASS)
public @interface RandomUserApplicationScopeAnnotation {

}
