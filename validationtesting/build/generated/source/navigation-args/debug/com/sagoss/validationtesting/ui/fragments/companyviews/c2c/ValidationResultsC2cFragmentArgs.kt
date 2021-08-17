package com.sagoss.validationtesting.ui.fragments.companyviews.c2c

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

public data class ValidationResultsC2cFragmentArgs(
  public val voucher: Voucher,
  public val plateNumber: String,
  public val dateTo: String,
  public val dateFrom: String
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
    result.putString("date_to", this.dateTo)
    result.putString("date_from", this.dateFrom)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): ValidationResultsC2cFragmentArgs {
      bundle.setClassLoader(ValidationResultsC2cFragmentArgs::class.java.classLoader)
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
      val __dateTo : String?
      if (bundle.containsKey("date_to")) {
        __dateTo = bundle.getString("date_to")
        if (__dateTo == null) {
          throw IllegalArgumentException("Argument \"date_to\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"date_to\" is missing and does not have an android:defaultValue")
      }
      val __dateFrom : String?
      if (bundle.containsKey("date_from")) {
        __dateFrom = bundle.getString("date_from")
        if (__dateFrom == null) {
          throw IllegalArgumentException("Argument \"date_from\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"date_from\" is missing and does not have an android:defaultValue")
      }
      return ValidationResultsC2cFragmentArgs(__voucher, __plateNumber, __dateTo, __dateFrom)
    }
  }
}
