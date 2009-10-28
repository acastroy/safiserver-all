package com.safi.workshop.sheet;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.dltk.internal.core.ScriptProject;

public class SafiScriptProject extends ScriptProject {

  public SafiScriptProject(IProject project, ModelElement parent) {
    super(project, parent);
    try {
      IProjectDescription projectDescription = project.getDescription();

      String[] ids = projectDescription.getNatureIds();
      boolean found = false;
      for (String id : ids) {
        if ("org.eclipse.dltk.javascript.core.nature".equals(id)) {
          found = true;
        }
      }
      if (!found) {
        String[] newIds = new String[ids.length + 1];
        System.arraycopy(ids, 0, newIds, 0, ids.length);
        newIds[ids.length] = "org.eclipse.dltk.javascript.core.nature";
        projectDescription.setNatureIds(newIds);
        project.setDescription(projectDescription, null);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    // TODO Auto-generated constructor stub

  }
  /*
   * public boolean isOnBuildpath(IModelElement element) { // IBuildpathEntry[]
   * rawBuildpath; // try { // rawBuildpath = getRawBuildpath(); // } catch
   * (ModelException e) { // return false; // not a script project // } // int elementType
   * = element.getElementType(); // boolean isFolderPath = false; // // boolean isSource =
   * false; // boolean isProjectFragment = false; // switch (elementType) { // case
   * IModelElement.SCRIPT_MODEL: // return false; // case IModelElement.SCRIPT_PROJECT: //
   * break; // case IModelElement.PROJECT_FRAGMENT: // isProjectFragment = true; // break;
   * // case IModelElement.SCRIPT_FOLDER: // isFolderPath = !((IProjectFragment)
   * element.getParent()) // .isArchive(); // break; // case IModelElement.SOURCE_MODULE:
   * // // isSource = true; // break; // default: // // isSource =
   * element.getAncestor(IModelElement.SOURCE_MODULE) != // // null; // break; // } //
   * IPath elementPath = element.getPath(); // // first look at unresolved entries // int
   * length = rawBuildpath.length; // for (int i = 0; i < length; i++) { //
   * IBuildpathEntry entry = rawBuildpath[i]; // switch (entry.getEntryKind()) { // case
   * IBuildpathEntry.BPE_LIBRARY: // case IBuildpathEntry.BPE_PROJECT: // case
   * IBuildpathEntry.BPE_SOURCE: // if (isOnBuildpathEntry(elementPath, isFolderPath, //
   * isProjectFragment, entry)) // return true; // break; // } // } // // no need to go
   * further for compilation units and elements inside a // // compilation unit // // it
   * can only be in a source folder, thus on the raw buildpath // // if (isSource) // //
   * return false; // // then look at resolved entries // for (int i = 0; i < length; i++)
   * { // IBuildpathEntry rawEntry = rawBuildpath[i]; // switch (rawEntry.getEntryKind())
   * { // case IBuildpathEntry.BPE_CONTAINER: // IBuildpathContainer container; // try {
   * // container = DLTKCore.getBuildpathContainer(rawEntry // .getPath(), this); // }
   * catch (ModelException e) { // break; // } // if (container == null) // break; //
   * IBuildpathEntry[] containerEntries = container // .getBuildpathEntries(this); // if
   * (containerEntries == null) // break; // // container was bound // for (int j = 0,
   * containerLength = containerEntries.length; j < containerLength; j++) { //
   * IBuildpathEntry resolvedEntry = containerEntries[j]; // if
   * (isOnBuildpathEntry(elementPath, isFolderPath, // isProjectFragment, resolvedEntry))
   * // return true; // } // break; // } // } // return false; return true; }
   * 
   * 
   * public boolean isOnBuildpath(IResource resource) { // IPath exactPath =
   * resource.getFullPath(); // IPath path = exactPath; // // ensure that folders are only
   * excluded if all of their children are // // excluded // int resourceType =
   * resource.getType(); // boolean isFolderPath = resourceType == IResource.FOLDER // ||
   * resourceType == IResource.PROJECT; // IBuildpathEntry[] buildpath; // try { //
   * buildpath = this.getResolvedBuildpath(); // } catch (ModelException e) { // return
   * false; // not a script project // } // for (int i = 0; i < buildpath.length; i++) {
   * // IBuildpathEntry entry = buildpath[i]; // IPath entryPath = entry.getPath(); // if
   * (entryPath.equals(exactPath)) { // package fragment roots must // // match exactly
   * entry pathes // // (no exclusion there) // return true; // } // if
   * (entryPath.isPrefixOf(path) // && !Util.isExcluded(path, ((BuildpathEntry) entry) //
   * .fullInclusionPatternChars(), // ((BuildpathEntry) entry) //
   * .fullExclusionPatternChars(), isFolderPath)) { // return true; // } // } // return
   * false; return true; }
   * 
   * private boolean isOnBuildpathEntry(IPath elementPath, boolean isFolderPath, boolean
   * isProjectFragment, IBuildpathEntry entry) { // IPath entryPath = entry.getPath(); //
   * if (isProjectFragment) { // // package fragment roots must match exactly entry pathes
   * (no // // exclusion there) // if (entryPath.equals(elementPath)) // return true; // }
   * else { // if (entryPath.isPrefixOf(elementPath) // && !Util.isExcluded(elementPath,
   * ((BuildpathEntry) entry) // .fullInclusionPatternChars(), // ((BuildpathEntry) entry)
   * // .fullExclusionPatternChars(), isFolderPath)) // return true; // } // return false;
   * return true; }
   */

}
