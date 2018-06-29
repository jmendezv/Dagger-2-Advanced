package com.hariofspades.dagger2advanced.components;

import com.hariofspades.dagger2advanced.interfaces.RandomUsersApi;
import com.hariofspades.dagger2advanced.modules.PicassoModule;
import com.hariofspades.dagger2advanced.modules.RandomUsersApiModule;
import com.squareup.picasso.Picasso;

import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by Hari on 23/11/17.
 * <p>
 * A component will act as a public interface for your entire dependency
 * graph.
 * <p>
 * The best practice of using a component is to expose only the top level
 * dependency and keep other inner dependency under the hood.
 * <p>
 * Every type annotated with @Component must contain at least one abstract
 * component method.
 * <p>
 * Component methods may have any name, but must have signatures that conform
 * to either provision or members-injection contracts.
 * <p>
 * Provision methods
 * <p>
 * Provision methods have no parameters and return an injected or provided type.
 * <p>
 * A Provider allows the user of the component to request provision any number of
 * times by calling Provider.get().
 * <p>
 * A Lazy will only ever request a single provision, but will defer it until the
 * first call to Lazy.get().
 * <p>
 * Each method may have a Qualifier annotation as well.
 * <p>
 * Members-injection methods
 * <p>
 * Members-injection methods have a single parameter and inject dependencies into
 * each of the Inject-annotated fields and methods of the passed instance.
 * <p>
 * A note about covariance
 * <p>
 * While a members-injection method for a type will accept instances of its subtypes,
 * only Inject-annotated members of the parameter type and its supertypes will be injected;
 * members of subtypes will not.
 * <p>
 * Instantiation
 * <p>
 * Component implementations are primarily instantiated via a generated builder.
 * An instance of the builder is obtained using the builder() method on the component
 * implementation.
 * <p>
 * If a nested @Component.Builder type exists in the component, the builder() method
 * will return a generated implementation of that type.
 * <p>
 * If no nested @Component.Builder exists, the returned builder has a method to set
 * each of the modules() and component dependencies() named with the lower camel
 * case version of the module or dependency type.
 * <p>
 * Each component dependency and module without a visible default constructor must
 * be set explicitly, but any module with a default or no-args constructor accessible
 * to the component implementation may be elided (left out).
 * <p>
 * Scope
 * <p>
 * Each Dagger component can be associated with a scope by annotating it with the
 * scope annotation.
 * <p>
 * The component implementation ensures that there is only one provision of each scoped
 * binding per instance of the component.
 * <p>
 * If the component declares a scope, it may only contain unscoped bindings or bindings
 * of that scope anywhere in the graph.
 * <p>
 * Component relationships
 * <p>
 * While there is much utility in isolated components with purely unscoped bindings,
 * many applications will call for multiple components with multiple scopes to interact.
 * <p>
 * Dagger provides two mechanisms for relating components.
 * <p>
 * Subcomponents
 * <p>
 * Subcomponents are components that inherit and extend the object graph of a
 * parent component.
 * <p>
 * You can use them to partition your application’s object graph into subgraphs
 * either to encapsulate different parts of your application from each other or
 * to use more than one scope within a component.
 * <p>
 * in android applications, you can define parent component for application level use,
 * subcomponents for activity and fragment level use.
 * <p>
 * Fragment level component can provide or inject objects from both activity and
 * application scoped parent components.
 * <p>
 * Once fragment is destroyed, object defined for that scope will be removed.
 * <p>
 * The simplest way to relate two components is by declaring a Subcomponent.
 * <p>
 * A subcomponent behaves exactly like a component, but has its implementation
 * generated within a parent component or subcomponent.
 * <p>
 * That relationship allows the subcomponent implementation to inherit the entire
 * binding graph from its parent when it is declared.
 * <p>
 * For that reason, a subcomponent isn't evaluated for completeness until it is
 * associated with a parent.
 * <p>
 * Subcomponents are declared by listing the class in the Module.subcomponents()
 * attribute of one of the parent component's modules.
 * <p>
 * This binds the Subcomponent.Builder within the parent component.
 * <p>
 * Component dependencies
 * <p>
 * While subcomponents are the simplest way to compose subgraphs of bindings,
 * subcomponents are tightly coupled with the parents; they may use any binding
 * defined by their ancestor component and subcomponents.
 * <p>
 * As an alternative, components can use bindings only from another component
 * interface by declaring a component dependency.
 * <p>
 * When a type is used as a component dependency, each provision method on the dependency
 * is bound as a provider.
 * <p>
 * Note that only the bindings exposed as provision methods are available through
 * component dependencies.
 */
@Component(modules = {RandomUsersApiModule.class, PicassoModule.class})
public interface ApplicationComponent {

   /* Provision method */
   RandomUsersApi getRandomUsersApi();

   /* Provision method */
   Picasso getPicasso();

}
