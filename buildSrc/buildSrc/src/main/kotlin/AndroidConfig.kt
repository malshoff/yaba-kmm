/*
 * Copyright 2021 Alexi Bre
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:SuppressWarnings()

object AndroidConfig {
    private const val versionMajor = 1
    private const val versionMinor = 0
    private const val versionPatch = 1
    const val minSdk = 29
    const val targetSdk = 30
    val versionCode = generateVersionCode()
    const val versionName = "$versionMajor.$versionMinor.$versionPatch"
    const val compileSdk = 30
    const val buildToolsVersion = "31.0.0"

    private fun generateVersionCode(): Int {
        return minSdk * 10000000 + versionMajor * 10000 + versionMinor * 100 + versionPatch
    }
}
