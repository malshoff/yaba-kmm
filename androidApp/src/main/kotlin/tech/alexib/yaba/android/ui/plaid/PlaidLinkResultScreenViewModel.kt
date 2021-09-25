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
package tech.alexib.yaba.android.ui.plaid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benasher44.uuid.Uuid
import kotlinx.coroutines.Dispatchers
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import tech.alexib.yaba.data.store.PlaidLinkResultScreenState
import tech.alexib.yaba.data.store.PlaidLinkResultStore
import tech.alexib.yaba.data.store.PlaidLinkScreenResult
import tech.alexib.yaba.util.stateInDefault

class PlaidLinkResultScreenViewModel : ViewModel(), KoinComponent {
    private val store: PlaidLinkResultStore by inject { parametersOf(Dispatchers.Main) }

    val state = store.state.stateInDefault(viewModelScope, PlaidLinkResultScreenState.Empty)

    fun init(accounts: List<PlaidLinkScreenResult.Account>, itemId: Uuid) {
        store.init(itemId, accounts)
    }

    fun submit(action: PlaidLinkResultStore.Action) {
        store.submit(action)
    }
}
