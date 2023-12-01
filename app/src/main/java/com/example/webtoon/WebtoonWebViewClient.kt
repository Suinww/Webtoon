package com.example.webtoon

import android.graphics.Bitmap
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class WebtoonWebViewClient(
    private val progressBar: ProgressBar,
    private val saveData:(String)-> Unit
    ) : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
//    https://comic.naver.com/webtoon/detail?titleId=641253&no=455&week=fri
        if (request != null ){
            if(
                request.url.toString().contains("comic.naver.com/webtoon/detail")  ||
                request.url.toString().contains("view.ridibooks.com/books/")||
                request.url.toString().contains("webtoon.kakao.com/viewer/")
            ) {
            saveData(request.url.toString())
        }
        }
        return super.shouldOverrideUrlLoading(view, request)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)

        progressBar.visibility = View.GONE
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        progressBar.visibility = View.VISIBLE
    }
    //에러페이지 띄우기
//    override fun onReceivedError(
//        view: WebView?,
//        request: WebResourceRequest?,
//        error: WebResourceError?
//    ) {
//        super.onReceivedError(view, request, error)
//    }
}