package com.hr.custom_dialog

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.Window
import androidx.databinding.DataBindingUtil
import com.hr.custom_dialog.databinding.DialogMessageBinding


fun showMessageDialog(
    context: Context,
    title: String,
    message: String = "",
    isCancelable:Boolean,
    listener: DialogOnClick
) {

    val inflator = LayoutInflater.from(context)
    val binding: DialogMessageBinding =
        DataBindingUtil.inflate(inflator, R.layout.dialog_message, null, false)

    val mDialog: Dialog = Dialog(context).apply {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)
        setCanceledOnTouchOutside(isCancelable)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
    }

    binding.tvTitle.text = title
    binding.tvMessage.text = message

    binding.tvDismiss.setOnClickListener {
        listener.onClose()
        mDialog.dismiss()
    }

    mDialog.show()
}

interface DialogOnClick {
    fun onClose()
}
