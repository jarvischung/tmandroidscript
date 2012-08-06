!/bin/bash

#Python testing for Android.
adb push ./InstallFolder/android_python.sh /sdcard/com.googlecode.pythonforandroid/
adb push ./InstallFolder/hello.py /sdcard/com.googlecode.pythonforandroid/
adb shell sh /sdcard/com.googlecode.pythonforandroid/android_python.sh /sdcard/com.googlecode.pythonforandroid/hello.py
