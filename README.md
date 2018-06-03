# AutoPermissions

Android library to get permissions with a simple line of code

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