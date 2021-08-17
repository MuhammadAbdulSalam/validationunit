// Generated by Dagger (https://dagger.dev).
package com.sagoss.validationtesting.utils.application;

import com.sagoss.validationtesting.api.repository.ApiResponseRepository;
import com.sagoss.validationtesting.apitwo.repositiory.ApiTwoResponseRepository;
import com.sagoss.validationtesting.database.repository.DBRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class Application_MembersInjector implements MembersInjector<Application> {
  private final Provider<DBRepository> dbRepositoryProvider;

  private final Provider<ApiTwoResponseRepository> apiTwoResponseRepositoryProvider;

  private final Provider<ApiResponseRepository> apiResponseRepositoryProvider;

  public Application_MembersInjector(Provider<DBRepository> dbRepositoryProvider,
      Provider<ApiTwoResponseRepository> apiTwoResponseRepositoryProvider,
      Provider<ApiResponseRepository> apiResponseRepositoryProvider) {
    this.dbRepositoryProvider = dbRepositoryProvider;
    this.apiTwoResponseRepositoryProvider = apiTwoResponseRepositoryProvider;
    this.apiResponseRepositoryProvider = apiResponseRepositoryProvider;
  }

  public static MembersInjector<Application> create(Provider<DBRepository> dbRepositoryProvider,
      Provider<ApiTwoResponseRepository> apiTwoResponseRepositoryProvider,
      Provider<ApiResponseRepository> apiResponseRepositoryProvider) {
    return new Application_MembersInjector(dbRepositoryProvider, apiTwoResponseRepositoryProvider, apiResponseRepositoryProvider);
  }

  @Override
  public void injectMembers(Application instance) {
    injectDbRepository(instance, dbRepositoryProvider.get());
    injectApiTwoResponseRepository(instance, apiTwoResponseRepositoryProvider.get());
    injectApiResponseRepository(instance, apiResponseRepositoryProvider.get());
  }

  @InjectedFieldSignature("com.sagoss.validationtesting.utils.application.Application.dbRepository")
  public static void injectDbRepository(Application instance, DBRepository dbRepository) {
    instance.dbRepository = dbRepository;
  }

  @InjectedFieldSignature("com.sagoss.validationtesting.utils.application.Application.apiTwoResponseRepository")
  public static void injectApiTwoResponseRepository(Application instance,
      ApiTwoResponseRepository apiTwoResponseRepository) {
    instance.apiTwoResponseRepository = apiTwoResponseRepository;
  }

  @InjectedFieldSignature("com.sagoss.validationtesting.utils.application.Application.apiResponseRepository")
  public static void injectApiResponseRepository(Application instance,
      ApiResponseRepository apiResponseRepository) {
    instance.apiResponseRepository = apiResponseRepository;
  }
}