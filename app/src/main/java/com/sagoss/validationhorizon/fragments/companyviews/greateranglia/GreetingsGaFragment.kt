package com.sagoss.validationhorizon.fragments.companyviews.greateranglia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sagoss.validationhorizon.R


class GreetingsGaFragment : Fragment() {
  override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_greetings_ga, container, false)
    }
}