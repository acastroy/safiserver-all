package com.safi.workshop.audio.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.safi.db.server.config.Prompt;
import com.safi.db.server.config.SafletProject;

public class PromptCache {
  public static List<Prompt> sharedPromptCache;
  public static List<Prompt> systemPromptCache;
  public final static Map<Integer, List<Prompt>> projectPromptCache = new HashMap<Integer, List<Prompt>>();
  public static List<SafletProject> projectCache;

  public static void clear() {
    sharedPromptCache = null;
    systemPromptCache = null;
    projectCache = null;
    projectPromptCache.clear();
  }
}
