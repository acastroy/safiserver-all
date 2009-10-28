package com.safi.workshop.sheet;

import org.eclipse.core.resources.IFile;
import org.eclipse.dltk.core.IBuffer;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.internal.core.DefaultWorkingCopyOwner;
import org.eclipse.dltk.internal.core.ScriptFolder;
import org.eclipse.dltk.internal.core.SourceModule;
import org.eclipse.dltk.internal.ui.editor.SourceModuleDocumentProvider;

public class SafiSourceModuleDocumentProvider extends SourceModuleDocumentProvider {

  public SafiSourceModuleDocumentProvider() {
    // TODO Auto-generated constructor stub
  }

  @Override
  protected ISourceModule createSourceModule(IFile file) {
    // TODO Auto-generated method stub
    SourceModule mod = (SourceModule) super.createSourceModule(file);
    ScriptFolder folder = (ScriptFolder) mod.getParent();
    SourceModule newmod = new SourceModule(folder, mod.getElementName(),
        DefaultWorkingCopyOwner.PRIMARY) {
      @Override
      public IBuffer getBuffer() throws ModelException {
        // TODO Auto-generated method stub
        return super.getBuffer();
      }

      @Override
      protected char[] getBufferContent() throws ModelException {
        // TODO Auto-generated method stub
        char[] chars = super.getBufferContent();
        String text = SafiJSTextTools.getScriptText() + new String(chars);
        System.err.println("dadamatext " + text);
        return text.toCharArray();
      }

      @Override
      public char[] getContentsAsCharArray() {
        // TODO Auto-generated method stub
        try {
          return getBufferContent();
        } catch (ModelException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        return null;
      }

      @Override
      public char[] getSourceAsCharArray() throws ModelException {
        // TODO Auto-generated method stub
        return getBufferContent();
      }
    };
    return newmod;
  }

}
