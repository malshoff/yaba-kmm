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
package tech.alexib.yaba.kmm.android.ui.auth.biometric

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Kermit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import tech.alexib.yaba.kmm.auth.SessionManagerAndroid

class BiometricSetupScreenViewModel : ViewModel(), KoinComponent {
    private val log: Kermit by inject { parametersOf("BiometricSetupScreenViewModel") }
    private val sessionManager: SessionManagerAndroid by inject()

    private val declined = MutableStateFlow(false)
    private val errorMessage = MutableStateFlow<String?>(null)
    private val setupSuccessful = MutableStateFlow(false)

    val state: Flow<BiometricSetupScreenState> =
        combine(
            setupSuccessful,
            errorMessage,
            declined
        ) { setupSuccessful, errorMessage, declined ->
            BiometricSetupScreenState(setupSuccessful, errorMessage, declined)
        }

    fun setupBiometrics() {
        viewModelScope.launch {
            sessionManager.setBioEnabled(true)
            sessionManager.promptForBiometrics().first().let {
                sessionManager.handleBiometricAuthResult(
                    it,
                    onSuccess = {
                        setupSuccessful.value = true
                    },
                    onError = {
                        errorMessage.value = "Failed to enroll biometric authentication"
                        declined.value = true
                    },
                    onCancel = {
                        declined.value = true
                    }
                )
            }
        }
    }
}
