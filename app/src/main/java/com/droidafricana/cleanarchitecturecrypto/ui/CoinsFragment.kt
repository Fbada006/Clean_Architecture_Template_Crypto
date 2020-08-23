package com.droidafricana.cleanarchitecturecrypto.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.droidafricana.cleanarchitecturecrypto.R

class CoinsFragment : Fragment() {

    private val viewModel: CoinsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.coins_fragment, container, false)
    }

}
