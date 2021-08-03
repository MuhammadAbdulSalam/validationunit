package com.sagoss.validationhorizon.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.core.content.ContextCompat
import com.sagoss.validationhorizon.databinding.DialogEnterDateToBinding
import com.sagoss.validationhorizon.databinding.DialogEnterEntryTimeBinding

class DialogEntryTime(private val mContext: Context, private val defaultColor: Int) : Dialog(mContext) {
    var mDialogResult: OnDialogResult? = null
    lateinit var binding: DialogEnterEntryTimeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding  = DialogEnterEntryTimeBinding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.setContentView(binding.root)
        this.setCancelable(false)
        this.setCanceledOnTouchOutside(false)
    }


    private inner class OKListener : View.OnClickListener {
        override fun onClick(v: View?) {
            if (mDialogResult != null) {
             //   mDialogResult!!.finish(binding.durationField!!.text.toString())
            }
            this@DialogEntryTime.dismiss()
        }
    }

    fun setDialogResult(dialogResult: OnDialogResult?) { mDialogResult = dialogResult }

    interface OnDialogResult { fun finish(result: String?) }

}