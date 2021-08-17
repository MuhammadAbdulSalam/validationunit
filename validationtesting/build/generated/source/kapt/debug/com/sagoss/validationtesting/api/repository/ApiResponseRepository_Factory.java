// Generated by Dagger (https://dagger.dev).
package com.sagoss.validationtesting.api.repository;

import com.sagoss.validationtesting.api.apiInterface.ApiHelper;
import com.sagoss.validationtesting.database.repository.DBRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ApiResponseRepository_Factory implements Factory<ApiResponseRepository> {
  private final Provider<ApiHelper> apiInterfaceProvider;

  private final Provider<DBRepository> dbRepositoryProvider;

  public ApiResponseRepository_Factory(Provider<ApiHelper> apiInterfaceProvider,
      Provider<DBRepository> dbRepositoryProvider) {
    this.apiInterfaceProvider = apiInterfaceProvider;
    this.dbRepositoryProvider = dbRepositoryProvider;
  }

  @Override
  public ApiResponseRepository get() {
    return newInstance(apiInterfaceProvider.get(), dbRepositoryProvider.get());
  }

  public static ApiResponseRepository_Factory create(Provider<ApiHelper> apiInterfaceProvider,
      Provider<DBRepository> dbRepositoryProvider) {
    return new ApiResponseRepository_Factory(apiInterfaceProvider, dbRepositoryProvider);
  }

  public static ApiResponseRepository newInstance(ApiHelper apiInterface,
      DBRepository dbRepository) {
    return new ApiResponseRepository(apiInterface, dbRepository);
  }
}