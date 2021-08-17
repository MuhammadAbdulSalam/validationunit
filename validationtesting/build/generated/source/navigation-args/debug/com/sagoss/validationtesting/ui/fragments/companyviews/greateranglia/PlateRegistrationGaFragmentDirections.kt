package com.sagoss.validationtesting.ui.fragments.companyviews.greateranglia

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

public class PlateRegistrationGaFragmentDirections private constructor() {
  private data class ActionFragmentPlateRegistrationGaToFragmentHotelGa(
    public val voucher: Voucher,
    public val plateNumber: String
  ) : NavDirections {
    public override fun getActionId(): Int =
        R.id.action_fragment_plate_registration_ga_to_fragment_hotel_ga

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

  private data class ActionFragmentPlateRegistrationGaToFragmentDateFromGa(
    public val voucher: Voucher,
    public val plateNumber: String
  ) : NavDirections {
    public override fun getActionId(): Int =
        R.id.action_fragment_plate_registration_ga_to_fragment_date_from_ga

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

  private data class ActionFragmentPlateRegistrationGaToFragmentDateToGa(
    public val voucher: Voucher,
    public val plateNumber: String
  ) : NavDirections {
    public override fun getActionId(): Int =
        R.id.action_fragment_plate_registration_ga_to_fragment_date_to_ga

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

  private data class ActionFragmentPlateRegistrationGaToFragmentValidationGa(
    public val voucher: Voucher,
    public val plateNumber: String,
    public val dateTo: String,
    public val dateFrom: String
  ) : NavDirections {
    public override fun getActionId(): Int =
        R.id.action_fragment_plate_registration_ga_to_fragment_validation_ga

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
    public fun actionFragmentPlateRegistrationGaToFragmentHotelGa(voucher: Voucher,
        plateNumber: String): NavDirections =
        ActionFragmentPlateRegistrationGaToFragmentHotelGa(voucher, plateNumber)

    public fun actionFragmentPlateRegistrationGaToFragmentDateFromGa(voucher: Voucher,
        plateNumber: String): NavDirections =
        ActionFragmentPlateRegistrationGaToFragmentDateFromGa(voucher, plateNumber)

    public fun actionFragmentPlateRegistrationGaToFragmentDateToGa(voucher: Voucher,
        plateNumber: String): NavDirections =
        ActionFragmentPlateRegistrationGaToFragmentDateToGa(voucher, plateNumber)

    public fun actionFragmentPlateRegistrationGaToFragmentValidationGa(
      voucher: Voucher,
      plateNumber: String,
      dateTo: String,
      dateFrom: String
    ): NavDirections = ActionFragmentPlateRegistrationGaToFragmentValidationGa(voucher, plateNumber,
        dateTo, dateFrom)
  }
}
