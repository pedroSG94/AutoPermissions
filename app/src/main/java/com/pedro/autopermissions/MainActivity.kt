package com.pedro.autopermissions

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pedro.library.AutoPermissions

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        AutoPermissions.loadAllPermissions(this, 1)
        AutoPermissions.loadActivityPermissions(this, 1)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //Info about permissions grant and all permissions request
    }
}
