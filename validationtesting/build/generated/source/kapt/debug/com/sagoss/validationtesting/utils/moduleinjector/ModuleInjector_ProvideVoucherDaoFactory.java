// Generated by Dagger (https://dagger.dev).
package com.sagoss.validationtesting.utils.moduleinjector;

import com.sagoss.validationtesting.database.ValidationDatabase;
import com.sagoss.validationtesting.database.dao.VoucherDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ModuleInjector_ProvideVoucherDaoFactory implements Factory<VoucherDao> {
  private final ModuleInjector module;

  private final Provider<ValidationDatabase> validationDatabaseProvider;

  public ModuleInjector_ProvideVoucherDaoFactory(ModuleInjector module,
      Provider<ValidationDatabase> validationDatabaseProvider) {
    this.module = module;
    this.validationDatabaseProvider = validationDatabaseProvider;
  }

  @Override
  public VoucherDao get() {
    return provideVoucherDao(module, validationDatabaseProvider.get());
  }

  public static ModuleInjector_ProvideVoucherDaoFactory create(ModuleInjector module,
      Provider<ValidationDatabase> validationDatabaseProvider) {
    return new ModuleInjector_ProvideVoucherDaoFactory(module, validationDatabaseProvider);
  }

  public static VoucherDao provideVoucherDao(ModuleInjector instance,
      ValidationDatabase validationDatabase) {
    return Preconditions.checkNotNullFromProvides(instance.provideVoucherDao(validationDatabase));
  }
}
