// Generated by Dagger (https://dagger.dev).
package com.sagoss.validationtesting.backgroundsync.configworker;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.sagoss.validationtesting.api.repository.ApiResponseRepository;
import dagger.internal.DaggerGenerated;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ConfigWorker_Factory {
  private final Provider<ApiResponseRepository> apiOneResponseRepositoryProvider;

  public ConfigWorker_Factory(Provider<ApiResponseRepository> apiOneResponseRepositoryProvider) {
    this.apiOneResponseRepositoryProvider = apiOneResponseRepositoryProvider;
  }

  public ConfigWorker get(Context appContext, WorkerParameters workerParams) {
    return newInstance(appContext, workerParams, apiOneResponseRepositoryProvider.get());
  }

  public static ConfigWorker_Factory create(
      Provider<ApiResponseRepository> apiOneResponseRepositoryProvider) {
    return new ConfigWorker_Factory(apiOneResponseRepositoryProvider);
  }

  public static ConfigWorker newInstance(Context appContext, WorkerParameters workerParams,
      ApiResponseRepository apiOneResponseRepository) {
    return new ConfigWorker(appContext, workerParams, apiOneResponseRepository);
  }
}
