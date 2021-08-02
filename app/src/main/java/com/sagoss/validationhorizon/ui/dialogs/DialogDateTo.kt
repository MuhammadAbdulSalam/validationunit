package com.sagoss.validationhorizon.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window

import android.widget.EditText
import com.sagoss.validationhorizon.R


class DialogDateTo(context: Context) : Dialog(context) {
    var mDialogResult: OnMyDialogResult? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_askfor_date_to)
        this.setCancelable(false)
        this.setCanceledOnTouchOutside(false)

    }

    private inner class OKListener : View.OnClickListener {
        override fun onClick(v: View?) {
            if (mDialogResult != null) {
//                mDialogResult!!.finish(etName!!.text.toString())
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