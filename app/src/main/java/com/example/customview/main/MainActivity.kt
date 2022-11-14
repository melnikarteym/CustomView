package com.example.customview.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.customview.R
import com.example.customview.profile_header.ProfileHeader
import com.example.customview.profile_header.ProfileHeaderData

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val profileHeader: ProfileHeader by lazy(LazyThreadSafetyMode.NONE) { findViewById(R.id.profileHeader) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profileHeader.render(
            ProfileHeaderData(
                avatar = null,
                userName = "Artem"
            )
        )
    }

    private fun render(state: MainProfileUiState) {
        /*

         */
        profileHeader.render(state.profileHeaderData)
        /*

         */
    }
}
