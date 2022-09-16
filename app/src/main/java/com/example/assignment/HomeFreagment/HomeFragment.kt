package com.example.assignment.HomeFreagment

import android.content.DialogInterface
import android.graphics.Bitmap
import android.os.Bundle
import android.view.*
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.assignment.R
import com.example.assignment.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if(binding.webwiew.canGoBack()){
                    binding.webwiew.goBack()
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
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)

        binding.webwiew.loadUrl("https://www.webtonative.com/")
        binding.webwiew.setWebViewClient(object :WebViewClient(){

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