#! /bin/sh

#export EXTERNAL_STORAGE=/mnt/sdcard/
#PYTHONPATH=/mnt/sdcard/com.googlecode.android_scripting/extras/python
am start -a com.googlecode.android_scripting.action.LAUNCH_SERVER -n com.googlecode.android_scripting/.activity.ScriptingLayerServiceLauncher --ei com.googlecode.android_scripting.extra.USE_SERVICE_PORT 35870
#PYTHONPATH=${PYTHONPATH}:/data/data/com.googlecode.pythonforandroid/files/python/lib/python2.6/lib-dynload
#export PYTHONPATH
#export TEMP=/mnt/storage/com.googlecode.pythonforandroid/extras/python/tmp
#export PYTHON_EGG_CACHE=$TEMP
#export PYTHONHOME=/data/data/com.googlecode.pythonforandroid/files/python
#export LD_LIBRARY_PATH=/data/data/com.googlecode.pythonforandroid/files/python/lib
#/data/data/com.googlecode.pythonforandroid/files/python/bin/python "$@"

export PY4A_EXTRAS=/mnt/sdcard/com.googlecode.pythonforandroid/extras/
export PATH=/sbin:/system/sbin:/system/bin:/system/xbin
export PYTHONPATH=/mnt/sdcard/com.googlecode.pythonforandroid/extras/python:/data/data/com.googlecode.pythonforandroid/files/python/lib/python2.6/lib-dynload:/data/data/com.googlecode.pythonforandroid/files/python/lib/python2.6
export PYTHONHOME=/data/data/com.googlecode.pythonforandroid/files/python
export LD_LIBRARY_PATH=/data/data/com.googlecode.pythonforandroid/files/python/lib
/data/data/com.googlecode.pythonforandroid/files/python/bin/python "$@"

#alias py="PY4A_EXTRAS=/mnt/sdcard/com.googlecode.pythonforandroid/extras/  PATH=/sbin:/system/sbin:/system/bin:/system/xbin  PYTHONPATH=/mnt/sdcard/com.googlecode.pythonforandroid/extras/python:/data/data/com.googlecode.pythonforandroid/files/python/lib/python2.6/lib-dynload:/data/data/com.googlecode.pythonforandroid/files/python/lib/python2.6 PYTHONHOME=/data/data/com.googlecode.pythonforandroid/files/python  LD_LIBRARY_PATH=/data/data/com.googlecode.pythonforandroid/files/python/lib  /data/data/com.googlecode.pythonforandroid/files/python/bin/python"
