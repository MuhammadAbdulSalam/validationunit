package com.sagoss.validationhorizon.ui.recycleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sagoss.validationhorizon.api.models.config.DateToFixed
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.databinding.LayoutDateToFixedHotelItemBinding
import com.sagoss.validationhorizon.databinding.LayoutVouchersItemBinding
import com.sagoss.validationhorizon.ui.fragments.basefragments.HotelBaseFragment
import com.sagoss.validationhorizon.ui.fragments.basefragments.VouchersListBaseFragment

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
        private val backgroundColor: Int,
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
