// IGNORE_BACKEND_K1: JS, JS_IR, JS_IR_ES6, WASM
// IGNORE_NATIVE_K1: mode=ONE_STAGE_MULTI_MODULE
// !LANGUAGE: +MultiPlatformProjects

// MODULE: common
// TARGET_PLATFORM: Common
// FILE: common.kt

enum class Base1 { O }

expect enum class Base2 { K }

fun k() = Base2.K.name

// MODULE: platform()()(common)
// FILE: platform.kt

actual enum class Base2 { K }

fun box() = Base1.O.name + k()