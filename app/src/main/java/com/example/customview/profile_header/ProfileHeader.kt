package com.example.customview.profile_header

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.customview.R

class ProfileHeader @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var avatar: ImageView
    private lateinit var userName: TextView

    init {
        val inflatedView = inflate(context, R.layout.profile_header, this)
        initViews(inflatedView)
    }

    fun render(profileHeaderData: ProfileHeaderData) {
        avatar.setImageDrawable(profileHeaderData.avatar)
        userName.text = profileHeaderData.userName
    }

    private fun initViews(inflatedView: View) {
        avatar = inflatedView.findViewById(R.id.profileAvatar)
        userName = inflatedView.findViewById(R.id.profileName)
    }
}



