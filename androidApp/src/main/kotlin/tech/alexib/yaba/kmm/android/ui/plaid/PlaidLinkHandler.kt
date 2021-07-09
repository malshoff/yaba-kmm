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

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.runtime.Composable
import com.plaid.link.OpenPlaidLink
import com.plaid.link.PlaidActivityResultContract
import com.plaid.link.configuration.LinkTokenConfiguration
import com.plaid.link.result.LinkResult

@OptIn(PlaidActivityResultContract::class)
@Composable
fun PlaidLinkHandler(
    onResult: (LinkResult) -> Unit,
    content: @Composable (ActivityResultLauncher<LinkTokenConfiguration>) -> Unit
) {
    val linkLauncher = rememberLauncherForActivityResult(contract = OpenPlaidLink()) {
        onResult(it)
    }
    content(linkLauncher)
}