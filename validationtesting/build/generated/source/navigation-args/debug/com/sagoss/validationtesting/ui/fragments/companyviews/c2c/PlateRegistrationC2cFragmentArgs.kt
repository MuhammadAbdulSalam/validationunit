package com.sagoss.validationtesting.ui.fragments.companyviews.c2c

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.sagoss.validationtesting.database.models.Voucher
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class PlateRegistrationC2cFragmentArgs(
  public val voucher: Voucher
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Voucher::class.java)) {
      result.putParcelable("voucher", this.voucher as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Voucher::class.java)) {
      result.putSerializable("voucher", this.voucher as Serializable)
    } else {
      throw UnsupportedOperationException(Voucher::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): PlateRegistrationC2cFragmentArgs {
      bundle.setClassLoader(PlateRegistrationC2cFragmentArgs::class.java.classLoader)
      val __voucher : Voucher?
      if (bundle.containsKey("voucher")) {
        if (Parcelable::class.java.isAssignableFrom(Voucher::class.java) ||
            Serializable::class.java.isAssignableFrom(Voucher::class.java)) {
          __voucher = bundle.get("voucher") as Voucher?
        } else {
          throw UnsupportedOperationException(Voucher::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__voucher == null) {
          throw IllegalArgumentException("Argument \"voucher\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"voucher\" is missing and does not have an android:defaultValue")
      }
      return PlateRegistrationC2cFragmentArgs(__voucher)
    }
  }
}
