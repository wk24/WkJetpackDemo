package com.wuk.jetpackdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wuk.jetpackdemo.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {

    lateinit var inflate:FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflate = DataBindingUtil.inflate<FragmentBlankBinding>(
            inflater,
            R.layout.fragment_blank,
            container,
            false
        )
        return inflate.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val userModel = ViewModelProvider(requireActivity()).get(UserModel::class.java)
        userModel.mUserLiveData.observe(requireActivity(), Observer {
            inflate.tvName.setText(it.age.toString())
        })
    }

}