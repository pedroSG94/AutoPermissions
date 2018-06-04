package com.pedro.library

interface AutoPermissionsListener {

  fun onGranted(requestCode: Int, permissions: Array<String>)

  fun onDenied(requestCode: Int, permissions: Array<String>)
}