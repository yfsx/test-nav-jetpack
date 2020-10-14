package com.yfsx.navigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.yfsx.base.fragment.BaseFragment
import com.yfsx.navigation.R
import kotlinx.android.synthetic.main.fragment_main_1.*

class MainFragment1 : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButton()
    }

    private fun initButton() {
        btn_move_to_fragment.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment1_to_mainFragment4)
        }
    }
}