package com.sagoss.validationtesting.ui.fragments.companyviews.horizon

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

public class EntryTimeHorizonFragmentDirections private constructor() {
  private data class ActionFragmentEntryTimeHorizonToFragmentEnterDateToHorizon(
    public val voucher: Voucher,
    public val plateNumber: String
  ) : NavDirections {
    public override fun getActionId(): Int =
        R.id.action_fragment_entry_time_horizon_to_fragment_enter_date_to_horizon

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

  private data class ActionFragmentEntryTimeHorizonToFragmentHorizonHotel(
    public val voucher: Voucher,
    public val plateNumber: String
  ) : NavDirections {
    public override fun getActionId(): Int =
        R.id.action_fragment_entry_time_horizon_to_fragment_horizon_hotel

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

  private data class ActionFragmentEntryTimeHorizonToFragmentHorizonValidation(
    public val voucher: Voucher,
    public val plateNumber: String,
    public val dateTo: String,
    public val dateFrom: String
  ) : NavDirections {
    public override fun getActionId(): Int =
        R.id.action_fragment_entry_time_horizon_to_fragment_horizon_validation

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
    public fun actionFragmentEntryTimeHorizonToFragmentEnterDateToHorizon(voucher: Voucher,
        plateNumber: String): NavDirections =
        ActionFragmentEntryTimeHorizonToFragmentEnterDateToHorizon(voucher, plateNumber)

    public fun actionFragmentEntryTimeHorizonToFragmentHorizonHotel(voucher: Voucher,
        plateNumber: String): NavDirections =
        ActionFragmentEntryTimeHorizonToFragmentHorizonHotel(voucher, plateNumber)

    public fun actionFragmentEntryTimeHorizonToFragmentHorizonValidation(
      voucher: Voucher,
      plateNumber: String,
      dateTo: String,
      dateFrom: String
    ): NavDirections = ActionFragmentEntryTimeHorizonToFragmentHorizonValidation(voucher,
        plateNumber, dateTo, dateFrom)
  }
}
