#!/bin/bash

adb install -r ./InstallFolder/ScriptingLayerForAndroid-release.apk

adb install -r ./InstallFolder/PythonForAndroid-release.apk

adb push ./InstallFolder/python.zip /sdcard/download/

adb push ./InstallFolder/python_extras_r14.zip /sdcard/download/

#Decompress python.zip and python_extras_r14.zip for android-script use.
adb shell am start -n com.googlecode.pythonforandroid/.CreateFilesFolderService

#Python testing for Android.
#adb push ./InstallFolder/android_python.sh /sdcard/com.googlecode.pythonforandroid/
#adb push ./InstallFolder/hello.py /sdcard/com.googlecode.pythonforandroid/
#adb shell sh /sdcard/com.googlecode.pythonforandroid/android_python.sh /sdcard/com.googlecode.pythonforandroid/hello.py
