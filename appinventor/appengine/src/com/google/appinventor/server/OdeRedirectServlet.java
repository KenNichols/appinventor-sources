// Copyright 2008 Google Inc. All Rights Reserved.

package com.google.appinventor.server;

import com.google.appinventor.shared.rpc.ServerLayout;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Redirects requests to either the ODE main page or, if requested from
 * an Android device, to the executable download page.
 *
 */
public class OdeRedirectServlet extends OdeServlet {
  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
    if (req.getHeader("user-agent").contains("Android")) {
      res.sendRedirect(ServerLayout.ODE_BASEURL + ServerLayout.ANDROID_SERVLET);
    } else {
      res.sendRedirect(ServerLayout.ODE_BASEURL + Server.START_PAGE);
    }
    res.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
  }
}