/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationhorizon.ui.recycleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.databinding.LayoutVouchersItemBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.VouchersListBaseFragment

class VoucherRecyclerAdapter(private val backgroundColor: Int, private val fragment: Fragment) :
    ListAdapter<Voucher, RecyclerView.ViewHolder>(VoucherDiffClass()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return VoucherViewHolder(
            binding = LayoutVouchersItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false),
            backgroundColor = backgroundColor,
            fragment = fragment
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val device = getItem(position)
        (holder as VoucherViewHolder).bind(device)
    }

    class VoucherViewHolder(
        private val binding: LayoutVouchersItemBinding,
        backgroundColor: Int,
        private val fragment: Fragment
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.itemCardView.setCardBackgroundColor(
                ContextCompat.getColor(fragment.requireContext(), backgroundColor)
            )
            binding.setClickListener {
                (fragment as VouchersListBaseFragment<*>).onRecyclerClick(binding.model!!)
            }
        }

        fun bind(item: Voucher) {
            binding.apply {
                model = item
                executePendingBindings()
            }
        }
    }
}

private class VoucherDiffClass : DiffUtil.ItemCallback<Voucher>() {
    override fun areItemsTheSame(oldItem: Voucher, newItem: Voucher): Boolean {
        return oldItem.voucherName == newItem.voucherName
    }

    override fun areContentsTheSame(oldItem: Voucher, newItem: Voucher): Boolean {
        return oldItem == newItem
    }
}
