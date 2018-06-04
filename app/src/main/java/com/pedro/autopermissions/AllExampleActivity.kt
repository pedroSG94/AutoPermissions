package com.pedro.autopermissions

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.pedro.library.AutoPermissions

class AllExampleActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_activity_example)
    AutoPermissions.loadAllPermissions(this, 1)
  }

  override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    //Info about permissions grant and all permissions request
    Toast.makeText(this, "${AutoPermissions.getAllPermissionsNoGranted(this).size} permissions no granted", Toast.LENGTH_SHORT).show()
  }
}
