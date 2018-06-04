package com.pedro.autopermissions

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.pedro.library.AutoPermissions
import com.pedro.library.AutoPermissionsListener

class AllExampleActivity : AppCompatActivity(), AutoPermissionsListener {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_activity_example)
    AutoPermissions.loadAllPermissions(this, 1)
  }

  override fun onGranted(requestCode: Int, permissions: Array<String>) {
    Toast.makeText(this, "${permissions.size} permissions granted", Toast.LENGTH_SHORT).show()
  }

  override fun onDenied(requestCode: Int, permissions: Array<String>) {
    Toast.makeText(this, "${permissions.size} permissions no granted", Toast.LENGTH_SHORT).show()
  }

  override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    AutoPermissions.parsePermissions(this, requestCode, permissions, this)
  }
}
