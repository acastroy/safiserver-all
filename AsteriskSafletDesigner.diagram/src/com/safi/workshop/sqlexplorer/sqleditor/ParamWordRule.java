package com.safi.workshop.sqlexplorer.sqleditor;

/*
 * Copyright (C) 2002-2004 Andrea Mazzolini
 * andreamazzolini@users.sourceforge.net
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.Token;

public class ParamWordRule implements IRule {

  protected static final int UNDEFINED = -1;

  /** The word detector used by this rule */
  protected IWordDetector fDetector;

  /**
   * The default token to be returned on success and if nothing else has been specified.
   */
  protected IToken fDefaultToken = Token.UNDEFINED;
  private IToken paramToken;

  /** The column constraint */
  protected int fColumn = UNDEFINED;

  private StringBuffer fBuffer = new StringBuffer();

  public ParamWordRule(IWordDetector detector, IToken paramToken) {
    this.fDetector = detector;
    this.paramToken = paramToken;

  }

  public IToken evaluate(ICharacterScanner scanner) {
    int c = scanner.read();
    if (fDetector.isWordStart((char) c)) {
      if (fColumn == UNDEFINED || (fColumn == scanner.getColumn() - 1)) {

        fBuffer.setLength(0);
        do {
          fBuffer.append((char) c);
          c = scanner.read();
        } while (c != ICharacterScanner.EOF && fDetector.isWordPart((char) c));
        scanner.unread();

        String tokenName = fBuffer.substring(0, fBuffer.length()).toLowerCase();
        return paramToken;

      }
    }

    scanner.unread();
    return Token.UNDEFINED;
  }

  public void unreadBuffer(ICharacterScanner scanner) {
    for (int i = fBuffer.length() - 1; i >= 0; i--)
      scanner.unread();
  }

}
