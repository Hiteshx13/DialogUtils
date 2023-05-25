package com.hr.dialogutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hr.custom_dialog.DialogOnClick
import com.hr.custom_dialog.showMessageDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showMessageDialog(this,"Demmo title","demo message",false,object: DialogOnClick {
            override fun onClose() {

            }
        })
    }
}