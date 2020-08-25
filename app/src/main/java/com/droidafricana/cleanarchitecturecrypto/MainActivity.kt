package com.droidafricana.cleanarchitecturecrypto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

/**At the moment, this activity only shows the crypto fragment.
 * Modify this as you wish in line with the navigation component's functionality*/
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
