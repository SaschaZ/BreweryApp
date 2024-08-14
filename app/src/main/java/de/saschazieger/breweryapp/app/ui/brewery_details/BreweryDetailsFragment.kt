package de.saschazieger.breweryapp.app.ui.brewery_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import de.saschazieger.breweryapp.app.theme.BreweryAppTheme
import de.saschazieger.breweryapp.app.ui.common.LoadingIndicator
import org.koin.android.ext.android.inject

class BreweryDetailsFragment : Fragment() {

    companion object {
        const val SER_BREWERY_ID = "brewery_id"
    }

    private val breweryDetailsViewModel: BreweryDetailsViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner)
        )
        setContent {
            BreweryAppTheme {
                Surface {
                    arguments?.getString(SER_BREWERY_ID)?.let { id ->
                        val brewery = breweryDetailsViewModel.getBrewery(id).collectAsState(null)
                        brewery.value?.let {
                            BreweryDetailsScreen(it)
                        } ?: Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            LoadingIndicator()
                        }
                    }
                }
            }
        }
    }
}