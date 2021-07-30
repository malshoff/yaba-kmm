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
package tech.alexib.yaba.di

import co.touchlab.kermit.Kermit
import co.touchlab.kermit.LogcatLogger
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module
import org.koin.dsl.module
import tech.alexib.yaba.di.CoreDependencies.ioDispatcherQualifier
import tech.alexib.yaba.di.CoreDependencies.mainDispatcherQualifier

actual val corePlatformModule: Module = module {
    val baseKermit = Kermit(LogcatLogger()).withTag("Yaba")
    factory { (tag: String?) -> if (tag != null) baseKermit.withTag(tag) else baseKermit }
    single<CoroutineDispatcher>(mainDispatcherQualifier) { Dispatchers.Main }
    single(ioDispatcherQualifier) { Dispatchers.IO }
}
