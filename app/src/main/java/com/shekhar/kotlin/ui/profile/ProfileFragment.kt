package com.shekhar.kotlin.ui.profile

import android.os.Bundle
import android.view.View
import com.shekhar.kotlin.dagger.databinding.FragmentProfileBinding
import com.shekhar.kotlin.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>()  {


//    private val connectViewModel: ConnectViewModel by viewModels()

    override fun observeViewModel() {

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewBinding

    }

    override fun getViewBinding(): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(layoutInflater)
    }


}