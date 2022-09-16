package com.example.assignment.ShowcaseFragment

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import com.example.assignment.R
import com.example.assignment.databinding.FragmentShowcaseBinding

class ShowcaseFragment : Fragment() {
    lateinit var binding:FragmentShowcaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if(binding.webview.canGoBack()){
                    binding.webview.goBack()
                } else {
                    isEnabled = false
                    requireActivity().onBackPressed()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this,callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding=DataBindingUtil.inflate(inflater,R.layout.fragment_showcase, container, false)

        binding.webview.loadUrl("https://www.webtonative.com/showcase")
        binding.webview.setWebViewClient(object : WebViewClient(){

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                binding.progress.visibility=View.VISIBLE
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                binding.progress.visibility=View.GONE
                super.onPageFinished(view, url)
            }

        })

        return binding.root
    }

}