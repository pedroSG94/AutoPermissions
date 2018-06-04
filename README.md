# AutoPermissions

[![Release](https://jitpack.io/v/pedroSG94/AutoPermissions.svg)](https://jitpack.io/#pedroSG94/AutoPermissions)

Android library to get permissions with a simple line of code

## Compile

To use this library in your project with gradle add this to your build.gradle:

```gradle
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
dependencies {
  compile 'com.github.pedroSG94:AutoPermissions:1.0.3'
}
```

## Use example

### Load all app permissions

Call library in code to pop up permissions:

Java:
```java
AutoPermissions.Companion.loadAllPermissions(activity, 1);
```

Kotlin:
```koltin
AutoPermissions.loadAllPermissions(activity, 1)
```

### Load activity permissions

Select permissions to load in manifest with metadata activity:
```xml
<activity
        android:name=".MainActivity"
        >
        <!--name: Must be always value of this string in the library.
        value: write all permission that you want request separates by ,-->
      <meta-data android:name="@string/permissions_loader_meta_key"
          android:value="android.permission.WRITE_EXTERNAL_STORAGE, android.permission.RECORD_AUDIO"/>
</activity> 
```
Call library in code to pop up permissions:

Java:
```java
AutoPermissions.Companion.loadActivityPermissions(activity, 1);
```

Kotlin:
```kotlin
AutoPermissions.loadActivityPermissions(activity, 1)
```

### Know permissions granted and permissions denied

Java:
```java
@Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    AutoPermissions.Companion.parsePermissions(activity, requestCode, permissions, listener);
  }
```

Kotlin:
```kotlin
override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    AutoPermissions.parsePermissions(activity, requestCode, permissions, listener)
}
```