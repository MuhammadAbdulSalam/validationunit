package com.sagoss.validationhorizon.recycleradapter

import android.bluetooth.BluetoothDevice
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sagoss.validationhorizon.database.models.Voucher
import com.sagoss.validationhorizon.databinding.LayoutVouchersItemBinding
import com.sagoss.validationhorizon.fragments.basefragments.VouchersListBaseFragment

class VoucherRecyclerAdapter(private val backgroundColor: Int, private val fragment: Fragment) :
    ListAdapter<Voucher, RecyclerView.ViewHolder>(VoucherDiffClass()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BluetoothDeviceViewHolder(
            binding = LayoutVouchersItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false),
            backgroundColor = backgroundColor,
            fragment = fragment
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val device = getItem(position)
        (holder as BluetoothDeviceViewHolder).bind(device)
    }

    class BluetoothDeviceViewHolder(
        private val binding: LayoutVouchersItemBinding,
        private val backgroundColor: Int,
        private val fragment: Fragment
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.itemCardView.setCardBackgroundColor(ContextCompat.getColor(fragment.requireContext(), backgroundColor))
            binding.setClickListener {
                Log.d("-------", "--------------" + binding.model?.voucherName)
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
