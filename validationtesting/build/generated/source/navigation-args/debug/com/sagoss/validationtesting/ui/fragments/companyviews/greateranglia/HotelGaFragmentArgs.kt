package com.sagoss.validationtesting.ui.fragments.companyviews.greateranglia

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.sagoss.validationtesting.database.models.Voucher
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.String
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class HotelGaFragmentArgs(
  public val voucher: Voucher,
  public val plateNumber: String
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
    result.putString("plate_number", this.plateNumber)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): HotelGaFragmentArgs {
      bundle.setClassLoader(HotelGaFragmentArgs::class.java.classLoader)
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
      val __plateNumber : String?
      if (bundle.containsKey("plate_number")) {
        __plateNumber = bundle.getString("plate_number")
        if (__plateNumber == null) {
          throw IllegalArgumentException("Argument \"plate_number\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"plate_number\" is missing and does not have an android:defaultValue")
      }
      return HotelGaFragmentArgs(__voucher, __plateNumber)
    }
  }
}
