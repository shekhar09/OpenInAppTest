package com.shekhar.kotlin.ui.campaign

import android.os.Bundle
import android.view.View
import com.shekhar.kotlin.dagger.databinding.FragmentCampaignBinding
import com.shekhar.kotlin.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CampaignFragment : BaseFragment<FragmentCampaignBinding>()  {


//    private val connectViewModel: ConnectViewModel by viewModels()

    override fun observeViewModel() {

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewBinding

    }

    override fun getViewBinding(): FragmentCampaignBinding {
        return FragmentCampaignBinding.inflate(layoutInflater)
    }


}