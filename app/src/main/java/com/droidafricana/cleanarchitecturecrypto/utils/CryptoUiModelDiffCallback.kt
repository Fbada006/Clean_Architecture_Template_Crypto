package com.droidafricana.cleanarchitecturecrypto.utils

import androidx.recyclerview.widget.DiffUtil
import com.droidafricana.cleanarchitecturecrypto.models.CryptoUiModel

class CryptoUiModelDiffCallback : DiffUtil.ItemCallback<CryptoUiModel>() {
    override fun areItemsTheSame(oldItem: CryptoUiModel, newItem: CryptoUiModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CryptoUiModel, newItem: CryptoUiModel): Boolean {
        return oldItem == newItem
    }
}
