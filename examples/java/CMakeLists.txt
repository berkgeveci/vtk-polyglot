cmake_minimum_required(VERSION 3.12)
project(VTKCone Java)

find_package(Java REQUIRED)
include(UseJava)

# VTK_JAR must point to the VTK jar file
if(NOT VTK_JAR)
  message(FATAL_ERROR "VTK_JAR must be set to the path of the VTK jar file")
endif()

# VTK_NATIVE_DIR must point to the directory containing VTK JNI libraries
if(NOT VTK_NATIVE_DIR)
  message(FATAL_ERROR
    "VTK_NATIVE_DIR must be set to the VTK JNI native libraries directory")
endif()

add_jar(cone cone.java INCLUDE_JARS ${VTK_JAR})

# Create a run script
file(WRITE "${CMAKE_BINARY_DIR}/run.sh"
"#!/bin/bash
java -XstartOnFirstThread \\
  -cp ${CMAKE_BINARY_DIR}/cone.jar:${VTK_JAR} \\
  -Djava.library.path=${VTK_NATIVE_DIR} \\
  cone
")
file(CHMOD "${CMAKE_BINARY_DIR}/run.sh"
  PERMISSIONS OWNER_READ OWNER_WRITE OWNER_EXECUTE)
