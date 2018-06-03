package com.pedro.library

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat


class AutoPermissions {

  companion object {
    fun getAllPermissions(context: Context): Array<String> {
      return context.packageManager.getPackageInfo(context.packageName, PackageManager.GET_PERMISSIONS).requestedPermissions
    }

    fun getActivityPermissions(activity: Activity): Array<String> {
      val permissions = arrayListOf<String>()
      val activityInfo = activity.packageManager.getActivityInfo(activity.componentName, PackageManager.GET_META_DATA)
      activityInfo?.metaData?.getString(activity.resources.getString(R.string.permissions_loader_meta_key))
          ?.split(",")?.forEach {
            permissions.add(it.trim())
          }
      return permissions.toTypedArray()
    }

    fun hasPermissions(context: Context, permissions: Array<String>): Boolean {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        for (permission in permissions) {
          if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
            return false
          }
        }
      }
      return true
    }

    fun loadAllPermissions(activity: Activity, requestCode: Int) {
      if (!hasPermissions(activity, getAllPermissions(activity))) {
        ActivityCompat.requestPermissions(activity, getAllPermissions(activity), requestCode)
      }
    }

    fun loadActivityPermissions(activity: Activity, requestCode: Int) {
      if (!hasPermissions(activity, getActivityPermissions(activity))) {
        ActivityCompat.requestPermissions(activity, getActivityPermissions(activity), requestCode)
      }
    }
  }
}