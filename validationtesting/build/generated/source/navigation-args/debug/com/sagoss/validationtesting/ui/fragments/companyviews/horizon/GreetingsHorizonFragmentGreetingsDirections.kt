package com.sagoss.validationtesting.ui.fragments.companyviews.horizon

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.sagoss.validationtesting.R
import com.sagoss.validationtesting.database.models.Voucher
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class GreetingsHorizonFragmentGreetingsDirections private constructor() {
  private data class ActionFragmentGreetingsHorizonToFragmentPlateRegistrationHorizon(
    public val voucher: Voucher
  ) : NavDirections {
    public override fun getActionId(): Int =
        R.id.action_fragment_greetings_horizon_to_fragment_plate_registration_horizon

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
      return result
    }
  }

  public companion object {
    public fun actionFragmentGreetingsHorizonToFragmentPlateRegistrationHorizon(voucher: Voucher):
        NavDirections = ActionFragmentGreetingsHorizonToFragmentPlateRegistrationHorizon(voucher)

    public fun actionFragmentGreetingsHorizonToFragmentVouchersHorizon(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragment_greetings_horizon_to_fragment_vouchers_horizon)
  }
}
