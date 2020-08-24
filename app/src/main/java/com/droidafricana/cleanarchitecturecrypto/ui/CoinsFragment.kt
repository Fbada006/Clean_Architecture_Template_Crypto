package com.droidafricana.cleanarchitecturecrypto.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.droidafricana.cleanarchitecturecrypto.R
import com.droidafricana.cleanarchitecturecrypto.utils.Error
import com.droidafricana.cleanarchitecturecrypto.utils.Loading
import com.droidafricana.cleanarchitecturecrypto.utils.Success
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.coins_fragment.*
import timber.log.Timber

@AndroidEntryPoint
class CoinsFragment : Fragment(R.layout.coins_fragment) {

    private val viewModel: CoinsViewModel by viewModels()

    private lateinit var adapter: CryptoAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CryptoAdapter()

        crypto_list.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.getAllCoins()
        observeUiState()
        observeCryptoList()
    }

    private fun observeCryptoList() {
        viewModel.cryptoList.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    private fun observeUiState() {
        viewModel.uiState.observe(viewLifecycleOwner, {
            when (it) {
                is Loading -> {
                    // TODO
                    Timber.e("Loading ----------")
                }
                is Success -> {
                    // TODO
                    Timber.e("Success ----------")
                }
                is Error -> {
                    // TODO
                    Timber.e("Error ---------- ${it.error}")
                }
            }
        })
    }
}
