package tech.alexib.yaba.kmm.android.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel
import tech.alexib.yaba.kmm.android.ui.AddSpace
import tech.alexib.yaba.kmm.android.ui.components.TransactionItem
import tech.alexib.yaba.kmm.android.ui.theme.MoneyGreen
import tech.alexib.yaba.kmm.android.util.rememberFlowWithLifecycle
import tech.alexib.yaba.kmm.model.Transaction
import java.text.DecimalFormat

@Immutable
data class HomeScreenState(
    val loading: Boolean = false,
    val error: String? = null,
    val currentCashBalance: Double = 0.0,
    val recentTransactions: List<Transaction> = emptyList()
) {
    companion object {
        val Empty = HomeScreenState()
    }
}

sealed class HomeScreenAction {
    object NavigateToPlaidLinkScreen : HomeScreenAction()
}

@Composable
fun Home(
    navigateToPlaidLinkScreen: () -> Unit
) {

    val viewModel: HomeViewModel = getViewModel()

    Home(viewModel = viewModel) {
        navigateToPlaidLinkScreen()
    }

}


@Composable
private fun Home(
    viewModel: HomeViewModel,
    navigateToPlaidLinkScreen: () -> Unit
) {
    viewModel.init()
    val state by rememberFlowWithLifecycle(flow = viewModel.state).collectAsState(initial = HomeScreenState.Empty)

    Home(state) { action ->
        when (action) {
            is HomeScreenAction.NavigateToPlaidLinkScreen -> navigateToPlaidLinkScreen()
        }
    }
}

@Composable
private fun Home(
    state: HomeScreenState,
    actioner: (HomeScreenAction) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        AddSpace()

        if (state.currentCashBalance == 0.0) {
            Button(onClick = {
                actioner(HomeScreenAction.NavigateToPlaidLinkScreen)
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Link your first account", style = MaterialTheme.typography.button)
            }
        } else {
            TotalCashBalanceRow(state.currentCashBalance)
            AddSpace()
            RecentTransactions(transactions = state.recentTransactions) {

            }
        }

    }
}

@Composable
fun TotalCashBalanceRow(
    balance: Double
) {
    val isPositive = balance > 0
    Card(
        modifier = Modifier
            .wrapContentHeight(Alignment.CenterVertically),
        elevation = 3.dp
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                Text(text = "Current cash balance")
                Text(
                    text = "$${moneyFormat.format(balance)}",
                    color = if (isPositive) MoneyGreen else Color.Red,
                    textAlign = TextAlign.End
                )
            }

        }
    }

}

@Composable
fun RecentTransactions(
    transactions: List<Transaction>,
    onSelectAllTransactions: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .padding(16.dp), elevation = 3.dp
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
//only pulls 5 transactions
            transactions.forEach {
                Row {
                    TransactionItem(transaction = it)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(onClick = { onSelectAllTransactions() }) {
                    Text(text = "View all transactions")
                }
            }
        }
    }
}

val moneyFormat = DecimalFormat("#,###.00")