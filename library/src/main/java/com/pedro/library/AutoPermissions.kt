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

    fun getPermissionsNoGranted(activity: Activity, permissions: Array<String>): Array<String> {
      val list = ArrayList<String>()
      for (p in permissions) {
        if (ActivityCompat.checkSelfPermission(activity, p) != PackageManager.PERMISSION_GRANTED) {
          list.add(p)
        }
      }
      return list.toTypedArray()
    }

    fun getPermissionsGranted(activity: Activity, permissions: Array<String>): Array<String> {
      val list = ArrayList<String>()
      for (p in permissions) {
        if (ActivityCompat.checkSelfPermission(activity, p) == PackageManager.PERMISSION_GRANTED) {
          list.add(p)
        }
      }
      return list.toTypedArray()
    }

    fun getAllPermissionsNoGranted(activity: Activity): Array<String> {
      return getPermissionsNoGranted(activity, getAllPermissions(activity))
    }

    fun parsePermissions(activity: Activity, requestCode: Int, permissions: Array<String>, listener: AutoPermissionsListener) {
      listener.onGranted(requestCode, getPermissionsGranted(activity, permissions))
      listener.onDenied(requestCode, getPermissionsNoGranted(activity, permissions))
    }

    fun getAllPermissionsGranted(activity: Activity): Array<String> {
      return getPermissionsGranted(activity, getAllPermissions(activity))
    }

    fun getActivityPermissionsNoGranted(activity: Activity): Array<String> {
      return getPermissionsNoGranted(activity, getActivityPermissions(activity))
    }

    fun getActivityPermissionsGranted(activity: Activity): Array<String> {
      return getPermissionsGranted(activity, getActivityPermissions(activity))
    }

    fun loadAllPermissions(activity: Activity, requestCode: Int) {
      val permissions = getAllPermissions(activity)
      ActivityCompat.requestPermissions(activity, permissions, requestCode)
    }

    fun loadActivityPermissions(activity: Activity, requestCode: Int) {
      val permissions = getActivityPermissions(activity)
      ActivityCompat.requestPermissions(activity, permissions, requestCode)
    }

    fun loadSelectedPermissions(activity: Activity, requestCode: Int, permissions: Array<String>) {
      ActivityCompat.requestPermissions(activity, permissions, requestCode)
    }

    fun loadSelectedPermission(activity: Activity, requestCode: Int, permission: String) {
      val permissions = arrayOf(permission)
      ActivityCompat.requestPermissions(activity, permissions, requestCode)
    }
  }
}