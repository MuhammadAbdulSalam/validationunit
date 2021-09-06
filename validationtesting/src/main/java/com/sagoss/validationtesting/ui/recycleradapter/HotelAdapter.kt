/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.ui.recycleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sagoss.validationtesting.api.models.config.DateToFixed
import com.sagoss.validationtesting.databinding.LayoutDateToFixedHotelItemBinding
import com.sagoss.validationtesting.ui.fragments.basefragments.HotelBaseFragment

class HotelAdapter(private val backgroundColor: Int, private val fragment: Fragment) :
    ListAdapter<DateToFixed, RecyclerView.ViewHolder>(HotelVoucherDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HotelVoucherViewHolder(
            binding = LayoutDateToFixedHotelItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false),
            backgroundColor = backgroundColor,
            fragment = fragment
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val device = getItem(position)
        (holder as HotelVoucherViewHolder).bind(device)
    }

    class HotelVoucherViewHolder(
        private val binding: LayoutDateToFixedHotelItemBinding,
        backgroundColor: Int,
        private val fragment: Fragment
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.itemCardView.setCardBackgroundColor(ContextCompat.getColor(fragment.requireContext(), backgroundColor))
            binding.setClickListener { (fragment as HotelBaseFragment<*>).onRecyclerItemSelected(binding.model!!) }
        }

        fun bind(item: DateToFixed) {
            binding.apply {
                model = item
                executePendingBindings()
            }
        }
    }
}

private class HotelVoucherDiff : DiffUtil.ItemCallback<DateToFixed>() {
    override fun areItemsTheSame(oldItem: DateToFixed, newItem: DateToFixed): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: DateToFixed, newItem: DateToFixed): Boolean {
        return oldItem == newItem
    }
}
