package com.sagoss.validationtesting.ui.fragments.companyviews.c2c

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.sagoss.validationtesting.R
import com.sagoss.validationtesting.database.models.Voucher
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.String
import kotlin.Suppress

public class EntryTimeC2cFragmentDirections private constructor() {
  private data class ActionFragmentDateFromC2cToFragmentDateToC2c(
    public val voucher: Voucher,
    public val plateNumber: String
  ) : NavDirections {
    public override fun getActionId(): Int =
        R.id.action_fragment_date_from_c2c_to_fragment_date_to_c2c

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
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
  }

  private data class ActionFragmentDateFromC2cToFragmentHotelC2c(
    public val voucher: Voucher,
    public val plateNumber: String
  ) : NavDirections {
    public override fun getActionId(): Int =
        R.id.action_fragment_date_from_c2c_to_fragment_hotel_c2c

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
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
  }

  private data class ActionFragmentDateFromC2cToFragmentValidationComplete(
    public val voucher: Voucher,
    public val plateNumber: String,
    public val dateTo: String,
    public val dateFrom: String
  ) : NavDirections {
    public override fun getActionId(): Int =
        R.id.action_fragment_date_from_c2c_to_fragment_validation_complete

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
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
  }

  public companion object {
    public fun actionFragmentDateFromC2cToFragmentDateToC2c(voucher: Voucher, plateNumber: String):
        NavDirections = ActionFragmentDateFromC2cToFragmentDateToC2c(voucher, plateNumber)

    public fun actionFragmentDateFromC2cToFragmentHotelC2c(voucher: Voucher, plateNumber: String):
        NavDirections = ActionFragmentDateFromC2cToFragmentHotelC2c(voucher, plateNumber)

    public fun actionFragmentDateFromC2cToFragmentValidationComplete(
      voucher: Voucher,
      plateNumber: String,
      dateTo: String,
      dateFrom: String
    ): NavDirections = ActionFragmentDateFromC2cToFragmentValidationComplete(voucher, plateNumber,
        dateTo, dateFrom)
  }
}
