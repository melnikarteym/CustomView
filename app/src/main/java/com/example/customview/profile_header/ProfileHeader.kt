package com.example.customview.profile_header

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding
import com.example.customview.R
import com.example.customview.dpToPx

class ProfileHeader @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var avatar: ImageView
    private lateinit var userName: TextView

    init {
        /*
        //magic
        gravity = Gravity.CENTER
        setPadding(PADDING_IN_DP.dpToPx(context))
        */
        val inflatedView = inflate(context, R.layout.profile_header, this)
        initViews(inflatedView)
        setupViewsIfNeeded(context, attrs)
    }

    fun render(profileHeaderData: ProfileHeaderData) {
        avatar.setImageDrawable(profileHeaderData.avatar)
        userName.text = profileHeaderData.userName
    }

    private fun initViews(inflatedView: View) {
        avatar = inflatedView.findViewById(R.id.profileAvatar)
        userName = inflatedView.findViewById(R.id.profileName)
    }

    private fun setupViewsIfNeeded(context: Context, attrs: AttributeSet?) {
        if (attrs == null) return
        context.obtainStyledAttributes(attrs, R.styleable.ProfileHeader, 0, 0).apply {
            try {
                avatar.setImageDrawable(getDrawable(R.styleable.ProfileHeader_profileAvatar))
                userName.text = getString(R.styleable.ProfileHeader_profileUserName)
            } finally {
                recycle()
            }
        }
    }

    private companion object {

        const val PADDING_IN_DP = 8
    }
}




