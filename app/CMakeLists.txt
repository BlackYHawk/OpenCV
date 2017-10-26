# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.
#设置OpenCv的路径变量
set(project G:\\android-studio\\OpenCV)
set(openCv G:\\OpenCV\\OpenCV-android-sdk)
cmake_minimum_required(VERSION 3.4.1)
#支持-std=gnu++11
set(CMAKE_VERBOSE_MAKEFILE on)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

#配置加载native依赖
include_directories(${openCv}/sdk/native/jni/include)#包含掉OpenCv的头文件目录
#动态方式加载
add_library(lib_opencv STATIC IMPORTED) #表示创建一个导入库，静态方式
#引入libopencv_java3.so文件
set_target_properties(lib_opencv
                       PROPERTIES
                       IMPORTED_LOCATION ${project}/app/src/main/jniLibs/${ANDROID_ABI}/libopencv_java3.so)

add_library( # Sets the name of the library.
             native-lib

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/native-lib.cpp )

target_link_libraries( # Specifies the target library.
                       native-lib log android -ljnigraphics lib_opencv
                       # Links the target library to the log library
                       # included in the NDK.
                       )