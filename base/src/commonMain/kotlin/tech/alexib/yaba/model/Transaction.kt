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
@file:UseSerializers(UuidSerializer::class)

package tech.alexib.yaba.model

import com.benasher44.uuid.Uuid
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.UseSerializers
import tech.alexib.yaba.util.UuidSerializer

@Serializable
enum class TransactionType {
    DIGITAL,
    PLACE,
    SPECIAL,
    UNRESOLVED
}

@Serializable
data class Transaction(
    val id: Uuid,
    val accountId: Uuid,
    val name: String,
    val type: TransactionType,
    val amount: Double,
    val date: LocalDate,
    val category: String?,
    val subcategory: String?,
    val isoCurrencyCode: String?,
    val merchantName: String? = null,
    val pending: Boolean = false
) {
    companion object {}
}

@Serializable
data class TransactionDetail(
    @Contextual
    val id: Uuid,
    @Contextual
    val accountId: Uuid,
    val name: String,
    val type: TransactionType,
    val amount: Double,
    val date: LocalDate,
    val category: String?,
    val subcategory: String?,
    val isoCurrencyCode: String?,
    val pending: Boolean? = false,
    val merchantName: String? = null,
    val institutionName: String,
    val accountName: String,
    val accountMask: String,
) {
    @Transient
    val label = "$institutionName \n $accountName ****$accountMask"
}

// object TransactionStubs {
//
//    val transactions: List<Transaction> = jSerializer.decodeFromString(transactionsJson)
//    val transaction = transactions.first()
//
//    val transactionDetail: TransactionDetail = jSerializer.decodeFromString(detailStub)
// }
