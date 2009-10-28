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
import com.safi.workshop.sqlexplorer.parsers.Tokenizer.TokenType;
import com.safi.workshop.sqlexplorer.parsers.scp.StructuredCommentParser.CommandType;

/*package*/abstract class MacroNameCommand extends Command {
  protected String macroName;

  public MacroNameCommand(StructuredCommentParser parser, CommandType commandType, Token comment,
      Tokenizer tokenizer, CharSequence data) throws ParserException {
    super(parser, commandType, comment, tokenizer, data);
    if (tokens.size() == 0)
      throw new StructuredCommentException(commandType + " is missing a macro name", comment);
    Token token = tokens.getFirst();
    if (token.getTokenType() != TokenType.WORD)
      throw new StructuredCommentException("Macro names must be valid identifiers", comment);
    macroName = token.toString();
  }

}