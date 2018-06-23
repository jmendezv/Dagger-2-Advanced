package com.hariofspades.dagger2advanced.interfaces.annotations;

import javax.inject.Qualifier;

/**
 * Created by Hari on 17/12/17.

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
@Qualifier
public @interface ApplicationContextAnnotation {

}
