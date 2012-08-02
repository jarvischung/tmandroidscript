#!/bin/bash

#Clean all libs
#Build Utils
pushd Utils
ant clean
popd

#Build Common
pushd Common
ant clean
popd

#Build Facafe
pushd BluetoothFacade
ant clean
popd
pushd SignalStrengthFacade
ant clean
popd
pushd TextToSpeechFacade
ant clean
popd
pushd WebCamFacade
ant clean
popd

#Build ScriptingLayer 
pushd ScriptingLayer
ant clean
popd

#Build QuickAction (For Android project)
pushd QuickAction
ant clean
popd

#Build ScriptingLayerForAndroid (For Android project)
pushd ScriptingLayerForAndroid
ant clean
popd

#Build PythonForAndroid (For Android project)
pushd PythonForAndroid
ant clean
popd
