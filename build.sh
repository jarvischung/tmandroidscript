#!/bin/bash

export LDFLAGS="-L /usr/lib/i386-linux-gnu/"

#Build Utils
pushd Utils
ant
popd

#Build Common
pushd Common
ant
popd

#Build Facafe
pushd BluetoothFacade
ant
popd
pushd SignalStrengthFacade
ant
popd
pushd TextToSpeechFacade
ant
popd
pushd WebCamFacade
ant
popd

#Build ScriptingLayer 
pushd ScriptingLayer
ant
popd

#Build QuickAction (For Android project)
pushd QuickAction
ant release
popd

#Build ScriptingLayerForAndroid (For Android project)
pushd ScriptingLayerForAndroid
ant release
#adb install -r ./bin/ScriptingLayerForAndroid-release.apk
cp ./bin/ScriptingLayerForAndroid-release.apk ../InstallFolder/
popd

#Build PythonForAndroid (For Android project)
pushd PythonForAndroid
ant release
cp ./bin/PythonForAndroid-release.apk ../InstallFolder/
popd
