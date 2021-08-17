// Generated by Dagger (https://dagger.dev).
package com.sagoss.validationtesting.utils.moduleinjector;

import com.sagoss.validationtesting.database.ValidationDatabase;
import com.sagoss.validationtesting.database.dao.RequestDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ModuleInjector_ProvideRequestDaoFactory implements Factory<RequestDao> {
  private final ModuleInjector module;

  private final Provider<ValidationDatabase> validationDatabaseProvider;

  public ModuleInjector_ProvideRequestDaoFactory(ModuleInjector module,
      Provider<ValidationDatabase> validationDatabaseProvider) {
    this.module = module;
    this.validationDatabaseProvider = validationDatabaseProvider;
  }

  @Override
  public RequestDao get() {
    return provideRequestDao(module, validationDatabaseProvider.get());
  }

  public static ModuleInjector_ProvideRequestDaoFactory create(ModuleInjector module,
      Provider<ValidationDatabase> validationDatabaseProvider) {
    return new ModuleInjector_ProvideRequestDaoFactory(module, validationDatabaseProvider);
  }

  public static RequestDao provideRequestDao(ModuleInjector instance,
      ValidationDatabase validationDatabase) {
    return Preconditions.checkNotNullFromProvides(instance.provideRequestDao(validationDatabase));
  }
}
