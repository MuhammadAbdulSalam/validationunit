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

public class HotelC2cFragmentDirections private constructor() {
  private data class ActionFragmentHotelC2cToFragmentValidationComplete(
    public val voucher: Voucher,
    public val plateNumber: String,
    public val dateTo: String,
    public val dateFrom: String
  ) : NavDirections {
    public override fun getActionId(): Int =
        R.id.action_fragment_hotel_c2c_to_fragment_validation_complete

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
    public fun actionFragmentHotelC2cToFragmentValidationComplete(
      voucher: Voucher,
      plateNumber: String,
      dateTo: String,
      dateFrom: String
    ): NavDirections = ActionFragmentHotelC2cToFragmentValidationComplete(voucher, plateNumber,
        dateTo, dateFrom)
  }
}
