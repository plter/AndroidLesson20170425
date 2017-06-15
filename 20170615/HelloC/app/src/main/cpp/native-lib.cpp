#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jint JNICALL
Java_top_yunp_helloc_MainActivity_getIntValue(JNIEnv *env, jobject instance) {
    return 100;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_top_yunp_helloc_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
