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
package tech.alexib.yaba.data.db.sqldelight

import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.TransactionWithoutReturn
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

// all credit to https://github.com/touchlab/KaMPKit

suspend fun Transacter.transactionWithContext(
    coroutineContext: CoroutineContext,
    noEnclosing: Boolean = false,
    body: TransactionWithoutReturn.() -> Unit
) {
    withContext(coroutineContext) {
        this@transactionWithContext.transaction(noEnclosing) {
            body()
        }
    }
}
