package com.arianjalarang.overtime;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.ValueCallback;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;

public class MainActivity extends Activity {
  private WebView web;
  @Override public void onCreate(Bundle b) { super.onCreate(b); web = new WebView(this); setContentView(web); WebSettings s=web.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true); s.setAllowFileAccess(true); s.setAllowContentAccess(true); s.setSupportZoom(false); web.setWebViewClient(new WebViewClient(){ @Override public boolean shouldOverrideUrlLoading(WebView v, WebResourceRequest r){ String u=r.getUrl().toString(); if(u.startsWith("http://")||u.startsWith("https://")){ if(u.contains("127.0.0.1")||u.contains("localhost")) return false; try { startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(u))); } catch(Exception e){} return true; } return false; }}); web.setWebChromeClient(new WebChromeClient()); web.loadUrl("file:///android_asset/index.html"); }
  @Override public void onBackPressed(){ if(web!=null && web.canGoBack()) web.goBack(); else super.onBackPressed(); }
}
