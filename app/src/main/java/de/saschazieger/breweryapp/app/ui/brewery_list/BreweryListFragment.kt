package de.saschazieger.breweryapp.app.ui.brewery_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import de.saschazieger.breweryapp.R
import de.saschazieger.breweryapp.app.ui.brewery_details.BreweryDetailsFragment.Companion.SER_BREWERY_ID
import org.koin.android.ext.android.inject

class BreweryListFragment : Fragment() {

    private val breweryListViewModel: BreweryListViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner)
        )
        setContent {
            BreweryListScreen(breweryListViewModel) { brewery ->
                val bundle = Bundle()
                bundle.putString(SER_BREWERY_ID, brewery.id)
                findNavController().navigate(R.id.breweryDetailsFragment, bundle)
            }
        }
    }
}

