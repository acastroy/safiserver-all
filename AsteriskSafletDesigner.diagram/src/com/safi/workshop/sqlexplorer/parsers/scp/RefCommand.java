/*
 * Copyright (C) 2007 SQL Explorer Development Team
 * http://sourceforge.net/projects/eclipsesql
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
package com.safi.workshop.sqlexplorer.parsers.scp;

import com.safi.workshop.sqlexplorer.parsers.ParserException;
import com.safi.workshop.sqlexplorer.parsers.Tokenizer;
import com.safi.workshop.sqlexplorer.parsers.Tokenizer.Token;
import com.safi.workshop.sqlexplorer.parsers.scp.StructuredCommentParser.CommandType;

/*package*/class RefCommand extends MacroNameCommand {
  protected EndrefCommand endref;

  public RefCommand(StructuredCommentParser parser, Token comment, Tokenizer tokenizer,
      CharSequence data) throws ParserException {
    super(parser, CommandType.REF, comment, tokenizer, data);
    if (tokens.size() != 1)
      throw new StructuredCommentException("ref has extra text after the macro name", comment);
  }

  @Override
  public String toString() {
    return "ref " + tokens.get(0);
  }
}