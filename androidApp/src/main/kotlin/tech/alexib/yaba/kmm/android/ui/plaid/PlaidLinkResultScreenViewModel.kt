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
package tech.alexib.yaba.kmm.android.ui.plaid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Kermit
import com.benasher44.uuid.Uuid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import tech.alexib.yaba.kmm.data.api.PlaidItemApi
import tech.alexib.yaba.kmm.data.repository.ItemRepository

class PlaidLinkResultScreenViewModel : ViewModel(), KoinComponent {

    private val plaidItemApi: PlaidItemApi by inject()
    private val itemRepository: ItemRepository by inject()

    lateinit var itemId: Uuid
    private val log: Kermit by inject { parametersOf("PlaidLinkResultScreenViewModel") }
    private val accountsFlow = MutableStateFlow<List<PlaidLinkScreenResult.Account>>(emptyList())

    private val loadingFlow = MutableStateFlow(false)
    val loading: StateFlow<Boolean>
        get() = loadingFlow
    private val shouldNavigateHomeFlow = MutableStateFlow(false)
    val shouldNavigateHome: StateFlow<Boolean>
        get() = shouldNavigateHomeFlow
    val accounts: StateFlow<List<PlaidLinkScreenResult.Account>>
        get() = accountsFlow

    fun init(plaidLinkScreenResult: PlaidLinkScreenResult) {
        itemId = plaidLinkScreenResult.id
        accountsFlow.value = plaidLinkScreenResult.accounts
    }

    fun setAccountShown(plaidAccountId: String, show: Boolean) {
        val currentAccounts = accountsFlow.value.toMutableList()
        val currentItem = currentAccounts.first { it.plaidAccountId == plaidAccountId }
        currentAccounts[currentAccounts.indexOf(currentItem)] = currentItem.copy(show = show)
        accountsFlow.value = currentAccounts
    }

    fun submitAccountsToHide() {
        loadingFlow.value = true
        val accountsToHide = accountsFlow.value.filter { !it.show }.map { it.plaidAccountId }
        plaidItemApi.setAccountsToHide(itemId, accountsToHide)
        viewModelScope.launch(Dispatchers.Default) {
            delay(2_000)
            log.d { "delayed" }
            val result = itemRepository.newItemData(itemId)
            log.d { "got result $result" }
            loadingFlow.emit(false)
            shouldNavigateHomeFlow.emit(result)
        }
    }
}
