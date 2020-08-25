package com.droidafricana.cleanarchitecturecrypto.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.droidafricana.cleanarchitecturecrypto.R
import com.droidafricana.cleanarchitecturecrypto.models.CryptoUiModel
import com.droidafricana.cleanarchitecturecrypto.ui.CryptoAdapter.CryptoUiModelViewHolder
import com.droidafricana.cleanarchitecturecrypto.utils.CryptoUiModelDiffCallback
import kotlinx.android.synthetic.main.crypto_item.view.*

class CryptoAdapter :
    ListAdapter<CryptoUiModel, CryptoUiModelViewHolder>(CryptoUiModelDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoUiModelViewHolder {
        return CryptoUiModelViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CryptoUiModelViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CryptoUiModelViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: CryptoUiModel) = with(itemView) {
            this.tv_crypto_name.text = item.name
            this.tv_crypto_symbol.text = item.symbol
            this.tv_crypto_id.text = item.id
        }

        companion object {
            fun from(parent: ViewGroup): CryptoUiModelViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.crypto_item, parent, false)
                return CryptoUiModelViewHolder(view)
            }
        }
    }
}
