package com.sagoss.validationhorizon.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window

import com.sagoss.validationhorizon.databinding.DialogAskforDateToBinding


class DialogDateTo(context: Context) : Dialog(context) {
    var mDialogResult: OnMyDialogResult? = null
    lateinit var binding: DialogAskforDateToBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding  = DialogAskforDateToBinding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.setContentView(binding.root)
        this.setCancelable(false)
        this.setCanceledOnTouchOutside(false)

        binding.btnCancel.setOnClickListener{
            this.cancel()
        }
        binding.confirmButton.setOnClickListener(OKListener())
    }


    private inner class OKListener : View.OnClickListener {
        override fun onClick(v: View?) {
            if (mDialogResult != null) {
                mDialogResult!!.finish(binding.durationField!!.text.toString())
            }
            this@DialogDateTo.dismiss()
        }
    }

    fun setDialogResult(dialogResult: OnMyDialogResult?) {
        mDialogResult = dialogResult
    }

    interface OnMyDialogResult {
        fun finish(result: String?)
    }

}