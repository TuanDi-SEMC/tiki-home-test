package com.goth4m.tiki.ui.home

/**
 * Created by TuanTM on 5/20/20.
 */

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import org.koin.android.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass


abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : Fragment() {
    private var _binding: T? = null

    var init: Boolean = true
    var contentView: View? = null
    val binding
        get() = _binding!!

    lateinit var navController: NavController


    abstract fun initView()
    abstract fun getLayoutId(): Int

    val mViewModel: V by lazy { getViewModel(clazz) }

    abstract val clazz: KClass<V>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (contentView == null) {
            _binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
            setVariableBinding()
            contentView = binding.root
        }
        return contentView
    }


    open fun setVariableBinding() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (init) {
            navController = Navigation.findNavController(view)
            initView()
            init = false
        }
    }
}