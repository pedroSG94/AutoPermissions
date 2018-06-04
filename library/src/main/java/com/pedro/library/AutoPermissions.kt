package com.pedro.library

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
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

    fun getAllPermissionsNoGranted(activity: Activity): Array<String> {
      val list = ArrayList<String>()
      for (p in getAllPermissions(activity)) {
        if (ActivityCompat.checkSelfPermission(activity, p) != PackageManager.PERMISSION_GRANTED) {
          list.add(p)
        }
      }
      return list.toTypedArray()
    }

    fun getAllPermissionsGranted(activity: Activity): Array<String> {
      val list = ArrayList<String>()
      for (p in getAllPermissions(activity)) {
        if (ActivityCompat.checkSelfPermission(activity, p) == PackageManager.PERMISSION_GRANTED) {
          list.add(p)
        }
      }
      return list.toTypedArray()
    }

    fun getActivityPermissionsNoGranted(activity: Activity): Array<String> {
      val list = ArrayList<String>()
      for (p in getActivityPermissions(activity)) {
        if (ActivityCompat.checkSelfPermission(activity, p) != PackageManager.PERMISSION_GRANTED) {
          list.add(p)
        }
      }
      return list.toTypedArray()
    }

    fun getActivityPermissionsGranted(activity: Activity): Array<String> {
      val list = ArrayList<String>()
      for (p in getActivityPermissions(activity)) {
        if (ActivityCompat.checkSelfPermission(activity, p) == PackageManager.PERMISSION_GRANTED) {
          list.add(p)
        }
      }
      return list.toTypedArray()
    }

    fun loadAllPermissions(activity: Activity, requestCode: Int) {
      ActivityCompat.requestPermissions(activity, getAllPermissions(activity), requestCode)
    }

    fun loadActivityPermissions(activity: Activity, requestCode: Int) {
      ActivityCompat.requestPermissions(activity, getActivityPermissions(activity), requestCode)
    }

    fun loadSelectedPermissions(activity: Activity, requestCode: Int, permissions: Array<String>) {
      ActivityCompat.requestPermissions(activity, permissions, requestCode)
    }
  }
}