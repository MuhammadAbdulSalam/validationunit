package com.sagoss.validationhorizon.fragments.companyviews.c2c

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sagoss.validationhorizon.R
import com.sagoss.validationhorizon.databinding.FragmentGreetingsC2cBinding

class GreetingsC2cFragment : Fragment() {

    private lateinit var binding : FragmentGreetingsC2cBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_greetings_c2c, container, false)
    }

}